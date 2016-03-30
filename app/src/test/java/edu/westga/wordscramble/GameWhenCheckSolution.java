package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.model.Game;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/15/2016.
 *
 * Test class to verify the game class checkCorrect method
 * properly verifies the users guess
 */
public class GameWhenCheckSolution {

    /**
     * Test to verify if identical words will return true
     */
    @Test
    public void shouldReturnTrueForIdenticalWords() {
        Game theGame = new Game();

        assertEquals(true, theGame.checkCorrect("begin","begin"));
    }

    /**
     * Test to verify different words will return false
     */
    @Test
    public void shouldReturnFalseForDifferentWords() {
        Game theGame = new Game();

        assertEquals(false, theGame.checkCorrect("begin","end"));
    }

    /**
     * Test to verify if the same word with different case will return true
     */
    @Test
    public void shouldReturnTrueForDifferentCaseWords() {
        Game theGame = new Game();

        assertEquals(true, theGame.checkCorrect("begin","BEGIN"));
    }

    /**
     * Test to verify that an empty string by the user will return false
     */
    @Test
    public void shouldReturnFalseForEmptySuggestion() {
        Game theGame = new Game();

        assertEquals(false, theGame.checkCorrect("begin",""));
    }

    /**
     * Test to verify that an empty string by the game will return false
     */
    @Test
    public void shouldReturnFalseForEmptyWord() {
        Game theGame = new Game();

        assertEquals(false, theGame.checkCorrect("","end"));
    }

    /**
     * Test to verify that a null string will return false
     */
    @Test
    public void shouldReturnFalseForNull() {
        Game theGame = new Game();

        assertEquals(false, theGame.checkCorrect(null,null));
    }
}
