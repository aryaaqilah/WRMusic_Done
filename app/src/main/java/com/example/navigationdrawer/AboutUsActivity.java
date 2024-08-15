package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class AboutUsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabPageAdapter tabPageAdapter;
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    ImageButton buttonDrawerClose;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabPageAdapter = new TabPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabPageAdapter);
        tabLayout.setupWithViewPager(viewPager);


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

                if (itemId == R.id.nav_home) {
                    Intent intent = new Intent(AboutUsActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_items) {
                    Intent intent = new Intent(AboutUsActivity.this, Item.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_logout) {
                    Intent intent = new Intent(AboutUsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                drawerLayout.close();

                return true;
            }
        });

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(createTabView(tab.getText().toString()));
            }
        }
    }

    private View createTabView(String tabText) {
        View view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView textView = view.findViewById(R.id.tabText);
        textView.setText(tabText);
        return view;
    }

}