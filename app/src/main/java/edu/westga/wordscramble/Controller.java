package edu.westga.wordscramble;

/**
 * Created by Wayne on 3/13/2016.
 *
 * This class controls the flow of game control
 */
public class Controller {
    private String theWord;
    private String theWordScrambled;
    private Game theGame;

    /**
     * Initialize the controller
     */
    public Controller() {
        this.theGame = new Game();
    }

    /**
     * Starts the game by:
     *      retrieving a word
     *      setting variable theWord to retrieved word
     *      scrambling theWord
     *      setting variable theWordScrambled to the scrambled version
     */
    public void startGame() {
        Word retrievedWord = new Word();
        this.theWord = retrievedWord.getWord();

        Game theGame = new Game();
        this.theWordScrambled = theGame.scrambleWord(theWord);
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
     */
    public void startGame(int numberOfLetters) {
        Word retrievedWord = new Word();
        this.theWord = retrievedWord.getWord();

        Game theGame = new Game();
        this.theWordScrambled = theGame.scrambleWord(theWord);
    }

    /**
     * Checks the value of theWord with the value suggested by the player
     */
    public boolean checkSolution(String suggestedSolution) {
        return this.theGame.checkCorrect(theWord, suggestedSolution);
    }

    /**
     * Allows us to set theWord for testing
     *
     * @param theWord   The word that we want to make the original word
     */
    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    /**
     * Allows us to get theWord for testing
     */
    public String getTheWord() {
        return this.theWord;
    }

    /**
     * Gets the word after it has been scrambled
     *
     * @return  The scrambled word
     */
    public String getTheWordScrambled() {
        return this.theWordScrambled;
    }
}
