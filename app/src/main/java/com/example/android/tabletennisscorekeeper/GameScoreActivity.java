package com.example.android.tabletennisscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class GameScoreActivity extends AppCompatActivity {

    int gameScoreFirstPlayer = 0;
    int gameScoreSecondPlayer = 0;
    int matchScoreFirstPlayer = 0;
    int matchScoreSecondPlayer = 0;
    int pointsAmount;
    int gamesAmount;
    GameSettings currentgame;

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

        if (secondPlayerNameValue != null && !secondPlayerNameValue.isEmpty()) {
            secondPlayerName.setText(secondPlayerNameValue);
        } else {
            secondPlayerName.setText("Player 2");
        }

        pointsAmount = Integer.parseInt(gameSettingsIntent.getStringExtra("PointsAmount"));
        gamesAmount = Integer.parseInt(gameSettingsIntent.getStringExtra("GamesAmount"));

        currentgame = new GameSettings(firstPlayerName.getText().toString(), secondPlayerName.getText().toString(), pointsAmount,gamesAmount);
    }

    public void incrementFirstPlayer(View view) {
        gameScoreFirstPlayer++;
        if (gameScoreFirstPlayer >= pointsAmount && gameScoreFirstPlayer - gameScoreSecondPlayer > 1) {
            displayScoreForAFirstPlayer(gameScoreFirstPlayer);
            matchScoreFirstPlayer++;
            displayMatchScoreForAFirstPlayer(matchScoreFirstPlayer);
            if (matchScoreFirstPlayer == gamesAmount/2 + 1) {
                Toast.makeText(this, currentgame.getFirstPlayerName() + this.getString(R.string.match_winner_text), Toast.LENGTH_LONG).show();
                resetAll(view);
            } else {
                Toast.makeText(this, currentgame.getFirstPlayerName() + this.getString(R.string.game_winner_text), Toast.LENGTH_LONG).show();
                resetScore(view);
            }
            return;
        }
        displayScoreForAFirstPlayer(gameScoreFirstPlayer);
    }

    public void displayScoreForAFirstPlayer(int score) {
        TextView scoreView = (TextView) findViewById(R.id.first_player_score);
        scoreView.setText(String.valueOf(score));
    }

    public void incrementSecondPlayer(View view) {
        gameScoreSecondPlayer++;
        if (gameScoreSecondPlayer >= pointsAmount && gameScoreSecondPlayer - gameScoreFirstPlayer > 1) {
            displayScoreForASecondPlayer(gameScoreFirstPlayer);
            matchScoreSecondPlayer++;
            displayMatchScoreForASecondPlayer(matchScoreSecondPlayer);
            if (matchScoreSecondPlayer == gamesAmount/2 + 1) {
                Toast.makeText(this, currentgame.getSecondPlayerName() + this.getString(R.string.match_winner_text), Toast.LENGTH_LONG).show();
                resetAll(view);
            } else {
                Toast.makeText(this, currentgame.getSecondPlayerName() + this.getString(R.string.game_winner_text), Toast.LENGTH_LONG).show();
                resetScore(view);
            }
            return;
        }
        displayScoreForASecondPlayer(gameScoreSecondPlayer);
    }

    public void displayScoreForASecondPlayer(int score) {
        TextView scoreView = (TextView) findViewById(R.id.second_player_score);
        scoreView.setText(String.valueOf(score));
    }

    public void  displayMatchScoreForAFirstPlayer(int matchScore) {
        TextView matchScoreView = (TextView) findViewById(R.id.match_score_first_player);
        matchScoreView.setText(String.valueOf(matchScore));
    }

    public void  displayMatchScoreForASecondPlayer(int matchScore) {
        TextView matchScoreView = (TextView) findViewById(R.id.match_score_second_player);
        matchScoreView.setText(String.valueOf(matchScore));
    }

    public void resetScore(View view) {
        gameScoreFirstPlayer = 0;
        gameScoreSecondPlayer = 0;
        displayScoreForAFirstPlayer(gameScoreFirstPlayer);
        displayScoreForASecondPlayer(gameScoreSecondPlayer);
    }

    public void resetMatchScore(View view) {
        matchScoreFirstPlayer = 0;
        matchScoreSecondPlayer = 0;
        displayMatchScoreForAFirstPlayer(matchScoreFirstPlayer);
        displayMatchScoreForASecondPlayer(matchScoreSecondPlayer);
    }

    public void resetAll(View view) {
        resetScore(view);
        resetMatchScore(view);
    }
}
