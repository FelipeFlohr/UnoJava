package com.felipeflohr.unojava.uno;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getInitialCardsAmount;
import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getUnoMisclickAmountOfCards;
import static com.felipeflohr.unojava.uno.Card.generateRandomCard;

/**
 * Class responsible for defining player attributes and behaviour.
 * @author Felipe Matheus Flohr
 */
public class Player {

    private final List<Card> deck = new ArrayList<>();
    private final int id;
    private boolean uno;
    private boolean aiEnabled = false;

    /**
     * Constructor for the player class. Will generate cards for its deck when called.
     * @param id an integer representing the player ID. Must be distinct from other players.
     */
    public Player(int id) {
        this.id = id;

        for (int i = 0; i < getInitialCardsAmount(); i++) {
            deck.add(generateRandomCard());
        }

        uno = isUnoAllowed();
    }

    /**
     * Removes a card on player's deck based on its index
     * @param index card index inside the deck
     */
    public void removeCardByIndex(int index) {
        deck.remove(index);
    }

    /**
     * Adds a card to the deck
     * @param card a Card-type object to be added to the deck
     */
    public void addCard(Card card) {
        deck.add(card);
    }

    /**
     * Adds a random card to the deck
     */
    public void buyCard() {
        deck.add(generateRandomCard());
    }

    /**
     * Add cards based on the amount specified
     * @param quantity amount of cards to be added
     */
    public void buyCard(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addCard(generateRandomCard());
        }
    }

    /**
     * Will check if Uno is allowed
     * @return true if the deck size is smaller or equals to two.
     */
    public boolean isUnoAllowed() {
        return deck.size() <= 2;
    }

    /**
     * Will set the Uno attribute according to the player's deck size.
     */
    public void checkUnoStatusBuyCard() {
        if (isUno() && getDeck().size() == 2) {
            setUno(false);
        }
    }

    /**
     * Will buy cards accordingly to the "Uno misclick amount of cards" specified on the Global Definitions (Default: 2).
     */
    public void unoBuyCards() {
        buyCard(getUnoMisclickAmountOfCards());
    }

    /**
     * Removes a card on player's deck
     * @param card Card-type object to be removed
     */
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

    /**
     * Getter for the player's total amount of cards
     * @return player's total amount of cards.
     */
    public int getAmountOfCards() {
        return deck.size();
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
    /**
     * Getter for the player's ID
     * @return player ID
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the player's deck
     * @return an ArrayList representing the player deck
     */
    public List<Card> getDeck() {
        return deck;
    }

    /**
     * Getter for the "AI Enabled" attribute
     * @return true if AI is enabled
     */
    public boolean isAiEnabled() {
        return aiEnabled;
    }

    /**
     * Setter for the "AI Enabled" attribute
     * @param ai boolean value to set AI enabled
     */
    public void setAiEnabled(boolean ai) {
        aiEnabled = ai;
    }

    /**
     * Setter for the Uno attribute
     * @param u boolean value to set Uno true or false.
     */
    public void setUno(boolean u) {
        uno = u;
    }

    /**
     * Getter for the Uno attribute
     * @return true if Uno.
     */
    public boolean isUno() {
        return uno;
    }
}
