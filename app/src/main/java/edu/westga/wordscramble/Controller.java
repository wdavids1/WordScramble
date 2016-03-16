package edu.westga.wordscramble;

/**
 * Created by Wayne on 3/13/2016.
 */
public class Controller {
    public String theWord;
    public String theWordScrambled;

    public Controller() {

    }

    public void startGame() {
        Word retrievedWord = new Word();
        this.theWord = retrievedWord.getWord();
    }
}
