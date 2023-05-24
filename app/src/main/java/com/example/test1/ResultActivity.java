package com.example.test1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView textResult;
    int great;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        great = getIntent().getIntExtra("NUMCORRECT", 0);
        textResult = findViewById(R.id.textResult);

        textResult.setText("You answered " + great + " / 10");
    }
}
