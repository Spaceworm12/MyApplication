package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //удалить
        LinearLayout linearLayout = new LinearLayout(this);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);

        Button backToTheFirstScreen = findViewById(R.id.backToTheFirstScreen);

        backToTheFirstScreen.setOnClickListener(this);

    }

    public void onClick(View view) {
        int currentView = view.getId();
        //пример
        if (currentView == R.id.backToTheFirstScreen) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (currentView == R.id.thisIsImage) {
            //что-нибудь
        }
    }
}

