package com.example.auction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class AboutUs extends AppCompatActivity{

    WebView web;
    ImageView i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        web=(WebView) findViewById(R.id.web);
        web.loadUrl("https://www.google.com/");
        i1=(ImageView) findViewById(R.id.mail);
        i2=(ImageView) findViewById(R.id.map);
        i3=(ImageView) findViewById(R.id.phone);
        i4=(ImageView)findViewById(R.id.www);

        //mail
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"gyan.gartia@mca.christuniversity.in"));
                try{
                    startActivity(intent);
                }
                catch(ActivityNotFoundException e){
                    //handle error
                }

            }
        });

        //location
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                try {
                    startActivity(mapIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        //telephone
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:8756467129");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                try{
                    startActivity(callIntent);
                }
                catch(ActivityNotFoundException e){

                }
            }
        });

        //site
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://eauction.gov.in/eauction/#/");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });
    }
}