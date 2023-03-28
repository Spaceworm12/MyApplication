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
    private static final String PASS = "PASS";
    private String z = " ";
    String save;
    TextView textView;
    EditText editText;
    final static String LANDSAVE = "LANDSAVE";
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
        Button b = findViewById(R.id.backToTheFirstScreen);
        b.setOnClickListener(this);
        ButtonTwo = findViewById(R.id.button_2);
        ButtonOne = findViewById(R.id.button_1);
        ButtonThree = findViewById(R.id.button_3);
        ButtonFour = findViewById(R.id.button_4);
        ButtonFive = findViewById(R.id.button_5);
        ButtonSix = findViewById(R.id.button_6);
        ButtonClear = findViewById(R.id.buttonClear);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        if(savedInstanceState!=null){
            textView.setText(savedInstanceState.getString(LANDSAVE));
        }

        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_1));
            }
        };
        ButtonOne.setOnClickListener(oclBtn1);
        if (editText.length()>2){

        }
        View.OnClickListener oclBtn2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_2));
            }
        };
        ButtonTwo.setOnClickListener(oclBtn2);
        View.OnClickListener oclBtn3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_3));
            }
        };
        ButtonThree.setOnClickListener(oclBtn3);
        View.OnClickListener oclBtn4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_4));
            }
        };
        ButtonFour.setOnClickListener(oclBtn4);
        View.OnClickListener oclBtn5 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_5));
            }
        };
        ButtonFive.setOnClickListener(oclBtn5);
        View.OnClickListener oclBtn6 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit(findViewById(R.id.button_6));
            }
        };
        ButtonSix.setOnClickListener(oclBtn6);
        View.OnClickListener oclBtnclear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
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

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.length() > 2) {
                    StringBuilder builder = new StringBuilder(s);
                    builder.deleteCharAt(1);
                    builder.deleteCharAt(0);
                    editText.setText(builder);
                    editText.setSelection(1);
                }

            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        String save = textView.getText().toString();
        outState.putString("LANDSAVE", save);
    }
    public void Edit(Button f) {
        if (textView.length() <= 2) {
            textView.setText(textView.getText() + f.getText().toString());
        }
        if (textView.length() > 2) {
            StringBuilder build = new StringBuilder(textView.getText().toString());
            build.deleteCharAt(0);
            build.toString();
            textView.setText(build.substring(1));
        }
    }

public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        z=textView.getText().toString();
        intent.putExtra(PASS, z);
        setResult(RESULT_OK, intent);
        this.finish();
        }
}


