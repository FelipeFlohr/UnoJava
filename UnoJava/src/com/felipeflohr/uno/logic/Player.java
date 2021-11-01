package com.felipeflohr.uno.logic;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.logic.Card.generateRandomCard;

public class Player implements PlayerChangeListener {

    private final List<Card> deck = new ArrayList<>();
    private final int id;
    private boolean uno = false;
    protected boolean isPlayerTurn;
    protected boolean aiEnabled = false;

    public Player(int id) {
        this.id = id;

        for (int i = 0; i < getInitialCardsAmount(); i++) {
            deck.add(generateRandomCard());
        }

        uno = isUnoAllowed();
    }

    public Player(int id, int initialAmountOfCards) {
        this.id = id;

        for (int i = 0; i < initialAmountOfCards; i++) {
            deck.add(generateRandomCard());
        }
    }

    public void removeCardByIndex(int i) {
        deck.remove(i);
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void buyCard() {
        deck.add(generateRandomCard());
    }

    public void buyCard(int quantity) {
        for (int i = 0; i < quantity; i++) {
            deck.add(generateRandomCard());
        }
    }

    public boolean isUnoAllowed() {
        return deck.size() < 2;
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

    // Getters & Setters
    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean t) {
        isPlayerTurn = t;
    }

    public void setUno(boolean u) {
        uno = u;
    }

    public boolean isUno() {
        return uno;
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

    @Override
    public void onPlayerChange() {
        if (getCurrentPlayer() == getId()) {
            if (isAiEnabled()) {
                // TODO AI Behaviour
            }
        }
    }
}
