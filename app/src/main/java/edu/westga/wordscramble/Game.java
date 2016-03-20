package edu.westga.wordscramble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /**
     * Shuffle the letters of the word and then rebuild into a new string
     *
     * @param theWord   The word to shuffle
     * @return          The shuffled word
     */
    public List<Character> scrambleWord(String theWord) {
        if (theWord == null || theWord.isEmpty()) {
            return Collections.emptyList();
        }

        List<Character> wordAsArray = new ArrayList<>();
        for(char letter :  theWord.toCharArray())
            wordAsArray.add(letter);
        Collections.shuffle(wordAsArray);

        StringBuilder scrambledWord = new StringBuilder();
        for(char letter : wordAsArray)
            scrambledWord.append(letter);

        if (theWord.equals(scrambledWord.toString())) {
            return scrambleWord(theWord);
        }
        return wordAsArray;
    }

    /**
     * Compares the original word with the suggested word from the player
     * @param theWord               The original word
     * @param suggestedSolution     The suggested word from the player
     * @return                      True if theWord equals the suggestedSolution
     *                              False if theWord DOES NOT equal the suggestedSolution
     */
    public boolean checkCorrect(String theWord, String suggestedSolution) {
        return !(theWord == null || theWord.isEmpty() || suggestedSolution == null || suggestedSolution.isEmpty())
                && theWord.equalsIgnoreCase(suggestedSolution);
    }
}
