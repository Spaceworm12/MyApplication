package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

internal const val PASS = "PASS"
internal const val LAND_SAVE = "LAND_SAVE"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var resultText: TextView
    private lateinit var buttonNextScreen: Button

    private var textResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            val s = intent!!.getStringExtra(PASS)
            resultText.text = s
        } else {
            resultText.text = resources.getString(R.string.error_text)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.tv_result)
        buttonNextScreen= findViewById(R.id.bt_next_screen)

        if (savedInstanceState != null) {
            resultText.text = savedInstanceState.getString(LAND_SAVE)
        }

        buttonNextScreen.setOnClickListener(this)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, resultText.text.toString())
    }

    override fun onClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        textResultLauncher.launch(intent)
    }
}
