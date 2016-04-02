package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.controller.Controller;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wayne on 4/2/2016.
 *
 * Tests the hint method
 */
public class ControllerWhenGetHint {

    @Test
    public void shouldGetBNforHint() {
        Controller theController = new Controller();

        theController.setTheWord("begin");

        assertEquals("Hint: b***n", theController.getHint());
    }
}
