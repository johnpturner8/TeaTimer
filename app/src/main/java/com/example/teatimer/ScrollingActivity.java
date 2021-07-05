package com.example.teatimer;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

public class ScrollingActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
    }

    public void startTimerBlack(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 5 * 60000, 0);
        }
        else{
            startTimer(view, 10 * 1000, 5 * 1000);
        }
    }

    public void startTimerGreen(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 3 * 60000, 0);
        }
        else{
            startTimer(view, 15 * 1000, 3 * 1000);
        }
    }

    public void startTimerOolong(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 5 * 60000, 0);
        }
        else{
            startTimer(view, 20 * 1000, 5 * 1000);
        }
    }

    public void startTimerRawPuEhr(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 4 * 60000, 0);
        }
        else{
            startTimer(view, 10 * 1000, 5 * 1000);
        }
    }

    public void startTimerRipePuEhr(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 4 * 60000, 0);
        }
        else{
            startTimer(view, 10 * 1000, 3 * 1000);
        }
    }

    public void startTimerWhite(View view){
        Switch brewSwitch = (Switch) findViewById(R.id.brewSwitch);
        if(!brewSwitch.isChecked()){
            startTimer(view, 3 * 60000, 0);
        }
        else{
            startTimer(view, 20 * 1000, 10 * 1000);
        }
    }

    public void startTimer(View view, long time, long step){
        Intent intent = new Intent(this, Timer.class);
        Bundle b = new Bundle();
        b.putLong("time", time);
        b.putLong("step", step);
        intent.putExtras(b);
        startActivity(intent);
        //finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}