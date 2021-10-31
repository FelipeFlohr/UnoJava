package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.PlayerNoCardsException;
import com.felipeflohr.uno.logic.ailogic.AIBehaviour;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getNonAiPlayer;
import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getTotalAmountOfPlayers;

public class Table {

    private Card currentCard;
    private boolean reverse;
    private Card buyTurnCard;
    private int buyTurnAmount;
    private String colorSelected;
    private boolean skip;
    private int playerTurn;
    private List<Player> players = new ArrayList<>();

    public Table() {
        currentCard = Card.generateRandomCard();
        reverse = false;
        buyTurnCard = null;
        buyTurnAmount = 0;
        skip = false;
        colorSelected = null;
        playerTurn = 0;

        generatePlayers();
        checkPlayersAmountOfCards();
    }

    public void checkPlayersAmountOfCards() {
        players.parallelStream().forEach(p -> {
            if (p.getDeck().size() == 0) {
                throw new PlayerNoCardsException("Player ID" + p.getId() + "has no cards");
            }
        });
    }

    private void generatePlayers() {
        for (int i = 0; i < getTotalAmountOfPlayers(); i++) {
            if (i != getNonAiPlayer()) {
                players.add(new Player(i, false, null));
            } else {
                players.add(new Player(i, true, new AIBehaviour()));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--Table--\n")
                .append("Current card: " + currentCard + "\n")
                .append("Is reverse: " + reverse + "\n")
                .append("Buy turn card: " + buyTurnCard + "\n")
                .append("Buy turn amount: " + buyTurnAmount + "\n")
                .append("Is skip: " + skip + "\n")
                .append("Color selected: " + colorSelected + "\n")
                .append("Player turn: " + playerTurn + "\n");

        return sb.toString();
    }

    // Getters and Setters
    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public Card getBuyTurnCard() {
        return buyTurnCard;
    }

    public void setBuyTurnCard(Card buyTurnCard) {
        this.buyTurnCard = buyTurnCard;
    }

    public int getBuyTurnAmount() {
        return buyTurnAmount;
    }

    public void setBuyTurnAmount(int buyTurnAmount) {
        this.buyTurnAmount = buyTurnAmount;
    }

    public String getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(String colorSelected) {
        this.colorSelected = colorSelected;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Player getPlayerByIndex(int index) {
        return players.get(index);
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int id) {
        playerTurn = id;
    }
}
