package com.example.myapplication;

import static java.util.jar.Pack200.Packer.PASS;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.goToTheNextScreenButton);
        b.setOnClickListener(this);

//        if(getIntent() != null) {
//            String text = getIntent().getExtras().getString(PASS);
//            if (text == null) {
//                setData("");
//            } else {
//                setData(text);
//            }
//        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SETTING_ACTIVITY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK) {
            assert data != null;
            s = data.getExtras().getString(PASS);
            if (s == null) {
                setData("");
            } else {
                setData(s);
            }
        }
    }

    private void setData(String s) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(s);
    }
}
