package edu.westga.wordscramble;

import org.junit.Test;

import java.util.List;

import edu.westga.wordscramble.model.Game;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/15/2016.
 *
 * Test class to verify that the word is scrambled
 */
public class GameWhenScrambleWord {

    /**
     * Test to verify the original word is not returned
     */
    @Test
    public void shouldReturn0ForTheWordsMatching() {
        Game theGame = new Game();
        List<Character> tempWord;
        String theWord = "begin";

        int count = 0;

        for (int i=0; i<1000; i++) {

            tempWord = theGame.scrambleWord(theWord);

            StringBuilder scrambledWord = new StringBuilder();
            for(char letter : tempWord)
                scrambledWord.append(letter);

            if (scrambledWord.toString().equals(theWord)) {
                count++;
            }
        }

        assertEquals(0, count);
    }

    /**
     * Test to verify that an empty param will not crash app
     */
    @Test
    public void shouldNotDie() {
        Game theGame = new Game();
        List<Character> tempWord;
        String theWord = "";

        int count = 0;

        for (int i=0; i<1000; i++) {

            tempWord = theGame.scrambleWord(theWord);

            StringBuilder scrambledWord = new StringBuilder();
            for(char letter : tempWord)
                scrambledWord.append(letter);

            if (scrambledWord.toString().equals(theWord)) {
                count++;
            }
        }

        assertEquals(1000, count);
    }

    /**
     * Test to verify that an empty param will not crash app
     */
    @Test
    public void shouldNotDieWithNull() {
        Game theGame = new Game();
        List<Character> tempWord;

        int count = 0;

        for (int i=0; i<1000; i++) {

            tempWord = theGame.scrambleWord(null);

            StringBuilder scrambledWord = new StringBuilder();
            for(char letter : tempWord)
                scrambledWord.append(letter);

            if (scrambledWord.toString().equals("")) {
                count++;
            }
        }

        assertEquals(1000, count);
    }
}
