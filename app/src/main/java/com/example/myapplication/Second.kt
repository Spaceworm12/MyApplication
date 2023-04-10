package ru.lesson.fragmentsample

import LAND_SAVE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (savedInstanceState != null) {
            binding.tvResultTitle.text = savedInstanceState.getString(LAND_SAVE)
        }
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
        binding.etResult.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.etResult.length() > 2) {
                    binding.etResult.setText(s.toString().drop(1))
                    binding.etResult.setSelection(1)
                }
                if (binding.etResult.text.isNotBlank()) checkAndSetResult(
                    binding.etResult.text.last().toString()
                )
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, binding.tvResultTitle.text.toString())
    }

    private fun checkAndSetResult(text: String) {
        when {
            binding.tvResultTitle.length() == 2 -> binding.tvResultTitle.text =
                String.format("%s%s", binding.tvResultTitle.text.drop(1), text)
            else -> binding.tvResultTitle.text =
                String.format("%s%s", binding.tvResultTitle.text, text)
        }
    }

    private fun initClickListeners() {
        binding.buttonOne.setOnClickListener { checkAndSetResult(binding.buttonOne.text.toString()) }
        binding.buttonTwo.setOnClickListener { checkAndSetResult(binding.buttonTwo.text.toString()) }
        binding.buttonThree.setOnClickListener { checkAndSetResult(binding.buttonThree.text.toString()) }
        binding.buttonFour.setOnClickListener { checkAndSetResult(binding.buttonFour.text.toString()) }
        binding.buttonFive.setOnClickListener { checkAndSetResult(binding.buttonFive.text.toString()) }
        binding.buttonSix.setOnClickListener { checkAndSetResult(binding.buttonSix.text.toString()) }
        binding.btBack.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .popBackStack()
        }
        binding.btClear.setOnClickListener {
            binding.tvResultTitle.text = ""
            binding.etResult.text.clear()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

