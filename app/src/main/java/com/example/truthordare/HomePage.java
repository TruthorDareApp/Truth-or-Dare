package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        ImageButton playBtn = (ImageButton) findViewById(R.id.playBtn);
        ImageButton profileBtn = (ImageButton) findViewById(R.id.profileBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayWatchActivity();
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity();
            }
        });



}
    public void openPlayWatchActivity(){;
        Intent intent = new Intent(this, PlayWatchActivity.class);
        startActivity(intent);
    }

    public void openProfileActivity(){;
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}

