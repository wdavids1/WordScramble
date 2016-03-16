package edu.westga.wordscramble;

/**
 * Created by Wayne on 3/13/2016.
 *
 * This class scrambles the word and provides validation if the players guess is correct
 */
public class Game {

    /**
     * Initialize a game
     */
    public Game() {

    }

    public String scrambleWord(String theWord) {

        return "";
    }

    /**
     * Compares the original word with the suggested word from the player
     * @param theWord               The original word
     * @param suggestedSolution     The suggested word from the player
     * @return                      True if theWord equals the suggestedSolution
     *                              False if theWord DOES NOT equal the suggestedSolution
     */
    public boolean checkCorrect(String theWord, String suggestedSolution) {
        return theWord.equalsIgnoreCase(suggestedSolution);
    }
}
