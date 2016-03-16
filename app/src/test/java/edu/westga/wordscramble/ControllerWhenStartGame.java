package edu.westga.wordscramble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/15/2016.
 *
 * Test class to verify that the game is started with a random word
 * and that word get scrambled
 */
public class ControllerWhenStartGame {

    /*
     * Test to check that a string of length greater than 1 is
     * set for the variable theWord
     */
    @Test
    public void ControllerShouldGetAWord() {
        Controller theController = new Controller();
        theController.startGame();
        assertEquals(true, theController.getTheWord().length() > 1);
    }

    /**
     * Test to verify the original word is not returned when a new game is started
     *
     * Since it may occur that the shuffle doesn't result in a change a
     * 5% margin of error is allowed
     */
    @Test
    public void shouldReturn0ForTheWordsMatching() {
        Controller theController = new Controller();

        int count = 0;

        for (int i=0; i<100; i++) {
            theController.startGame();

            String theWord = theController.getTheWord();
            String tempWord = theController.getTheWordScrambled();

            if (tempWord.equals(theWord)) {
                count++;
            }
        }

        assertEquals(0, count, 5);
    }
}
