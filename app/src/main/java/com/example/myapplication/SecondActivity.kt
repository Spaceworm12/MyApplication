package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySecondBinding

private lateinit var binding: ActivitySecondBinding
class SecondActivity : AppCompatActivity() {
    private var result = " "
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()

        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString(LAND_SAVE)
        }

        initClickListeners()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (editText.length() > 1) {
                    editText.setText(s.toString().drop(1))
                    editText.setSelection(1)
                }
                if (editText.text.isNotBlank()) checkAndSetResult(editText.text.last().toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, textView.text.toString())
    }

    private fun checkAndSetResult(text: String) {
        when {
            textView.length() == 2 -> textView.text = String.format("%s%s", textView.text.drop(1), text)
            else -> textView.text = String.format("%s%s", textView.text, text)
        }
    }

    private fun initViews() {
        textView = findViewById(R.id.tv_result_title)
        editText = findViewById(R.id.et_result)
        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)
        buttonFive = findViewById(R.id.button_five)
        buttonSix = findViewById(R.id.button_six)
        buttonFour = findViewById(R.id.button_four)
        buttonClear = findViewById(R.id.bt_clear)
        buttonBack = findViewById(R.id.bt_back)
    }

    private fun initClickListeners() {
        buttonOne.setOnClickListener { checkAndSetResult(buttonOne.text.toString()) }
        buttonTwo.setOnClickListener { checkAndSetResult(buttonTwo.text.toString()) }
        buttonThree.setOnClickListener { checkAndSetResult(buttonThree.text.toString()) }
        buttonFour.setOnClickListener { checkAndSetResult(buttonFour.text.toString()) }
        buttonFive.setOnClickListener { checkAndSetResult(buttonFive.text.toString()) }
        buttonSix.setOnClickListener { checkAndSetResult(buttonSix.text.toString()) }

        buttonClear.setOnClickListener { textView.text = "" }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            result = textView.text.toString()
            intent.putExtra(PASS, result)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}
