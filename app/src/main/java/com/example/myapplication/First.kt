package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFirstBinding


internal const val LAND_SAVE = "com.example.myapplication.LAND_SAVE"

class FirstFragment : Fragment() {
    // First - название файла не соответствует содержимому

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            binding.tvResult.text = savedInstanceState.getString(LAND_SAVE)
        }

        binding.btNextScreen.setOnClickListener {
            requireActivity()
                .supportFragmentManager.apply {
                    this.beginTransaction()
                    .setCustomAnimations(
                        R.anim.enter_fragment,
                        R.anim.exit_fragment,
                        R.anim.enter_fragment_in,
                        R.anim.exit_fragment_out
                    )
                    .add(
                        R.id.fragment_container,
                        SecondFragment()
                    )
                    .addToBackStack("")
                    .commitAllowingStateLoss()
                }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, binding.tvResult.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
