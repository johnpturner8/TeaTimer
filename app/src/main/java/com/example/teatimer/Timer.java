package com.example.teatimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Timer extends AppCompatActivity {
    long time = 0;
    long step = 0;
    boolean timerStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //gets the correct brew time
        Bundle b = getIntent().getExtras();
        if(b != null) {
            time = b.getLong("time");
            step = b.getLong("step");
        }

        TextView timeText = (TextView) findViewById(R.id.timerText);

        //show starting time
        timeText.setText((time / 60000) + ":" + (time / 1000 % 60 / 10) + (time / 1000 % 60 % 10));
    }

    //starts timer on button press
    public void startBrew(View view){
        if(!timerStarted) { //prevents 2 timers at once
            TextView timeText = (TextView) findViewById(R.id.timerText);
            timerStarted = true;

            //timer based on received parameters
            new CountDownTimer(time, 1000) {
                public void onTick(long millisUntilFinished) { //countdown updates
                    timeText.setText((millisUntilFinished / 60000) + ":" + (millisUntilFinished / 1000 % 60 / 10) + (millisUntilFinished / 1000 % 60 % 10));
                }

                public void onFinish() { //countdown finishes
                    //make a sound when timer finishes
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();

                    time += step;
                    timerStarted = false;

                    timeText.setText((time / 60000) + ":" + (time / 1000 % 60 / 10) + (time / 1000 % 60 % 10));
                }
            }.start();
        }
    }
}