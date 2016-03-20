package edu.westga.wordscramble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Wayne on 3/19/2016.
 *
 * This class will read a list of words from a URL
 */
public class ReadWordsFromURL {
    private ArrayList<String> theWords;

    /**
     * Initializes the array to populate with words from the URL
     */
    public ReadWordsFromURL() {
        theWords = new ArrayList<>();
    }

    /**
     * Reads a text file located at the URL
     * Reads it line by line and adds the words to theList
     *
     * @return  theList of words that was read from the URL as an arraylist
     */
    public ArrayList<String> getWordListFromURL(URL url) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                theWords.add(line);
            }
            in.close();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        return theWords;
    }

}
