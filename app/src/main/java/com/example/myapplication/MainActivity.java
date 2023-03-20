package com.example.myapplication;

import static java.util.jar.Pack200.Packer.PASS;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private static final String PASS = "KEY";
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.goToTheNextScreenButton);
        b.setOnClickListener(this);
    }

        public void onClick (View view){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE_SETTING_ACTIVITY);
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);

        if (requestCode == REQUEST_CODE_SETTING_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String resultString = data.getStringExtra(PASS);
                setData(resultString);
            }
        }
    }

    private void setData(String f) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(f);
    }
}
