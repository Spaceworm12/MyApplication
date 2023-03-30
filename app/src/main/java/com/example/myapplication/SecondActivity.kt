package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var result = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {
            binding.tvResultTitle.text = savedInstanceState.getString(LAND_SAVE)
        }

        initClickListeners()

        binding.etResult.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (binding.etResult.length() > 2) {
                    binding.etResult.setText(s.toString().drop(1))
                    binding.etResult.setSelection(1)
                }
                if (binding.etResult.text.isNotBlank()) checkAndSetResult(binding.etResult.text.last().toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, binding.etResult.text.toString())
    }

    private fun checkAndSetResult(text: String) {
        when {
            binding.tvResultTitle.length() == 2 -> binding.tvResultTitle.text =
                String.format("%s%s", binding.tvResultTitle.text.drop(1), text)
            else ->  binding.tvResultTitle.text = String.format("%s%s",  binding.tvResultTitle.text, text)
        }
    }

    private fun initClickListeners() {
        binding.buttonOne.setOnClickListener { checkAndSetResult(binding.buttonOne.text.toString()) }
        binding.buttonTwo.setOnClickListener { checkAndSetResult( binding.buttonTwo.text.toString()) }
        binding.buttonThree.setOnClickListener { checkAndSetResult(binding.buttonThree.text.toString()) }
        binding.buttonFour.setOnClickListener { checkAndSetResult(binding.buttonFour.text.toString()) }
        binding.buttonFive.setOnClickListener { checkAndSetResult( binding.buttonFive.text.toString()) }
        binding.buttonSix.setOnClickListener { checkAndSetResult( binding.buttonSix.text.toString()) }

        binding.btClear.setOnClickListener { binding.tvResultTitle.text = ""
        binding.etResult.text.clear()
        }

        binding.btBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            result = binding.tvResultTitle.text.toString()
            intent.putExtra(PASS, result)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}
