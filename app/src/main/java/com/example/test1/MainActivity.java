package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textLevel;
    TextView textRightAnswered;
    TextView textQuestion;

    Button buttonOp1;
    Button buttonOp2;
    Button buttonOp3;
    Button buttonOp4;

    int level = 0;
    int great = 0;
    int rightAnswer = 0;
    String realOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        textLevel = findViewById(R.id.textQuestionNumber);
        textRightAnswered = findViewById(R.id.textRightAnswered);
        textQuestion = findViewById(R.id.textQuestion);

        buttonOp1 = findViewById(R.id.buttonOption1);
        buttonOp2 = findViewById(R.id.buttonOption2);
        buttonOp3 = findViewById(R.id.buttonOption3);
        buttonOp4 = findViewById(R.id.buttonOption4);

        textLevel.setText("QUESTION : " + level + " / 10");
        textRightAnswered.setText("NUMCORRECT : " + great + " / 10");

        if (level < 10) {
            getARandomQuestion();
        }
    }

    private void getARandomQuestion() {
        buttonOp1.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp2.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp3.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp4.setBackgroundResource(R.drawable.buttons_option_bg);

        // Get random numbers for the question
        int firstNumber = new Random().nextInt(10);
        int secondNumber = new Random().nextInt(10);

        // Get random operation (+, -, *)
        int operation = new Random().nextInt(3) + 1;

        // Get two options
        int optionA = new Random().nextInt(100);
        int optionB = new Random().nextInt(100);
        int optionC = new Random().nextInt(100);

        if (operation == 1) {
            realOperation = "+";
            rightAnswer = firstNumber + secondNumber;
            textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
        } else if (operation == 2) {
            realOperation = "*";
            rightAnswer = firstNumber * secondNumber;
            textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
        } else if (operation == 3) {
            realOperation = "-";
            if (firstNumber < secondNumber) {
                rightAnswer = secondNumber - firstNumber;
                textQuestion.setText(secondNumber + " " + realOperation + " " + firstNumber + " = ?");
            } else {
                rightAnswer = firstNumber - secondNumber;
                textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
            }
        }

        // Get random position for the right answer
        int position = new Random().nextInt(4) + 1;

        if (position == 1) {
            buttonOp1.setText(String.valueOf(rightAnswer));
            buttonOp2.setText(String.valueOf(optionA));
            buttonOp3.setText(String.valueOf(optionB));
            buttonOp4.setText(String.valueOf(optionC));
        } else if (position == 2) {
            buttonOp1.setText(String.valueOf(optionA));
            buttonOp2.setText(String.valueOf(rightAnswer));
            buttonOp3.setText(String.valueOf(optionB));
            buttonOp4.setText(String.valueOf(optionC));
        } else if (position == 3) {
            buttonOp1.setText(String.valueOf(optionA));
            buttonOp2.setText(String.valueOf(optionB));
            buttonOp3.setText(String.valueOf(rightAnswer));
            buttonOp4.setText(String.valueOf(optionC));
        } else {
            buttonOp1.setText(String.valueOf(optionA));
            buttonOp2.setText(String.valueOf(optionB));
            buttonOp3.setText(String.valueOf(optionC));
            buttonOp4.setText(String.valueOf(rightAnswer));
        }

        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonOp1.getText().equals(String.valueOf(rightAnswer))) {
                    buttonOp1.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    textRightAnswered.setText("NUMCORRECT : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    buttonOp1.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("NUMCORRECT", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonOp2.getText().equals(String.valueOf(rightAnswer))) {
                    buttonOp2.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    textRightAnswered.setText("NUMCORRECT : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    buttonOp2.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("NUMCORRECT", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonOp3.getText().equals(String.valueOf(rightAnswer))) {
                    buttonOp3.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    textRightAnswered.setText("NUMCORRECT : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    buttonOp3.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("NUMCORRECT", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });

        buttonOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonOp4.getText().equals(String.valueOf(rightAnswer))) {
                    buttonOp4.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    textRightAnswered.setText("NUMCORRECT : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("QUESTION : " + level + " / 10");
                    buttonOp4.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("NUMCORRECT", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });
    }
}


