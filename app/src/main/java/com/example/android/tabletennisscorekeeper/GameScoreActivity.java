package com.example.android.tabletennisscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_score);

        // Getting intent which has started current activity
        Intent namesIntent = getIntent();

        // Creating strings for player's names, which were sent as extra from GameSettingsActivity
        String firstPlayerNameValue = namesIntent.getStringExtra("FirstPlayerName");
        String secondPlayerNameValue = namesIntent.getStringExtra("SecondPlayerName");

        // Finding TextView for first player name and setting its value
        TextView firstPlayerName = (TextView) findViewById(R.id.first_player_name_in_game);
        if (firstPlayerNameValue != null && !firstPlayerNameValue.isEmpty()) {
            firstPlayerName.setText(firstPlayerNameValue);
        } else {
            firstPlayerName.setText("Player 1");
        }


        // Finding TextView for second player name and setting its value
        TextView secondPlayerName = (TextView) findViewById(R.id.second_player_name_in_game);
        if (secondPlayerNameValue != null && !firstPlayerNameValue.isEmpty()) {
            secondPlayerName.setText(secondPlayerNameValue);
        } else {
            secondPlayerName.setText("Player 2");
        }

    }
}
