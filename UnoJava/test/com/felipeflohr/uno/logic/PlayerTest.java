package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getAmountOfCards() throws InvalidNumberException, InvalidColorException {
        Player player = new Player(0);
        assertEquals(7, player.getAmountOfCards());
    }
}