package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button b = (Button) findViewById(R.id.backToTheFirstScreen);
        b.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
    }
}