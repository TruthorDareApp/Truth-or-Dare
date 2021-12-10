package com.example.truthordare;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button loginBtn;

    int failedAttempts = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginBtn = findViewById(R.id.loginBtn2);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Login button clicked");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid username.", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a your password.", Toast.LENGTH_SHORT).show();
                } else {
                    loginAndOpenHomePage(username, password);
                }

                failedAttempts++;
                if (failedAttempts > 5) {
                    Toast.makeText(LoginActivity.this, "Please register if you do not have an account.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUpInstead(View v) {
        openSignUpActivity();
    }

    private void loginAndOpenHomePage(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                Log.i(TAG, "Login initiated");
                if (e != null) {
                    Log.i(TAG, "Issue with login:", e);
                    Toast.makeText(LoginActivity.this, "" + e, Toast.LENGTH_LONG).show();
                    return;
                }
                goToHomePage();
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }

    public void openSignUpActivity(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }


}
