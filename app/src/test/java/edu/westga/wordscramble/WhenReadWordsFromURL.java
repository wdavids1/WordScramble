package edu.westga.wordscramble;

import android.content.Context;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import edu.westga.wordscramble.model.ReadWordsFromURL;
import edu.westga.wordscramble.model.Word;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 3/19/2016.
 *
 * This class tests that the ReadWordsFromURL class works as expected
 */
public class WhenReadWordsFromURL {
    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 109583
     */
    @Test
    public void readWordsShouldGet109583() {
            ReadWordsFromURL theWords = new ReadWordsFromURL();

            assertEquals(109583, theWords.readURL().size());
    }

    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 6919
     */
    @Test
    public void wordRead5LetterWordsShouldGet6919() {
            Word aWord = new Word();

            aWord.getWordTestable(5, true);

            assertEquals(6919, aWord.theTempListSize());
    }

    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 11492
     */
    @Test
    public void wordRead6LetterWordsShouldGet11492() {
            Word aWord = new Word();

            aWord.getWordTestable(6, true);

            assertEquals(11492, aWord.theTempListSize());
    }
}
