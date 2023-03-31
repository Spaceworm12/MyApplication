package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


internal const val PASS = "PASS"
internal const val LAND_SAVE = "LAND_SAVE"
class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Следи за подсказками студии
    private lateinit var binding: ActivityMainBinding

    private var textResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            val s = intent!!.getStringExtra(PASS)
            binding.tvResult.text = s
        } else {
            binding.tvResult.text = resources.getString(R.string.error_text)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            binding.tvResult.text = savedInstanceState.getString(LAND_SAVE)
        }

        binding.btNextScreen.setOnClickListener(this)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAND_SAVE, binding.tvResult.text.toString())
    }

    override fun onClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        textResultLauncher.launch(intent)
    }
}
