package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        ImageView addToCartIcon = findViewById(R.id.add_to_cart_icon);
        addToCartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddToCartDialog();
            }
        });
    }

    private void showAddToCartDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add to Cart");
        builder.setMessage("Are you sure you want to add this item to your cart?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            // Add item to cart logic here
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}