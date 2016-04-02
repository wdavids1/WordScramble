package edu.westga.wordscramble.viewcontroller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.westga.wordscramble.R;
import edu.westga.wordscramble.controller.Controller;
import edu.westga.wordscramble.model.Game;


/**
 * Created by Kaleigh on 3/29/2016.
 *
 * This class controls Game_Activity UI.
 */
public class GameActivity extends AppCompatActivity {

    private Controller newController = new Controller();
    private List<Character> WordScrambleList;
    private TextView resultTextView;
    private int speedOfGame = 0, numberOfLetters = 0 ;
    private CountDownTimer theTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        //http://developer.android.com/reference/android/os/Bundle.html
        Bundle bundle=getIntent().getExtras();

        this.speedOfGame = bundle.getInt("speedOfGame");
        this.numberOfLetters = bundle.getInt("numberOfLetters");

        //http://developer.android.com/reference/android/util/Log.html
        Log.i("Content ", "Game Main Layout ");
        Log.i("TAG:: speed/letters:", this.speedOfGame + "/" + this.numberOfLetters);

        //Builds the game.
        this.newController.startGame(this.numberOfLetters, true);
        this.buildButtons();
        this.setTimer();
        this.answerButtonClick();
        this.resetButtonClick();
        this.hintButtonClick();
        this.WordScrambleList = this.newController.getTheWordScrambled();
        this.resultTextView =(TextView)
                findViewById(R.id.resultText) ;
        this.resultTextView.setText("");
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.runTimer(this.speedOfGame);
    }

    /** -------- Helper Methods ----------**/

    /**
     *  Sets the timer.
     */
    private void setTimer(){
        TextView timerTextView = (TextView)
                findViewById(R.id.timerTextView);
        findViewById(R.id.timerTextView);
        timerTextView.setText("Time: " + this.speedOfGame);
    }

    /**
     *  Runs the timer.
     */
    private void runTimer(int time){
        final TextView timerTextView = (TextView)
                findViewById(R.id.timerTextView);
        findViewById(R.id.timerTextView);
        time = time*1000;
        this.theTimer = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextView.setText("Game Over");
                gameOver();
                checkSolution();
            }
        }.start();
    }

    /**
     *  Builds the buttons for the letters of the word.
     */
    private void buildButtons(){
        WordScrambleList = newController.getTheWordScrambled();
        LinearLayout topButton_layout = (LinearLayout)findViewById(R.id.topButton_layout);
        LinearLayout bottomButton_layout = (LinearLayout)findViewById(R.id.bottomButton_layout);
        int count = this.numberOfLetters;
        for(Character current :WordScrambleList){
            if (count >= 3 ) {
                this.letterButtonClick(count, current.toString(), bottomButton_layout);
            } else {
                this.letterButtonClick(count, current.toString(), topButton_layout);
            }
            count--;
        }
    }

    /**
     * Adds the buttons and listeners to for the letters of the scrambled word
     * @param number the Index of the Button / position of the letter of the scrambled word.
     * @param letter the letter of the scrambled word.
     * @param layout the layout to add the button to.
     */
    private void letterButtonClick(int number, String letter, LinearLayout layout) {
        Button btn = new Button(this);
        btn.setId(number);
        layout.addView(btn);
        btn.setTextSize(24);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(5,5,5,5);
        btn.setLayoutParams(params);
        Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.roundedbutton, null);
        btn.setBackground(d);
        btn.setText(letter);
        final int index = number;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView answerTextView = (TextView)
                        findViewById(R.id.answerText);
                Button btn = (Button) findViewById(index);
                answerTextView.setText(answerTextView.getText().toString() + btn.getText().toString().toUpperCase());
                btn.setEnabled(false);
                //http://developer.android.com/reference/android/util/Log.html
                Log.i("TAG", "The index is" + index);
            }
        });
    }

    /**
     * OnClick listener for the Answer Button.
     */
    private void answerButtonClick() {
        Button button = (Button) findViewById(R.id.answerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSolution();
            }
        });
    }

    /**
     *  Checks the solution, provides feedback to the user.
     */
    private void checkSolution(){
        TextView answerTextView = (TextView)
                findViewById(R.id.answerText);
        if(this.newController.checkSolution(answerTextView.getText().toString())){
            this.resultTextView.setText("Correct!");
            this.theTimer.cancel();
            gameOver();
        }else{
            this.resultTextView.setText("Sorry, try again!");
        }
    }

    /**
     *  OnClick listener for the Reset Button.
     */
    private void resetButtonClick() {
        Button button = (Button) findViewById(R.id.resetButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    /**
     *  Resets the text view.
     */
    private void reset(){
        this.resultTextView.setText("");
        TextView answerTextView = (TextView)
                findViewById(R.id.answerText);
        answerTextView.setText("");
        answerTextView.setEnabled(true);
        for(int i = this.numberOfLetters ; i>=1; i--){
            //http://developer.android.com/reference/android/util/Log.html
            Log.i("TAG", "The button is" + i);
            Button btn = (Button) findViewById(i);
            btn.setEnabled(true);
        }
    }

    /**
     *  Ends the game.
     */
    private void gameOver(){
        TextView answerTextView = (TextView)
                findViewById(R.id.answerText);

        //Greys the user entry line out.
        answerTextView.setEnabled(false);

        //Greys the buttons out.
        for(int i=numberOfLetters;i>=1; i--){
            Button btn = (Button) findViewById(i);
            btn.setEnabled(false);
        }

        //Resets the view to "Start Over"
        LinearLayout submit_layout = (LinearLayout)findViewById(R.id.submit_layout);
        Button answerButton = (Button) findViewById(R.id.answerButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        submit_layout.removeView(answerButton);
        submit_layout.removeView(resetButton);
        startOverButtonClick();
    }

    /**
     * Sends the user back to the Game Menu Screen.
     */
    private void startOverButtonClick() {
        LinearLayout submit_layout = (LinearLayout)findViewById(R.id.submit_layout);
        Button btn = new Button(this);
        btn.setId(000);
        btn.setTextSize(26);
        submit_layout.addView(btn);
        btn.setText("Start Over");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starts a new Intent
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                //http://developer.android.com/reference/android/util/Log.html
                Log.i("Content ", "Game Menu Layout ");
                startActivity(mainActivity);
            }
        });
    }

    /**
     * Provides simple feedback about an operation in a small popup (in this case, a hint).
     * http://developer.android.com/guide/topics/ui/notifiers/toasts.html
     */
    private void hintButtonClick() {
        Button button = (Button) findViewById(R.id.hintButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView answerTextView = (TextView)
                        findViewById(R.id.answerText);
                Toast.makeText(getApplicationContext(), newController.getHint(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}