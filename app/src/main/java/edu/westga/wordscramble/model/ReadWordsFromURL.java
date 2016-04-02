package edu.westga.wordscramble.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import edu.westga.wordscramble.R;

/**
 * Created by Wayne on 3/19/2016.
 *
 * This class will read a list of words from a URL
 */
public class ReadWordsFromURL extends AsyncTask<String, Void, ArrayList<String>> {
    private ArrayList<String> theWords;

    /**
     * Initializes the array to populate with words from the URL
     */
    public ReadWordsFromURL() {
        theWords = new ArrayList<>();
    }

    @Override
    protected ArrayList<String> doInBackground(String... params) {
        try {
            URL url = new URL("http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

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
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return theWords;
    }

}
