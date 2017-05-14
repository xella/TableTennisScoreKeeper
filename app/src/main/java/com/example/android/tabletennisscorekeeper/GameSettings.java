package com.example.android.tabletennisscorekeeper;

/**
 * Created by Xella on 30-Mar-17.
 */

public class GameSettings {

    // First player's name
    private String mFirstPlayerName;

    // Second player's name
    private String mSecondPlayerName;

    // Amount of point in game
    int mPointsAmount;

    // Amount of games in match
    int mGamesAmount;

    public GameSettings(String firstPlayerName, String secondPlayerName, int pointsAmount, int gamesAmount) {
        mFirstPlayerName = firstPlayerName;
        mSecondPlayerName = secondPlayerName;
        mPointsAmount = pointsAmount;
        mGamesAmount = gamesAmount;
    }

    public String getFirstPlayerName() {
        return mFirstPlayerName;
    }

    public String getSecondPlayerName() {
        return mSecondPlayerName;
    }
}
