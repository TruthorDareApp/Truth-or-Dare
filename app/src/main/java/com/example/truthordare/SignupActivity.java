package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity  extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private EditText etAge;
    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        signUpBtn = findViewById(R.id.signUpBtn);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etAge = findViewById(R.id.etAge);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Register button clicked.");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                String age = etAge.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if ((!email.matches(emailPattern)) || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a username.", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a password.", Toast.LENGTH_SHORT).show();
                } else if (age.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your age.", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(age) < 18) {
                    Toast.makeText(getApplicationContext(), "You must be at least 18 to register.", Toast.LENGTH_SHORT).show();
                }else {
                    signUpUser(username, password, email);
                }
            }
        });
    }

    public void loginInstead(View v) {
        openLoginActivity();
    }

    private void signUpUser(String username, String password, String email) {
        Log.i(TAG, "Registering user...");
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(e -> {
            if (e == null) {
                openLoginActivity();
            } else {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openLoginActivity(){
    Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
