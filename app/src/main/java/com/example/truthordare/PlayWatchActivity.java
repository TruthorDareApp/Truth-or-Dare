package com.example.truthordare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PlayWatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_watch_screen);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        ImageButton playBtn = (ImageButton) findViewById(R.id.playBtn);
        ImageButton profileBtn = (ImageButton) findViewById(R.id.profileBtn);
        Button playerBtn =  (Button) findViewById(R.id.playerBtn);
        Button watcherBtn =  (Button) findViewById(R.id.watcherBtn);

        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayActivity();
            }
        });

        watcherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWatchActivity();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }


        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity();
            }
        });
}

    public void openPlayActivity(){;
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
    public void openWatchActivity(){;
        Intent intent = new Intent(this, WatchActivity.class);
        startActivity(intent);
    }

    public void openHomePage(){;
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openProfileActivity(){;
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
