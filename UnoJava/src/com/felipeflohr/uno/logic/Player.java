package com.felipeflohr.uno.logic;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.logic.Card.generateRandomCard;

public class Player {

    private final List<Card> deck = new ArrayList<>();
    private final int id;
    private boolean uno;
    private boolean isPlayerTurn;
    private boolean aiEnabled = false;

    public Player(int id) {
        this.id = id;

        for (int i = 0; i < getInitialCardsAmount(); i++) {
            deck.add(generateRandomCard());
        }

        uno = isUnoAllowed();
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
            addCard(generateRandomCard());
        }
    }

    public boolean isUnoAllowed() {
        return deck.size() < 2;
    }

    public void removeCard(Card card) {
        int cardIndex = -1;

        for (int i = 0; i < getDeck().size(); i++) {
            if (card.equals(getDeck().get(i))) {
                if (cardIndex == -1) {
                    cardIndex = i;
                }
            }
        }

        removeCardByIndex(cardIndex);
    }

    // To String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(getId()).append(": { ");
        deck.forEach(card -> sb.append("[").append(card.getColor()).append(", ").append(card.getNumber()).append("] "));
        sb.append("}");

        return sb.toString();
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public int getAmountOfCards() {
        return deck.size();
    }

    public List<Card> getDeck() {
        return deck;
    }

    public boolean isAiEnabled() {
        return aiEnabled;
    }

    public void setAiEnabled(boolean ai) {
        aiEnabled = ai;
    }

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
}
