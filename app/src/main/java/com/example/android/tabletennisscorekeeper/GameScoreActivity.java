package com.example.android.tabletennisscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameScoreActivity extends AppCompatActivity {

    int gameScoreFirstPlayer = 0;
    int getGameScoreSecondPlayer = 0;
    int matchScoreFirstPlayer = 0;
    int matchScoreSecondPlayer = 0;
    int pointsAmount;
    int gamesAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_score);

        // Get intent which has started current activity
        Intent gameSettingsIntent = getIntent();

        // Create strings for player's names, which were sent as extra from GameSettingsActivity
        String firstPlayerNameValue = gameSettingsIntent.getStringExtra("FirstPlayerName");
        String secondPlayerNameValue = gameSettingsIntent.getStringExtra("SecondPlayerName");

        // Find TextView for first player name and set its value
        TextView firstPlayerName = (TextView) findViewById(R.id.first_player_name_in_game);
        if (firstPlayerNameValue != null && !firstPlayerNameValue.isEmpty()) {
            firstPlayerName.setText(firstPlayerNameValue);
        } else {
            firstPlayerName.setText("Player 1");
        }

        // Find TextView for second player name and set its value
        TextView secondPlayerName = (TextView) findViewById(R.id.second_player_name_in_game);
        if (secondPlayerNameValue != null && !firstPlayerNameValue.isEmpty()) {
            secondPlayerName.setText(secondPlayerNameValue);
        } else {
            secondPlayerName.setText("Player 2");
        }
    }

    public void incrementFirstPlayer(View view) {
        gameScoreFirstPlayer++;
        displayScoreForAFirstPlayer(gameScoreFirstPlayer);
    }

    public void displayScoreForAFirstPlayer(int score) {
        TextView scoreView = (TextView) findViewById(R.id.first_player_score);
        scoreView.setText(String.valueOf(score));
    }

    public void incrementSecondPlayer(View view) {
        getGameScoreSecondPlayer++;
        displayScoreForASecondPlayer(getGameScoreSecondPlayer);
    }

    public void displayScoreForASecondPlayer(int score) {
        TextView scoreView = (TextView) findViewById(R.id.second_player_score);
        scoreView.setText(String.valueOf(score));
    }

}
