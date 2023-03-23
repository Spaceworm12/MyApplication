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

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PASS = "KEY";
    private String z = " ";
    Button ButtonOne;
    Button ButtonTwo;
    Button ButtonThree;
    Button ButtonFive;
    Button ButtonSix;
    Button ButtonFour;
    Button ButtonClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button b = (Button) findViewById(R.id.backToTheFirstScreen);
        b.setOnClickListener(this);
        ButtonTwo = (Button)findViewById(R.id.button_2);
        ButtonOne = (Button)findViewById(R.id.button_1);
        ButtonThree = (Button)findViewById(R.id.button_3);
        ButtonFour = (Button)findViewById(R.id.button_4);
        ButtonFive = (Button)findViewById(R.id.button_5);
        ButtonSix = (Button)findViewById(R.id.button_6);
        ButtonClear = (Button)findViewById(R.id.buttonClear);
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"1");

            }
        };
        ButtonOne.setOnClickListener(oclBtn1);
        View.OnClickListener oclBtn2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"2");

            }
        };
        ButtonTwo.setOnClickListener(oclBtn2);
        View.OnClickListener oclBtn3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"3");

            }
        };
        ButtonThree.setOnClickListener(oclBtn3);
        View.OnClickListener oclBtn4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"4");

            }
        };
        ButtonFour.setOnClickListener(oclBtn4);
        View.OnClickListener oclBtn5 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"5");

            }
        };
        ButtonFive.setOnClickListener(oclBtn5);
        View.OnClickListener oclBtn6 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"6");

            }
        };
        ButtonSix.setOnClickListener(oclBtn6);
        View.OnClickListener oclBtnclear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");

            }
        };
        ButtonClear.setOnClickListener(oclBtnclear);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView textView = findViewById(R.id.textView);
                textView.setText(s);
                z = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
public void onClick(View view) {
        TextView tw = findViewById(R.id.textView);
        Intent intent = new Intent(this, MainActivity.class);
         intent.putExtra(PASS, z);
         setResult(RESULT_OK, intent);
         this.finish();
        }
}


