package com.example.auction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_SHORT).show();

//        Thread th = new Thread()
//        {
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                }
//                catch (Exception e) {
//                }
//                finally {
//                    Intent it = new Intent(splashScreen.this, MainActivity.class);
//                    startActivity(it);
//                }
//            }
//        };
//        th.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                boolean check =  pref.getBoolean("flag", false);

                Intent i;
                if(check){
                    i = new Intent(splashScreen.this, MainScreen.class);
                }
                else{
                    i = new Intent(splashScreen.this, MainActivity.class);
                }
                startActivity(i);
            }
        }, 3000);

    }
}