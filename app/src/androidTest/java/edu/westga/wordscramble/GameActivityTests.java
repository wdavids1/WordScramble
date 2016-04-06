package edu.westga.wordscramble;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import edu.westga.wordscramble.viewcontroller.GameActivity;
import edu.westga.wordscramble.viewcontroller.MainActivity;

/**
 * Created by Wayne on 4/2/2016.
 *
 * Tests for GameActivity
 */
public class GameActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public GameActivityTests() {
        super(MainActivity.class);
    }

    private void startGame(Activity activity) {
        check5LetterButton(activity);
        check60SecondSpeed(activity);

        Button startButton = (Button) activity.findViewById(R.id.launchButton);

        TouchUtils.clickView(this, startButton);
    }

    private void check5LetterButton(Activity activity) {
        final RadioButton button5 = (RadioButton) activity.findViewById(R.id.radioButton5);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                button5.setChecked(true);
            }
        });

        getInstrumentation().waitForIdleSync();
    }

    private void check60SecondSpeed(Activity activity) {
        final RadioButton speed60 = (RadioButton) activity.findViewById(R.id.radioButton60);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                speed60.setChecked(true);
            }
        });

        getInstrumentation().waitForIdleSync();
    }

    public void testCheckStartGame() {
        boolean basicGameButtons = true;

        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        EditText answer = (EditText) gameStarted.findViewById(R.id.answerText);

        String actualAnswer = answer.getText().toString();

        Button answerB = (Button) gameStarted.findViewById(R.id.answerButton);

        Button answerR = (Button) gameStarted.findViewById(R.id.resetButton);

        Button answerH = (Button) gameStarted.findViewById(R.id.hintButton);

        if (!actualAnswer.equals("") || !answerB.isEnabled() || !answerR.isEnabled() || !answerH.isEnabled()) {
            basicGameButtons = false;
        }

        assertEquals(true, basicGameButtons);

        gameStarted.finish();

        activity.finish();
    }

    public void testCheckAnswer() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        Button aButton = (Button) gameStarted.findViewById(R.id.answerButton);

        TouchUtils.clickView(this, aButton);

        TextView result = (TextView) gameStarted.findViewById(R.id.resultText);

        String actualAnswer = result.getText().toString();

        assertEquals("Sorry, try again!", actualAnswer);

        gameStarted.finish();

        activity.finish();
    }

    public void testButton1HasLetter() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        int num = 1;
        Button aButton = (Button) gameStarted.findViewById(num);

        String actualAnswer = aButton.getText().toString();

        assertEquals(1, actualAnswer.length());

        gameStarted.finish();

        activity.finish();
    }

}
