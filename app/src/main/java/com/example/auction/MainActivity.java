package com.example.auction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.multiscreen.extra.NAME";
    String name, pass;
    private EditText etUname, etPass;
    private Button button;
    ImageView i1, i2;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        i1 = (ImageView) findViewById(R.id.google);
//        i2 = (ImageView) findViewById(R.id.fb);

        fab = findViewById(R.id.btn_fab);

        button = findViewById(R.id.btn_login);
        etUname = findViewById(R.id.editTextTextPersonName);
        etPass = findViewById(R.id.editTextTextPassword);
        //Toast toast;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean("flag" , true);
                editor.commit();

                name = etUname.getText().toString();
                pass = etPass.getText().toString().trim();
                if (name.isEmpty()) {
                    etUname.setError("Please enter a name");
                    etUname.requestFocus();
                    return;
                }
                if (pass.isEmpty()) {
                    etPass.setError("Please enter your password");
                    etPass.requestFocus();
                    return;
                }
//                if(!name.equals("Gyan")){
//                    etUname.setError("Invalid Name");
//                    etUname.requestFocus();
//                    return;
//                }
//                if(!pass.equals("Gyan123")){
//                    etPass.setError("Invalid Pass");
//                    etPass.requestFocus();
//                    return;
//                }
                Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainScreen.class);
                String nameText = etUname.getText().toString();
                i.putExtra(EXTRA_NAME, nameText);
                startActivity(i);
            }
        });

//        i1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri webpage = Uri.parse("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
//                try {
//                    startActivity(webIntent);
//                } catch (ActivityNotFoundException e) {
//                    // Define what your app should do if no activity can handle the intent.
//                }
//            }
//        });
//
//        i2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri webpage = Uri.parse("https://www.facebook.com/login/");
//                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
//                try {
//                    startActivity(webIntent);
//                } catch (ActivityNotFoundException e) {
//                    // Define what your app should do if no activity can handle the intent.
//                }
//            }
//        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), signUp.class);
                startActivity(i);
            }
        });
    }

}