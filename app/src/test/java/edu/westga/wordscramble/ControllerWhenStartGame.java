package edu.westga.wordscramble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/15/2016.
 *
 * Test class to verify that the game is started with a random word
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
}
