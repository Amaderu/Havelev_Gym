package com.example.havelevgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActivity extends AppCompatActivity {
    Handler handler;
    SharedPreferences pref = null;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        handler = new Handler();
        pref = getSharedPreferences("appRunnable",0);
        intent = new Intent(LaunchActivity.this,SignInActivity.class);
        nextActivity();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },3000L);
    }

    public  void nextActivity(){
        if(pref.getBoolean("FirstRun",true)){
            intent = new Intent(LaunchActivity.this,HelloActivity.class);
            pref.edit().putBoolean("FirstRun",false).commit();
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}