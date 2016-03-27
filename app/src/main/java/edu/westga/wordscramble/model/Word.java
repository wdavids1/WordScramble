package edu.westga.wordscramble.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private int wordLength = 0;
    private Random theRandom = new Random();
    private URL url;
    private String theWord;;

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

        this.theWord = this.theList.get(this.theRandom.nextInt(this.theList.size()));

        for(int count = 0; count < this.previousWords.size(); count++) {
            if (this.previousWords.get(count).equals(this.theWord)) {
                return getWord();
            }
        }

        this.previousWords.add(this.theWord);

        if (this.previousWords.size() > 5) {
            this.previousWords.remove(0);
        }

        return this.theWord;
    }

    /**
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @return A word randomly selected from the list
     */
    public void getWord(int wordLength) {
        if (wordLength != 0 && this.wordLength != wordLength) {
            this.makeTempList(wordLength, this.theList);
        }

        if (this.tempList.size() == 0) {
            this.tempList = theList;
        }
        this.wordLength = wordLength;


        this.theWord = this.tempList.get(this.theRandom.nextInt(this.tempList.size()));

        for(int count = 0; count < this.previousWords.size(); count++) {
            if (this.previousWords.get(count).equals(this.theWord)) {
                getWord(wordLength);
            }
        }

        this.previousWords.add(this.theWord);

        if (this.previousWords.size() > 5) {
            this.previousWords.remove(0);
        }

    }

    /**
     * Uses a random number within the size of the list to return a word
     * Should include both the first and last words of the list
     *
     * @return A word randomly selected from the list
     */
    public void getWord(int wordLength, URL url) {
        if (wordLength != 0 && this.wordLength != wordLength && this.url != url) {
            ReadWordsFromURL theWordList = new ReadWordsFromURL();
            this.makeTempList(wordLength, theWordList.getWordListFromURL(url));
        }

        if (this.tempList.size() == 0) {
            this.tempList = theList;
        }
        this.wordLength = wordLength;


        this.theWord = this.tempList.get(this.theRandom.nextInt(this.tempList.size()));

        for(int count = 0; count < this.previousWords.size(); count++) {
            if (this.previousWords.get(count).equals(this.theWord)) {
                getWord(wordLength);
            }
        }

        this.previousWords.add(this.theWord);

        if (this.previousWords.size() > 5) {
            this.previousWords.remove(0);
        }

    }

    /**
     * Helper class to populate the list of words
     */
    private void makeTheList() {
        this.theList.add("begin");
        this.theList.add("zappy");
        this.theList.add("jimmy");
        this.theList.add("jimpy");
        this.theList.add("jiffy");
        this.theList.add("zippy");
        this.theList.add("jemmy");
        this.theList.add("quick");
        this.theList.add("jammy");
        this.theList.add("quack");
        this.theList.add("junky");
        this.theList.add("gazabo");
        this.theList.add("gazars");
        this.theList.add("gazebo");
        this.theList.add("gazers");
        this.theList.add("gazing");
        this.theList.add("maglev");
        this.theList.add("magmas");
        this.theList.add("magnet");
        this.theList.add("rancho");
        this.theList.add("rancid");
        this.theList.add("rancor");
        this.theList.add("randan");
        this.theList.add("random");
    }

    /**
     * Helper class to populate tempList with words
     */
    private void makeTempList(int wordLength, ArrayList<String> aList) {

        for(int count = 0; count < aList.size(); count++) {
            if (aList.get(count).length() == wordLength) {
                this.tempList.add(aList.get(count));
            }
        }

    }

    private void setURL(URL url) {
        this.url = url;
    }

    /**
     * Shuffle the letters of the word and then rebuild into a new string
     *
     * @return          The shuffled word
     */
    public List<Character> scrambleWord() {
        if (this.theWord == null || this.theWord.isEmpty()) {
            return Collections.emptyList();
        }

        List<Character> wordAsArray = new ArrayList<>();
        for(char letter :  this.theWord.toCharArray())
            wordAsArray.add(letter);
        Collections.shuffle(wordAsArray);

        StringBuilder scrambledWord = new StringBuilder();
        for(char letter : wordAsArray)
            scrambledWord.append(letter);

        if (this.theWord.equals(scrambledWord.toString())) {
            return scrambleWord();
        }
        return wordAsArray;
    }
}
