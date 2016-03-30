package edu.westga.wordscramble.viewcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import edu.westga.wordscramble.R;


/**
 * Created by Kaleigh on 3/29/2016.
 *
 * This class controls Game_Menu UI.
 */
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
                //http://developer.android.com/reference/android/util/Log.html
                Log.i("TAG:: chk:", "id" + checkedId);
                //Sets the value of the number of letters to 5 based on user's selection from the menu.
                if (checkedId == R.id.radioButton5) {
                    setNumberOfLetters(5);
                    Log.i("TAG:: letters:", "5");
                //Sets the value of the number of letters to 6 based on user's selection from the menu.
                } else {
                    setNumberOfLetters(6);
                    Log.i("TAG:: letters:", "6");
                }
                checkAllFields();
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
                //http://developer.android.com/reference/android/util/Log.html
                Log.i("TAG:: chk:", "id" + checkedId);
                //Sets the value of the game speed to 60 seconds based on user's selection from the menu.
                if (checkedId == R.id.radioButton60) {
                    setSpeedOfGame(60);
                    Log.i("TAG:: speed:", "60");
                //Sets the value of the game speed to 90 seconds based on user's selection from the menu.
                } else {
                    setSpeedOfGame(90);
                    Log.i("TAG:: speed:", "90");
                }
                checkAllFields();
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
     * Switches the screen from the screen where the user sets game preferences to the game screen.
     */
    private void gameScreen() {
        //Starts a new Intent
        Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);

        //Sends data to another Activity
        gameActivity.putExtra("numberOfLetters", this.numberOfLetters);
        gameActivity.putExtra("speedOfGame", this.speedOfGame);

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Content ", "Game Menu Layout");
        Log.i("TAG:: speed/letters:", speedOfGame+ "/" + numberOfLetters);

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

    /**
     * Checks that all radio button options are selected before allowing the user to click Launch Game.
     */
    private void checkAllFields(){
        if (this.speedOfGame>0 && this.numberOfLetters >0){
            Button button = (Button) findViewById(R.id.launchButton);
            button.setEnabled(true);
        }
    }


}