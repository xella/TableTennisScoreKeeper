package com.example.android.tabletennisscorekeeper;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
        Button newGameBtn = (Button) findViewById(R.id.new_game_btn);

        // Set a click listener on this Button
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGameSettingsIntent = new Intent(MainActivity.this, GameSettingsActivity.class);
                startActivity(newGameSettingsIntent);
            }
        });

        // Find the Button that shows a Dialog with rules
        Button rulesBtn = (Button) findViewById(R.id.rules_btn);

        // Set a click listener on this Button
        rulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Rules of Table Tennis")
                        .setMessage(R.string.rules)
                        .setCancelable(true)
                        .setNegativeButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int id) {
                                        dialogInterface.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }


}
