package edu.westga.wordscramble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/16/2016.
 *
 * Test class to test that the word class will provide either
 * a 5 or 6 letter word based on the user preference
 */
public class WordWhenWantDifferentLengthLetterWord {
    /**
     * Test to verify that the list is populated with 5 letter words
     */
    @Test
    public void build5LetterWordListSize11() {
        Word aWord = new Word();

        aWord.getWord(5);

        assertEquals(11, aWord.theTempListSize());
    }

    /**
     * Test to verify that the list is populated with 5 letter words
     */
    @Test
    public void build5LetterWordList() {
        Word aWord = new Word();
        Boolean noErrors = true;
        int count = 0;

        try {
            for (int i=0; i<1000; i++) {
                if (aWord.getWord(5).length() != 5) {
                    noErrors = false;
                }
            }
        } catch (Exception e) {
            noErrors = false;
        }

        assertEquals(true, noErrors);
    }

    /**
     * Test to verify that the list is populated with 5 letter words
     */
    @Test
    public void build6LetterWordListSize13() {
        Word aWord = new Word();

        aWord.getWord(6);

        assertEquals(13, aWord.theTempListSize());
    }

    /**
     * Test to verify that the list is populated with 6 letter words
     */
    @Test
    public void build6LetterWordList() {
        Word aWord = new Word();
        Boolean noErrors = true;
        int count = 0;

        try {
            for (int i=0; i<1000; i++) {
                if (aWord.getWord(6).length() != 6) {
                    noErrors = false;
                }
            }
        } catch (Exception e) {
            noErrors = false;
        }

        assertEquals(true, noErrors);
    }

    /**
     * Test to verify that the list is populated with the normal list for
     * values other than 5 or 6
     */
    @Test
    public void useCurrentListWhen0Provided() {
        Word aWord = new Word();

        aWord.getWord(0);

        assertEquals(24, aWord.theTempListSize());
    }

    /**
     * Test to verify that the list is populated with the normal list for
     * values other than 5 or 6
     */
    @Test
    public void useCurrentListWhen4Provided() {
        Word aWord = new Word();

        aWord.getWord(4);

        assertEquals(24, aWord.theTempListSize());
    }

    /**
     * Test to verify that the list is populated with the normal list for
     * values other than 5 or 6
     */
    @Test
    public void useCurrentListWhen7Provided() {
        Word aWord = new Word();

        aWord.getWord(7);

        assertEquals(24, aWord.theTempListSize());
    }
}
