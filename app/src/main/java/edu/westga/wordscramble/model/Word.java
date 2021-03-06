package edu.westga.wordscramble.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Wayne on 3/13/2016.
 *
 * This class provides a random word for the player to guess
 */
public class Word {
    private ArrayList<String> theList = new ArrayList<>();
    private ArrayList<String> previousWords = new ArrayList<>();
    private ArrayList<String> tempList = new ArrayList<>();
    private Random theRandom = new Random();

    /**
     * Initializes the list
     */
    public Word() {
        this.makeTheList();
    }

    /**
     * In place for testing to ensure that the list is populated
     *
     * @return  The number of words in the list
     */
    public int theListSize() {
        return theList.size();
    }

    /**
     * In place for testing to ensure that the list is populated
     *
     * @return  The number of words in the list
     */
    public int theTempListSize() {
        return tempList.size();
    }

    /**
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @return A word randomly selected from the list
     */
    public String getWord() {
        String theWord;

        theWord = theList.get(theRandom.nextInt(theList.size()));

        for(int count = 0; count < previousWords.size(); count++) {
            if (previousWords.get(count).equals(theWord)) {
                return getWord();
            }
        }

        previousWords.add(theWord);

        if (previousWords.size() > 5) {
            previousWords.remove(0);
        }

        return theWord;
    }

    /**
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @param wordLength    The length of the word desired
     *
     * @return A word randomly selected from the list
     */
    public String getWord(int wordLength) {
        this.makeTempList(wordLength, this.theList);

        if (this.tempList.size() == 0) {
            this.tempList = theList;
        }

        String theWord;

        theWord = tempList.get(theRandom.nextInt(tempList.size()));

        for(int count = 0; count < previousWords.size(); count++) {
            if (previousWords.get(count).equals(theWord)) {
                return getWord(wordLength);
            }
        }

        previousWords.add(theWord);

        if (previousWords.size() > 5) {
            previousWords.remove(0);
        }

        return theWord;
    }

    /**
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @param wordLength    The length of the word desired
     * @param remote        Whether the word should be from a remote list,
     *                      basically it allows us to overload the method
     *
     * @return A word randomly selected from the list
     */
    public String getWord(int wordLength, Boolean remote){
        ReadWordsFromURL theWordList = new ReadWordsFromURL();

        try {
            this.makeTempList(wordLength, theWordList.execute().get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (this.tempList.size() == 0) {
            this.makeTempList(wordLength, theList);
        }

        String theWord;

        theWord = tempList.get(theRandom.nextInt(tempList.size()));

        for(int count = 0; count < previousWords.size(); count++) {
            if (previousWords.get(count).equals(theWord)) {
                return getWord(wordLength, true);
            }
        }

        previousWords.add(theWord);

        if (previousWords.size() > 5) {
            previousWords.remove(0);
        }

        return theWord;
    }

    /**
     * This is a testable version of the above class since I'm unable to
     * test the AsyncTask
     *
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @param wordLength    The length of the word desired
     * @param remote        Whether the word should be from a remote list,
     *                      basically it allows us to overload the method
     *
     * @return A word randomly selected from the list
     */
    public String getWordTestable(int wordLength, Boolean remote){
        ReadWordsFromURL theWordList = new ReadWordsFromURL();

        try {
            this.makeTempList(wordLength, theWordList.readURL());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (this.tempList.size() == 0) {
            this.makeTempList(wordLength, theList);
        }

        String theWord;

        theWord = tempList.get(theRandom.nextInt(tempList.size()));

        for(int count = 0; count < previousWords.size(); count++) {
            if (previousWords.get(count).equals(theWord)) {
                return getWord(wordLength, true);
            }
        }

        previousWords.add(theWord);

        if (previousWords.size() > 5) {
            previousWords.remove(0);
        }

        return theWord;
    }

    /**
     * Helper class to populate the list of words
     */
    private void makeTheList() {
        theList.add("begin");
        theList.add("zappy");
        theList.add("jimmy");
        theList.add("jimpy");
        theList.add("jiffy");
        theList.add("zippy");
        theList.add("jemmy");
        theList.add("quick");
        theList.add("jammy");
        theList.add("quack");
        theList.add("junky");
        theList.add("gazabo");
        theList.add("gazars");
        theList.add("gazebo");
        theList.add("gazers");
        theList.add("gazing");
        theList.add("maglev");
        theList.add("magmas");
        theList.add("magnet");
        theList.add("rancho");
        theList.add("rancid");
        theList.add("rancor");
        theList.add("randan");
        theList.add("random");
    }

    /**
     * Helper class to populate tempList with words
     */
    private void makeTempList(int wordLength, ArrayList<String> aList) {

        for(int count = 0; count < aList.size(); count++) {
            if (aList.get(count).length() == wordLength) {
                tempList.add(aList.get(count));
            }
        }

    }
}
