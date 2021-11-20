package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        ImageButton playBtn = (ImageButton) findViewById(R.id.playBtn);
        ImageButton profileBtn = (ImageButton) findViewById(R.id.profileBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayWatchActivity();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }


        });
    }

    public void openPlayWatchActivity(){;
        Intent intent = new Intent(this, PlayWatchActivity.class);
        startActivity(intent);
    }

    public void openHomePage(){;
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }


}
