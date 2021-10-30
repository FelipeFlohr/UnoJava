package com.felipeflohr.uno.logic.ailogic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;
import com.felipeflohr.uno.logic.Card;
import com.felipeflohr.uno.logic.Player;

public class AIBehaviour {

    private final Player player;

    public AIBehaviour(Player player) {
        this.player = player;
    }

    public void buyCard() throws InvalidNumberException, InvalidColorException {
        player.addCard(Card.generateRandomCard());
    }

    public void buyCard(int amount) throws InvalidNumberException, InvalidColorException {
        for (int i = 0; i < amount; i++) {
            player.addCard(Card.generateRandomCard());
        }
    }

    public void chooseCard() {
        // TODO Make AI pick a card
    }

}
