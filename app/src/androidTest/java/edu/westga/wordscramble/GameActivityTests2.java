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
public class GameActivityTests2 extends ActivityInstrumentationTestCase2<MainActivity> {
    public GameActivityTests2() {
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

    public void testButton5HasLetter() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        int num = 5;
        Button aButton = (Button) gameStarted.findViewById(num);

        String actualAnswer = aButton.getText().toString();

        assertEquals(1, actualAnswer.length());

        gameStarted.finish();

        activity.finish();
    }

    public void testButton5DisabledAfterClick() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        int num = 5;
        Button aButton = (Button) gameStarted.findViewById(num);

        TouchUtils.clickView(this, aButton);

        assertEquals(false, aButton.isEnabled());

        gameStarted.finish();

        activity.finish();
    }

    public void testAnswerHasTextAfterButtonClick() {
        Instrumentation inst = getInstrumentation();
        MainActivity activity = getActivity();
        Instrumentation.ActivityMonitor game = inst.addMonitor("edu.westga.wordscramble.viewcontroller.GameActivity", null, false);

        startGame(this.getActivity());

        GameActivity gameStarted = (GameActivity) game.waitForActivityWithTimeout(2000);

        int num = 5;
        Button aButton = (Button) gameStarted.findViewById(num);

        TouchUtils.clickView(this, aButton);

        EditText answer = (EditText) gameStarted.findViewById(R.id.answerText);

        String actualAnswer = answer.getText().toString();

        assertEquals(1, actualAnswer.length());

        gameStarted.finish();

        activity.finish();
    }
}
