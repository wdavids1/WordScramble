package edu.westga.wordscramble;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

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
        try {
            URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt");

            ReadWordsFromURL theWords = new ReadWordsFromURL();

            assertEquals(109583, theWords.getWordListFromURL(url).size());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }

    /**
     * Test to verify that the list is empty
     * when a bad URL is provided
     */
    @Test
    public void readWordsShouldGet0WithBadURL() {
        try {
            URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.tx");

            ReadWordsFromURL theWords = new ReadWordsFromURL();

            assertEquals(0, theWords.getWordListFromURL(url).size());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }

    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 6919
     */
    @Test
    public void wordRead5LetterWordsShouldGet6919() {
        try {
            URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt");

            Word aWord = new Word();

            ReadWordsFromURL theWords = new ReadWordsFromURL();

            aWord.getWord(5, url);

            assertEquals(6919, aWord.theTempListSize());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }

    /**
     * Test to verify that the list is populated with words
     * the known length of the list is 11492
     */
    @Test
    public void wordRead6LetterWordsShouldGet11492() {
        try {
            URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt");

            Word aWord = new Word();

            ReadWordsFromURL theWords = new ReadWordsFromURL();

            aWord.getWord(6, url);

            assertEquals(11492, aWord.theTempListSize());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
    }
}
