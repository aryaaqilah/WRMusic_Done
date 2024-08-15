package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class ItemDetails extends AppCompatActivity {

    private EditText plain_text_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // Initialize UI elements
        plain_text_input = findViewById(R.id.plain_text_input);
        ImageView addToCartIcon = findViewById(R.id.add_to_cart_icon);
        ImageView backIcon = findViewById(R.id.back_icon);

        // Set up the back button
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This will close the current activity and return to the previous one
            }
        });

        // Set up the add to cart button
        addToCartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddToCartDialog();
            }
        });
    }

    private void showAddToCartDialog() {
        String quantityText = plain_text_input.getText().toString().trim();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            quantity = 0;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (quantity == 0) {
            builder.setTitle("Add to Cart");
            builder.setMessage("Please enter a valid quantity.");
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        } else {
            builder.setTitle("Order Success");
            builder.setMessage(quantity + " items have been added to your cart.");
            builder.setPositiveButton("OK", (dialog, which) -> {
                Toast.makeText(ItemDetails.this, "Item added to cart", Toast.LENGTH_SHORT).show();
                // Logic for successful order
            });
        }
        builder.create().show();
    }
}
