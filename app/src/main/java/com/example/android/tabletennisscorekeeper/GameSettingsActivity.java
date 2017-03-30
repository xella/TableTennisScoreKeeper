package com.example.android.tabletennisscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GameSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_settings);
    }

    public void submitGameSettings(View view) {

        // Find the first player's name
        EditText firstPlayerNameEditText = (EditText) findViewById(R.id.first_player_name);
        final String firstPlayerName = firstPlayerNameEditText.getText().toString();

        // Find the second player's name
        EditText secondPlayerNameEditText = (EditText) findViewById(R.id.second_player_name);
        final String secondPlayerName = secondPlayerNameEditText.getText().toString();

        // Find the radio group for amount of games per set
        RadioGroup rgGames = (RadioGroup) findViewById(R.id.games_quantity_rg);

        // Get selected radio button from radio group
        int selectedGamesAmountId = rgGames.getCheckedRadioButtonId();

        // Find the radio button by returned id
        RadioButton amountOfGamesRadioBtn = (RadioButton) findViewById(selectedGamesAmountId);

        // Get string value of checked radio button
        String amountOfGamesValue = amountOfGamesRadioBtn.getText().toString();

        // Find the radio group for amount of games per set
        RadioGroup rgPoints = (RadioGroup) findViewById(R.id.points_quantity_rg);

        // Get selected radio button from radio group
        int selectedPointsAmountId = rgPoints.getCheckedRadioButtonId();

        // Find the radio button by returned id
        RadioButton amountOfPointsRadioBtn = (RadioButton) findViewById(selectedPointsAmountId);

        // Get string value of checked radio button
        String amountofPointsValue = amountOfPointsRadioBtn.getText().toString();

        // Creating new intent for GameScoreActivity with extras and starting an activity
        Intent startGameIntent = new Intent(GameSettingsActivity.this, GameScoreActivity.class);
        startGameIntent.putExtra("FirstPlayerName", firstPlayerName);
        startGameIntent.putExtra("SecondPlayerName", secondPlayerName);
        startGameIntent.putExtra("GamesAmount", amountOfGamesValue);
        startGameIntent.putExtra("PointAmount", amountofPointsValue);
        startActivity(startGameIntent);
    }
}
