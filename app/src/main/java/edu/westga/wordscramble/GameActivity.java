package edu.westga.wordscramble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import edu.westga.wordscramble.controller.Controller;
import edu.westga.wordscramble.model.Game;


public class GameActivity extends AppCompatActivity {

    private Controller newController = new Controller();
    private List<Character> WordScrambleList;
    private TextView resultTextView;
    private Game theGame;
    private int speedOfGame = 0, numberOfLetters = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        Bundle bundle=getIntent().getExtras();
        this.speedOfGame = bundle.getInt("speedOfGame");
        this.numberOfLetters = bundle.getInt("numberOfLetters");
        Log.i("Content ", "Game Main Layout ");
        Log.i("n", this.speedOfGame + "/" + this.numberOfLetters);
        this.newController.startGame(this.speedOfGame,this.numberOfLetters);
        this.theGame = this.newController.getTheGame();
        this.buildButtons();
        this.setTimer();
        this.answerButtonClick();
        this.resetButtonClick();
        this.WordScrambleList = this.newController.getTheWordScrambled();
        this.resultTextView =(TextView)
                findViewById(R.id.resultText) ;
        this.resultTextView.setText("");
        this.runTimer();

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
     *  Onclick listener for the Reset Button.
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
    /** -------- Helper Methods ----------**/

    /**
     *  Builds the buttons for the letters of the word.
     */
    private void buildButtons(){
        LinearLayout top3button_layout = (LinearLayout)findViewById(R.id.top3button_layout);
        LinearLayout bottom3button_layout = (LinearLayout)findViewById(R.id.bottom3button_layout);
     if(this.numberOfLetters == 5){
         Button btn1 = new Button(this);
         btn1.setText("Manual Add");
         Button btn2 = new Button(this);
         btn2.setText("Manual Add");
         Button btn3 = new Button(this);
         btn3.setText("Manual Add");
         Button btn4 = new Button(this);
         btn4.setText("Manual Add");
         Button btn5 = new Button(this);
         btn5.setText("Manual Add");
         top3button_layout.addView(btn1);
         top3button_layout.addView(btn2);
         top3button_layout.addView(btn3);
         bottom3button_layout .addView(btn4);
         bottom3button_layout .addView(btn5);
     } else {
         Button btn1 = new Button(this);
         btn1.setText("Manual Add");
         Button btn2 = new Button(this);
         btn2.setText("Manual Add");
         Button btn3 = new Button(this);
         btn3.setText("Manual Add");
         Button btn4 = new Button(this);
         btn4.setText("Manual Add");
         Button btn5 = new Button(this);
         btn5.setText("Manual Add");
         Button btn6 = new Button(this);
         btn6.setText("Manual Add");
         top3button_layout.addView(btn1);
         top3button_layout.addView(btn2);
         top3button_layout.addView(btn3);
         bottom3button_layout .addView(btn4);
         bottom3button_layout .addView(btn5);
         bottom3button_layout .addView(btn6);
     }
    }

    /**
     *  Checks the solution, provides feedback to the user.
     */
    private void checkSolution(){
        TextView answerTextView = (TextView)
                findViewById(R.id.answerText);
        if(this.newController.checkSolution(answerTextView.getText().toString())){
            this.resultTextView.setText("Correct!");
        }else{
            this.resultTextView.setText("Sorry, try again!");
        }
    }

    /**
     *  Resets the text view and the timer.
     */
    private void reset(){
        setTimer();
        this.resultTextView.setText("");
    }

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
    private void runTimer(){

    }

}
