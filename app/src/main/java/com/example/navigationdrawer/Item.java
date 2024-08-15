package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Item extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    ImageButton buttonDrawerClose;
    NavigationView navigationView;
    RecyclerView recyclerView;
    ArrayList<SetterGetter> dataAlbum;
    GridLayoutManager gridLayoutManager;
    AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        buttonDrawerClose = findViewById(R.id.buttonDrawerClose);
        navigationView = findViewById(R.id.navigationView);
        recyclerView = findViewById(R.id.rv_album);

        addData();
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new AlbumAdapter(dataAlbum, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);

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
                    Intent intent = new Intent(Item.this, HomeActivity.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_about) {
                    Intent intent = new Intent(Item.this, AboutUsActivity.class);
                    startActivity(intent);
                }

                if (itemId == R.id.nav_logout) {
                    Intent intent = new Intent(Item.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                drawerLayout.close();

                return false;
            }
        });
    }

    public void addData() {
        dataAlbum = new ArrayList<>();
        dataAlbum.add(new SetterGetter("album_img1", "Album Name 1", "Artist Name 1", "Album Description 1"));
        dataAlbum.add(new SetterGetter("album_img2", "Album Name 2", "Artist Name 2", "Album Description 2"));
        dataAlbum.add(new SetterGetter("album_img3", "Album Name 3", "Artist Name 3", "Album Description 3"));
        dataAlbum.add(new SetterGetter("album_img4", "Album Name 4", "Artist Name 4", "Album Description 4"));
        dataAlbum.add(new SetterGetter("album_img5", "Album Name 5", "Artist Name 5", "Album Description 5"));
        dataAlbum.add(new SetterGetter("album_img6", "Album Name 6", "Artist Name 6", "Album Description 6"));
        dataAlbum.add(new SetterGetter("album_img7", "Album Name 7", "Artist Name 7", "Album Description 7"));
        dataAlbum.add(new SetterGetter("album_img8", "Album Name 8", "Artist Name 8", "Album Description 8"));
    }
}