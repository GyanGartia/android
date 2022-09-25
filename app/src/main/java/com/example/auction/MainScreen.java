package com.example.auction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainScreen extends AppCompatActivity{
    TextView textView;
    Button btnPaint, btnElectronic;
    AlertDialog.Builder builder;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnPaint = findViewById(R.id.painting);
        btnElectronic = findViewById(R.id.electronic);

        btnElectronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean("flag", false);
                editor.apply();
            }
        });



        btnPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),painting.class);
                startActivity(intent);
            }
        });
        //textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        //textView.setText("WELCOME " + name);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationview);

        toolbar = findViewById(R.id.toolbar);

        //navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId()) {
                    case R.id.feedBack:
                        Intent i = new Intent(MainScreen.this, feedBack.class);
                        startActivity(i);
                        break;

                    case R.id.share:
                        Toast.makeText(MainScreen.this, "Share it with friends!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.home:
                        Toast.makeText(MainScreen.this, "HomeScreen!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.dashboard:
                        Toast.makeText(MainScreen.this, "Dashboard!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.aboutUs:
                        Intent i2 = new Intent(MainScreen.this, AboutUs.class);
                        startActivity(i2);
                        //Toast.makeText(MainScreen.this, "Dashboard!", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;
                }
                return true;
            }
    });
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.option1:
//                Toast.makeText(getApplicationContext(), "Option 1 is selected", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.option2:
//                Toast.makeText(getApplicationContext(), "Option 2 is selected", Toast.LENGTH_SHORT).show();
//                return true;
//
//            default:
//                return super.onContextItemSelected(item);
//        }
////        return super.onContextItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        builder.setTitle("Quit");
        builder.setMessage("Do you really want to quit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
                System.exit(0);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this, "Search Option is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.cart:
                Intent i = new Intent(MainScreen.this, cart.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }
}