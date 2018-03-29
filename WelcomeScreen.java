package com.example.prasan.serviceloggingsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity {
     private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent logIntent =new Intent(WelcomeScreen.this,LoginPage.class);
                startActivity(logIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
