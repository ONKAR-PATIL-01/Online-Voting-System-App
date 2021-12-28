package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);
                finish();
            }
        },1000);



        setContentView(R.layout.activity_main);



    }



}

