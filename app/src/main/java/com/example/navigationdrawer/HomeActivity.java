package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {


    private ViewFlipper carousel;

    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    ImageButton buttonDrawerClose;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carousel = findViewById(R.id.carousel);
        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);
        int[] images = {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6};

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_about) {
                    Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_items) {
                    Intent intent = new Intent(HomeActivity.this, Item.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_logout) {
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                drawerLayout.close();

                return true;
            }
        });

        for(int image : images) {
            ImageView imageView = new ImageView(HomeActivity.this);
            imageView.setBackgroundResource(image);
            carousel.addView(imageView);
            carousel.setFlipInterval(5000);
            carousel.setAutoStart(true);
            carousel.setInAnimation(HomeActivity.this, R.anim.slide_in_right);
            carousel.setOutAnimation(HomeActivity.this, R.anim.slide_out_left);
        }

        ImageView albumImageView = findViewById(R.id.album);
        albumImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ItemDetails.class);
                startActivity(intent);
            }
        });

    }
}