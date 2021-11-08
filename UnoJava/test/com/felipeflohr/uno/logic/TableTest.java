package com.felipeflohr.uno.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {

    Table table;

    @BeforeEach
    void beforeEach() {
        table = new Table();
    }

    @Test
    void getNextPlayer3to0() {
        table.setPlayerTurn(3);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(0, nextPlayer);
    }

    @Test
    void getNextPlayer3to1() {
        table = new Table();
        table.setPlayerTurn(3);
        table.setSkip(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(1, nextPlayer);
    }

    @Test
    void getNextPlayer2to0() {
        table = new Table();
        table.setPlayerTurn(2);
        table.setSkip(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(0, nextPlayer);
    }

    @Test
    void getNextPlayer3to1reverse() {
        table.setPlayerTurn(3);
        table.setSkip(true);
        table.setReverse(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(1, nextPlayer);
    }

    @Test
    void getNextPlayer1to3reverse() {
        table.setPlayerTurn(1);
        table.setSkip(true);
        table.setReverse(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(3, nextPlayer);
    }

    @Test
    void getNextPlayer0to2reverse() {
        table.setPlayerTurn(0);
        table.setSkip(true);
        table.setReverse(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(2, nextPlayer);
    }

    @Test
    void getNextPlayer0to3reverse() {
        table.setPlayerTurn(0);
        table.setReverse(true);

        var nextPlayer = table.getNextPlayer();
        Assertions.assertEquals(3, nextPlayer);
    }
}