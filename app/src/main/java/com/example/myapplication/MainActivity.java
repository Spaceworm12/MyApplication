package com.example.myapplication;

import static java.util.jar.Pack200.Packer.PASS;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PASS = "KEY";
    String simb;
    private final static String NAME_KEY = "NAME_KEY";
    TextView ViewSimb;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    TextView textView = findViewById(R.id.textView);
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        String s = intent.getStringExtra(PASS);
                        textView.setText(s);
                    } else {
                        textView.setText("WRONG CODE");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.goToTheNextScreenButton);
        b.setOnClickListener(this);
        ViewSimb=findViewById(R.id.textView);

    }

    public void onClick(View view) {
        ViewSimb = findViewById(R.id.textView);
        String s = ViewSimb.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        mStartForResult.launch(intent);
    }

}
    

