package com.thelevelgrinder.hangdroid;
/**
 * Damian Depuy
 * CSC 210
 * Activity displays game over with button to restart game.
 * A new intent is created to start MainActivity
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }
    public void startNewGame(View v)
    {
        Intent newGame = new Intent(this,MainActivity.class);
        startActivity(newGame);
    }
}
