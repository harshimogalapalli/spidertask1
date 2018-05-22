package com.example.harshit.spidertask1;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private boolean isPaused=false;
    Button button,button3;
    TextView textView;
public CountDownTimer mycounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button = (Button) findViewById(R.id.button);
      final Button button3 = (Button) findViewById(R.id.button3);

        textView = (TextView) findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycounter=new CountDownTimer(15000, 1000) {
                    public void onTick(long millisUntilFinished) {


                        textView.setText("" + millisUntilFinished / 1000);
                        if (millisUntilFinished == 3000) {
                            ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                            tone.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);

                        }

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


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {mycounter.cancel();
            Intent intent=new Intent(v.getContext(),stopwatch1.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent,0);


            }


        });

        }}