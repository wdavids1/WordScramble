package edu.westga.wordscramble;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import edu.westga.wordscramble.controller.Controller;


public class MainActivity extends AppCompatActivity {

    private int numberOfLetters = 0, speedOfGame = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);
        this.wordLength();
        this.gameSpeed();
        this.launchGame();
    }

    /**
     * Gets the user's input for preferred word length.
     */
    private void wordLength() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.wordLengthGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("chk", "id" + checkedId);
                if (checkedId == R.id.radioButton5) {
                    setNumberOfLetters(5);
                    Log.i("n", "5");
                } else {
                    setNumberOfLetters(6);
                    Log.i("n", "6");
                }
            }
        });
    }

    /**
     * Gets the user's input for preferred speed.
     */
    private void gameSpeed(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.speedGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("chk", "id" + checkedId);
                if (checkedId == R.id.radioButton60) {
                    setSpeedOfGame(60);
                    Log.i("n", "60");
                } else {
                    setSpeedOfGame(90);
                    Log.i("n", "90");
                }
            }
        });
    }

    /**
     * Launches the game when the user clicks the Launch Game button.
     */
    private void launchGame() {
        Button button = (Button) findViewById(R.id.launchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameScreen();
            }
        });
    }

    /** -------- Helper Methods ----------**/

    /**
     * Switches the screen from the screen where the user sets game preferences and the game screen.
     */
    private void gameScreen() {
        //Starting a new Intent
        Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);

        //Sending data to another Activity
        gameActivity.putExtra("numberOfLetters", this.numberOfLetters);
        gameActivity.putExtra("speedOfGame", this.speedOfGame);

        Log.i("Content ", "Game Menu Layout ");
        Log.i("n", speedOfGame+ "/" + numberOfLetters);

        startActivity(gameActivity);
    }

    /**
     *  Sets the number of letters for the word.
     * @param numberOfLetters  The number of letters.
     */
    private void setNumberOfLetters(int numberOfLetters){
        this.numberOfLetters = numberOfLetters;
    }

    /**
     *  Sets the speed (difficulty) of the game.
     * @param speedOfGame  The length of time the user has to complete the game (in seconds).
     */
    private void setSpeedOfGame(int speedOfGame){
        this.speedOfGame = speedOfGame;
    }


}
