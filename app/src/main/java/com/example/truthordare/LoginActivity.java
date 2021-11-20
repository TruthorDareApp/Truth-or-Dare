package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginBtn2 = (Button) findViewById(R.id.loginBtn2);
        Button signUpBtn = (Button) findViewById(R.id.signUpBtn);

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });
    }

    public void openHomePage(){;
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openSignUpActivity(){;
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }


}
