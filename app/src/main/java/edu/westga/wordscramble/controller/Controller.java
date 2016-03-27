package edu.westga.wordscramble.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import edu.westga.wordscramble.model.Game;
import edu.westga.wordscramble.model.Word;

/**
 * Created by Wayne on 3/13/2016.
 *
 * This class controls the flow of game control
 */
public class Controller {
    private Game theGame;

    /**
     * Initialize the controller
     */
    public Controller() {
    }

    /**
     * Starts the game by:
     *      retrieving a word
     *      setting variable theWord to retrieved word
     *      scrambling theWord
     *      setting variable theWordScrambled to the scrambled version
     *
     * @param numberOfLetters   The number of letters the word should have
     *                          uses the default list if value != 5 || 6
     *
     * @param gameSpeed         The amount of time on the timer at the start
     *                          of the Game.
     */
    public void startGame(int numberOfLetters, int gameSpeed) {
        this.theGame = new Game(numberOfLetters, gameSpeed);
        this.theGame.startGame();
    }

    /**
     * Starts the game by:
     *      retrieving a word list from remote URL
     *      retrieving a word
     *      setting variable theWord to retrieved word
     *      scrambling theWord
     *      setting variable theWordScrambled to the scrambled version
     *
     * @param numberOfLetters   The number of letters the word should have
     *                          uses the default list if value != 5 || 6
     *
     * @param gameSpeed         The amount of time on the timer at the start
     *                          of the Game.
     *
     * @param url               The url to get the list from
     *                          if empty or null uses default
     *                          for other errors starts the game without URL data
     */
    public void startGame(String url, int numberOfLetters, int gameSpeed) {
        this.theGame = new Game(numberOfLetters, gameSpeed);
        this.theGame.startGame(url);
    }

    /**
     * Checks the value of theWord with the value suggested by the player
     */
    public boolean checkSolution(String suggestedSolution) {
        return this.theGame.checkCorrect(suggestedSolution);
    }

    /**
     * Allows us to get theGame for testing.
     */
    public Game getTheGame() {
        return this.theGame;
    }

    /**
     * Gets the word after it has been scrambled
     *
     * @return  The scrambled word
     */
    public List<Character> getTheWordScrambled() {
        return this.theGame.getTheWord().scrambleWord();
    }
}
