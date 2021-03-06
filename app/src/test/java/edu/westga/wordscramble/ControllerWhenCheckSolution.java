package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.controller.Controller;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/15/2016.
 *
 * Test class to verify that the controller class checkSolution properly
 * calls the game class checkCorrect method
 */
public class ControllerWhenCheckSolution {

    /**
     * Test to verify if identical words will return true
     */
    @Test
    public void shouldReturnTrueForIdenticalWords() {
        Controller theController = new Controller();
        theController.setTheWord("begin");

        assertEquals(true, theController.checkSolution("begin"));
    }

    /**
     * Test to verify different words will return false
     */
    @Test
    public void shouldReturnFalseForDifferentWords() {
        Controller theController = new Controller();
        theController.setTheWord("begin");

        assertEquals(false, theController.checkSolution("end"));
    }

    /**
     * Test to verify if the same word with different case will return true
     */
    @Test
    public void shouldReturnTrueForDifferentCaseWords() {
        Controller theController = new Controller();
        theController.setTheWord("begin");

        assertEquals(true, theController.checkSolution("BEGIN"));
    }

    /**
     * Test to verify that an empty string by the user will return false
     */
    @Test
    public void shouldReturnFalseForEmptySuggestion() {
        Controller theController = new Controller();
        theController.setTheWord("begin");

        assertEquals(false, theController.checkSolution(""));
    }

    /**
     * Test to verify that an empty string by the game will return false
     */
    @Test
    public void shouldReturnFalseForEmptyTheWord() {
        Controller theController = new Controller();
        theController.setTheWord("");

        assertEquals(false, theController.checkSolution("end"));
    }

    /**
     * Test to verify that a null string will return false
     */
    @Test
    public void shouldReturnFalseForNull() {
        Controller theController = new Controller();
        theController.setTheWord(null);

        assertEquals(false, theController.checkSolution(null));
    }
}
