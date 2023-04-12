package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        savedInstanceState?.let {
            binding.tvResultTitle.text = it.getString(LAND_SAVE) ?: "error"
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
                with(binding) {
                if (etResult.length() > 2) {
                    etResult.setText(s.toString().drop(1))
                    etResult.setSelection(1)
                }
                if (etResult.text.isNotBlank()) checkAndSetResult(
                    etResult.text.last().toString()
                )
            }
        }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, binding.tvResultTitle.text.toString())
    }

    private fun checkAndSetResult(text: String) {
        with(binding) {
            when {
                tvResultTitle.length() == 2 -> tvResultTitle.text =
                    String.format("%s%s", tvResultTitle.text.drop(1), text)
                else -> tvResultTitle.text =
                    String.format("%s%s", tvResultTitle.text, text)
            }
        }
    }

    private fun initClickListeners() {
        with(binding){
        buttonOne.setOnClickListener { checkAndSetResult(binding.buttonOne.text.toString()) }
        buttonTwo.setOnClickListener { checkAndSetResult(binding.buttonTwo.text.toString()) }
        buttonThree.setOnClickListener { checkAndSetResult(binding.buttonThree.text.toString()) }
        buttonFour.setOnClickListener { checkAndSetResult(binding.buttonFour.text.toString()) }
        buttonFive.setOnClickListener { checkAndSetResult(binding.buttonFive.text.toString()) }
        buttonSix.setOnClickListener { checkAndSetResult(binding.buttonSix.text.toString()) }
        btBack.setOnClickListener {
            tvResultTitle.text.toString().makeToast()
            requireActivity()
                .supportFragmentManager
                .popBackStack()
        }
        btClear.setOnClickListener {
            tvResultTitle.text = ""
            etResult.text.clear()}
        }
    }

    private fun String.makeToast() {
        if (this.isNotBlank()) {
            Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "you write nothing", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

