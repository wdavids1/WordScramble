package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.model.Word;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/13/2016.
 *
 * Test class to test the functionality of the getWord method
 */
public class WordWhenGetWord {
    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 24
     * @throws Exception
     */
    @Test
    public void buildWordList() throws Exception {
        Word aWord = new Word();
        assertEquals(24, aWord.theListSize());
    }

    /**
     * Test to verify that no errors such as out of range are encountered
     *
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
     *
     * @throws Exception
     */
    @Test
    public void getWordLowSequentialDuplicates() throws Exception {
        Word aWord = new Word();
        int count = 0;

        String previousWord = "";
        String currentWord;
        for (int i=0; i<1000; i++) {
            currentWord = aWord.getWord();
            if (currentWord.equals(previousWord)) {
                count++;
            }

            previousWord = currentWord;
        }

        assertEquals(0, count);
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

        String currentWord;
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

        String currentWord;
        for (int i=0; i<1000; i++) {
            currentWord = aWord.getWord();
            if (currentWord.equals("random")) {
                randomReturned = true;
            }
        }

        assertEquals(true, randomReturned);
    }
}
