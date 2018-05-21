package com.example.harshit.spidertask1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button,button3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button = (Button) findViewById(R.id.button);

        textView = (TextView) findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(15000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textView.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        Toast.makeText(getApplicationContext(), "stopwatch  started", Toast.LENGTH_SHORT).show();


                        run();

                    }

                }.start();
            }

            public void run() {
                button3.performClick();


            }
        });

        Button  button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               launchactivity();
            }

            private void launchactivity() {Intent i = new Intent(MainActivity.this, stopwatch1.class);
                startActivity(i);
            }
        });

        }}