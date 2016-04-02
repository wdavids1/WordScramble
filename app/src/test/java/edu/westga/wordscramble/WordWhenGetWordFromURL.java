package edu.westga.wordscramble;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import edu.westga.wordscramble.model.ReadWordsFromURL;
import edu.westga.wordscramble.model.Word;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/13/2016.
 *
 * Test class to test the functionality of the getWord method
 */
public class WordWhenGetWordFromURL {
    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 6919
     * @throws Exception
     */
    @Test
    public void buildWordListFromURL() throws Exception {

        try {
            ReadWordsFromURL theWords = new ReadWordsFromURL();
            theWords.execute().get();

            Word aWord = new Word();
            aWord.getWord(5, true);

            assertEquals(6919, aWord.theTempListSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test to verify that no errors such as out of range are encountered
     *
     * @throws Exception
     */
    @Test
    public void getWordNoErrorsWithValidURL() throws Exception {
        Word aWord = new Word();
        Boolean noErrors = true;
        int count = 0;

        for (int i=0; i<1000; i++) {
            aWord.getWord(5);
        }

        assertEquals(true, noErrors);
    }
}
