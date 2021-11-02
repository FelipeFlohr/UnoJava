package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.PlayerNoCardsException;
import com.felipeflohr.uno.logic.ailogic.AIPlayer;

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
    private final List<Player> players = new ArrayList<>();

    public Table() {
        currentCard = Card.generateRandomNormalCard();
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
                players.add(new Player(i));
            } else {
                players.add(new AIPlayer(i));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--Table--\n")
                .append("Current card: ")
                .append(currentCard)
                .append("\n")
                .append("Is reverse: ")
                .append(reverse)
                .append("\n")
                .append("Buy turn card: ")
                .append(buyTurnCard)
                .append("\n")
                .append("Buy turn amount: ")
                .append(buyTurnAmount)
                .append("\n")
                .append("Is skip: ")
                .append(skip)
                .append("\n")
                .append("Color selected: ")
                .append(colorSelected)
                .append("\n")
                .append("Player turn: ")
                .append(playerTurn)
                .append("\n");

        return sb.toString();
    }

    public void updateAllPlayers() {
        players.forEach(Player::onPlayerChange);
    }

    public int getPlayerIdWithLeastCards() {
        int id = -1;
        int cards = -1;

        for (Player player : players) {
            if (id == -1 & cards == -1) {
                id = player.getId();
                cards = player.getDeck().size();
            } else {
                if (player.getDeck().size() < cards) {
                    cards = player.getDeck().size();
                    id = player.getId();
                }
            }
        }

        return id;
    }

    public boolean everyoneHasTheSameAmountOfCards() {
        return players.parallelStream()
                .allMatch(p -> p.getDeck().size() == players.get(getPlayerIdWithLeastCards()).getDeck().size());
    }

    public Player getPlayerByIndex(int index) {
        return players.get(index);
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

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
