package edu.westga.wordscramble.Tests;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import edu.westga.wordscramble.R;
import edu.westga.wordscramble.model.Game;
import edu.westga.wordscramble.viewcontroller.GameActivity;
import edu.westga.wordscramble.viewcontroller.MainActivity;

/**
 * Created by Wayne on 4/2/2016.
 *
 * Tests for the MainActivity
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testStartGameButtonDisabled() {
        MainActivity activity = getActivity();

        final Button startButton = (Button) activity.findViewById(R.id.launchButton);
        assertEquals(false, startButton.isEnabled());
    }

    public void testStartGameButtondisabledwithonlyLengthSelected() {
        MainActivity activity = getActivity();

        check5LetterButton(this.getActivity());

        final Button startButton = (Button) activity.findViewById(R.id.launchButton);
        assertEquals(false, startButton.isEnabled());
    }

    public void testStartGameButtondisabledwithonlySpeedSelected() {
        MainActivity activity = getActivity();

        check60SecondSpeed(this.getActivity());

        final Button startButton = (Button) activity.findViewById(R.id.launchButton);
        assertEquals(false, startButton.isEnabled());
    }

    public void testStartGameButtonEnabled() {
        MainActivity activity = getActivity();

        check5LetterButton(this.getActivity());

        check60SecondSpeed(this.getActivity());

        final Button startButton = (Button) activity.findViewById(R.id.launchButton);
        assertEquals(true, startButton.isEnabled());
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


}
