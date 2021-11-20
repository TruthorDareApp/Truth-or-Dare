package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InitialLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_launch);

        Button signupBtn = (Button) findViewById(R.id.signupBtn);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

    }

    public void openSignUpActivity(){;
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void openLoginActivity(){;
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}



