package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;
import com.felipeflohr.uno.exception.NoAIBehaviourAssignedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getAmountOfCards() throws InvalidNumberException, InvalidColorException, NoAIBehaviourAssignedException {
        Player player = new Player(0, false, null);
        assertEquals(7, player.getAmountOfCards());
    }
}