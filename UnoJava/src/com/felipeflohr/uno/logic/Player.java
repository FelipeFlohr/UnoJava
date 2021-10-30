package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;
import com.felipeflohr.uno.exception.NoAIBehaviourAssignedException;
import com.felipeflohr.uno.logic.ailogic.AIBehaviour;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.logic.Card.generateRandomCard;

public class Player {

    private List<Card> deck = new ArrayList<>();
    private final int id;
    private final boolean aiEnabled;
    private final AIBehaviour ai;

    public Player(int id, boolean aiEnabled, AIBehaviour ai) throws InvalidNumberException, InvalidColorException, NoAIBehaviourAssignedException {
        this.id = id;
        this.aiEnabled = aiEnabled;
        this.ai = ai;

        for (int i = 0; i < getInitialCardsAmount(); i++) {
            deck.add(generateRandomCard());
        }

        if (aiEnabled && ai == null) {
            throw new NoAIBehaviourAssignedException();
        }
    }

    public Player(int id, int initialAmountOfCards, boolean aiEnabled, AIBehaviour ai) throws InvalidNumberException, InvalidColorException, NoAIBehaviourAssignedException {
        this.id = id;
        this.aiEnabled = aiEnabled;
        this.ai = ai;

        for (int i = 0; i < initialAmountOfCards; i++) {
            deck.add(generateRandomCard());
        }

        if (aiEnabled && ai == null) {
            throw new NoAIBehaviourAssignedException();
        }
    }

    public void removeCardByIndex(int i) {
        deck.remove(i);
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getAmountOfCards() {
        return deck.size();
    }

    public List<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(getId()).append(": { ");
        deck.forEach(card -> {
            sb.append("[").append(card.getColor()).append(", ").append(card.getNumber()).append("] ");
        });
        sb.append("}");

        return sb.toString();
    }
}
