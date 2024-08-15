package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView errorLabel;
    private EditText usernameEt;
    private EditText passwordEt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        errorLabel = findViewById(R.id.errorLabel);
        usernameEt = findViewById(R.id.usernameField);
        passwordEt = findViewById(R.id.passwordField);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEt.getText().toString().trim().equals("")) {
                    errorLabel.setText("Username cannot be empty!");
                    errorLabel.setVisibility(View.VISIBLE);
                } else if (usernameEt.length() <= 5) {
                    errorLabel.setText("Username must be more than 5 characters long!");
                    errorLabel.setVisibility(View.VISIBLE);
                } else if (usernameEt.length() >= 10) {
                    errorLabel.setText("Username must be less than 10 characters long!");
                    errorLabel.setVisibility(View.VISIBLE);
                } else if (passwordEt.getText().toString().trim().equals("")) {
                    errorLabel.setText("Password cannot be empty!");
                    errorLabel.setVisibility(View.VISIBLE);
                } else {
                    errorLabel.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("USERNAME", usernameEt.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}