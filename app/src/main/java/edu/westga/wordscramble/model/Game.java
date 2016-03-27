package edu.westga.wordscramble.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wayne on 3/13/2016.
 *
 * This class scrambles the word and provides validation if the players guess is correct
 */
public class Game {
    private int wordLength;
    private int gameSpeed;
    private  Word theWord = new Word();
    private List<Character> theWordScrambled;
    private URL url;
    private final String DEFAULTURL = "http://www-01.sil.org/linguistics/wordlists/english/wordlist/wordsEn.txt";

    /**
     * Constructor:  Initialize a game
     */
    public Game(int wordLength, int gameSpeed) {
        this.wordLength = wordLength;
        this.gameSpeed = gameSpeed;
    }

    /**
     * Gets the word length.
     * @return The word length.
     */
    public int getWordLength() {
        return this.wordLength;
    }

    /**
     * Sets the word length.
     * @param wordLength The word length.
     */
    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    /**
     * Gets the game speed.
     * @return The game speed.
     */
    public int getGameSpeed() {
        return this.gameSpeed;
    }

    /**
     * Sets the game speed.
     * @param gameSpeed The game speed.
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    /**
     *
     * @return        The word
     */
    public Word getTheWord(){
        return  this.theWord;
    }

    /**
     * Compares the original word with the suggested word from the player
     * @param suggestedSolution     The suggested word from the player
     * @return                      True if theWord equals the suggestedSolution
     *                              False if theWord DOES NOT equal the suggestedSolution
     */
    public boolean checkCorrect(String suggestedSolution) {
        return !(this.theWord == null || this.theWord.getWord().isEmpty() || suggestedSolution == null || suggestedSolution.isEmpty())
                && this.theWord.getWord().equalsIgnoreCase(suggestedSolution);
    }

    /**
     * Starts the game by:
     *      retrieving a word
     *      setting variable theWord to retrieved word
     *      scrambling theWord
     *      setting variable theWordScrambled to the scrambled version
     *
     */
    public void startGame() {
        this.theWord.getWord(this.wordLength);
        this.theWordScrambled =this.theWord.scrambleWord();
    }

    /**
     * * Starts the game by:
     *      retrieving a word list from remote URL
     *      retrieving a word
     *      setting variable theWord to retrieved word
     *      scrambling theWord
     *      setting variable theWordScrambled to the scrambled version
     *
     * @param url               The url to get the list from
     *                          if empty or null uses default
     *                          for other errors starts the game without URL data
     */
    public void startGame(String url) {
        if ((url == null) || url.isEmpty()) {
            url = DEFAULTURL;
        }

        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            startGame();
        }

        this.theWord.getWord(this.wordLength, this.url);
        this.theWordScrambled = this.theWord.scrambleWord();
    }
}
