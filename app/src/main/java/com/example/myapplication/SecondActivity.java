package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PASS = "KEY";
    private String z = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button b = (Button) findViewById(R.id.backToTheFirstScreen);
        b.setOnClickListener(this);
        EditText editText = findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView textView = findViewById(R.id.textView);
                textView.setText(s);
                z=s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(PASS,z);
        setResult(RESULT_OK, intent);
        this.finish();
    }

}