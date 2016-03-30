package edu.westga.wordscramble;

import org.junit.Test;

import java.util.List;

import edu.westga.wordscramble.controller.Controller;

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

    /*
     * Test to check that a word of length 5 is returned
     */
    @Test
    public void ControllerShouldGetAWordSize5() {
        Controller theController = new Controller();
        theController.startGame(5);
        assertEquals(5, theController.getTheWord().length());
    }

    /*
     * Test to check that a word of length 5 is returned
     */
    @Test
    public void ControllerShouldGetAWordSize6() {
        Controller theController = new Controller();
        theController.startGame(6);
        assertEquals(6, theController.getTheWord().length());
    }

    /*
     * Test to check that a word of length 5 is returned
     */
    @Test
    public void ControllerShouldGetAWordSize5FromURL() {
        Controller theController = new Controller();
        theController.startGame(5, null);
        assertEquals(5, theController.getTheWord().length());
    }

    /*
     * Test to check that a word of length 5 is returned
     */
    @Test
    public void ControllerShouldGetAWordSize6FromURL() {
        Controller theController = new Controller();
        theController.startGame(6, "");
        assertEquals(6, theController.getTheWord().length());
    }

    /**
     * Test to verify the original word is not returned when a new game is started
     */
    @Test
    public void shouldReturn0ForTheWordsMatching() {
        Controller theController = new Controller();

        int count = 0;

        for (int i=0; i<100; i++) {
            theController.startGame();

            String theWord = theController.getTheWord();
            List<Character> wordAsArray= theController.getTheWordScrambled();

            StringBuilder scrambledWord = new StringBuilder();
            for(char letter : wordAsArray)
                scrambledWord.append(letter);

            if (scrambledWord.toString().equals(theWord)) {
                count++;
            }
        }

        assertEquals(0, count);
    }
}
