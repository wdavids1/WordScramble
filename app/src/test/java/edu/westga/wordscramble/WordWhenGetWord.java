package edu.westga.wordscramble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/13/2016.
 */
public class WordWhenGetWord {
    /**
     * Test to verify that the list is populated with words
     * @throws Exception
     */
    @Test
    public void buildWordList() throws Exception {
        Word aWord = new Word();
        assertEquals(24, aWord.theListSize());
    }

    /**
     * Test to verify that no errors such as out of range are encountered
     * @throws Exception
     */
    @Test
    public void getWordNoErrors() throws Exception {
        Word aWord = new Word();
        Boolean noErrors = true;
        int count = 0;

        try {
            for (int i=0; i<1000; i++) {
                aWord.getWord();
            }
        } catch (Exception e) {
            noErrors = false;
        }

        assertEquals(true, noErrors);
    }

    /**
     * Test to check for sequential selection of the same word from the list
     * Since were doing 1000 calls 60 is allowed as the delta which is 6%
     *
     * @throws Exception
     */
    @Test
    public void getWordLowSequentialDuplicates() throws Exception {
        Word aWord = new Word();
        int count = 0;

        String previousWord = "";
        String currentWord = "";
        for (int i=0; i<1000; i++) {
            currentWord = aWord.getWord();
            if (currentWord.equals(previousWord)) {
                count++;
            }

            previousWord = currentWord;
        }

        assertEquals(0, count, 60);
    }

    /**
     * Test to check that the first word in the list will be returned
     *
     * First word is begin
     *
     * @throws Exception
     */
    @Test
    public void getWordCheckThatFirstWordIsReturned() throws Exception {
        Word aWord = new Word();
        Boolean beginReturned = false;

        String currentWord = "";
        for (int i=0; i<1000; i++) {
            currentWord = aWord.getWord();
            if (currentWord.equals("begin")) {
                beginReturned = true;
            }
        }

        assertEquals(true, beginReturned);
    }

    /**
     * Test to check that the last word in the list will be returned
     *
     * First word is random
     *
     * @throws Exception
     */
    @Test
    public void getWordCheckThatLastWordIsReturned() throws Exception {
        Word aWord = new Word();
        Boolean randomReturned = false;

        String currentWord = "";
        for (int i=0; i<1000; i++) {
            currentWord = aWord.getWord();
            if (currentWord.equals("random")) {
                randomReturned = true;
            }
        }

        assertEquals(true, randomReturned);
    }
}
