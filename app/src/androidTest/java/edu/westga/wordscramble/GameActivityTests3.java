package edu.westga.wordscramble;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import edu.westga.wordscramble.viewcontroller.GameActivity;
import edu.westga.wordscramble.viewcontroller.MainActivity;

/**
 * Created by Wayne on 4/2/2016.
 *
 * Tests for GameActivity
 */
public class GameActivityTests3 extends ActivityInstrumentationTestCase2<MainActivity> {
    public GameActivityTests3() {
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

    public void testResetButton() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        int num = 5;
        Button aButton = (Button) gameStarted.findViewById(num);

        TouchUtils.clickView(this, aButton);

        Button reset = (Button) gameStarted.findViewById(R.id.resetButton);

        TouchUtils.clickView(this, reset);

        EditText answer = (EditText) gameStarted.findViewById(R.id.answerText);

        String actualAnswer = answer.getText().toString();

        assertEquals("", actualAnswer);

        gameStarted.finish();

        activity.finish();
    }

    public void testButton6NotExist() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        boolean exists = false;

        try {
            int num = 6;
            Button aButton = (Button) gameStarted.findViewById(num);
            String actualAnswer = aButton.getText().toString();
            exists = true;
        } catch (Exception e) {
            exists = false;
        }

        assertEquals(false, exists);

        gameStarted.finish();

        activity.finish();
    }
}
