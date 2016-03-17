package edu.westga.wordscramble;

import org.junit.Test;

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
        String tempWord;
        int count = 0;

        for (int i=0; i<1000; i++) {
            tempWord = theGame.scrambleWord("begin");
            if (tempWord.equals("begin")) {
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
        String tempWord;
        int count = 0;

        for (int i=0; i<1000; i++) {
            tempWord = theGame.scrambleWord("");
            if (tempWord.equals("begin")) {
                count++;
            }
        }

        assertEquals(0, count);
    }
}
