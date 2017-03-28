package com.example.android.tabletennisscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int playerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button that shows the new game settings activity
        Button newGameButton = (Button) findViewById(R.id.new_game_button);

        // Set a click listener on this Button
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGameSettingsIntent = new Intent(MainActivity.this, GameSettingsActivity.class);
                startActivity(newGameSettingsIntent);
            }
        });
    }


}
