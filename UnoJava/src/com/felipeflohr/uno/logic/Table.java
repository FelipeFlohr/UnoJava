package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidNextPlayer;
import com.felipeflohr.uno.exception.PlayerNoCardsException;
import com.felipeflohr.uno.logic.ailogic.AIPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.updateUIElements;

public class Table implements PlayerChangeListener {

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
            if (i == getNonAiPlayer()) {
                players.add(new Player(i));
            } else {
                players.add(new AIPlayer(i));
            }
        }
    }

    @Override
    public String toString() {
        return "--Table--\n" +
                "Current card: " + currentCard + "\n" +
                "Is reverse: " + reverse + "\n" +
                "Buy turn card: " + buyTurnCard + "\n" +
                "Buy turn amount: " + buyTurnAmount + "\n" +
                "Is skip: " + skip + "\n" +
                "Color selected: " + colorSelected + "\n" +
                "Player turn: " + playerTurn + "\n";
    }

    public int getPlayerIdWithLeastCards() {
        // FIXME Showing the wrong player ID
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

    public void applyCardChangeEffects() {
        if (getCurrentCard().isSpecial()) {
            switch (currentCard.getNumber()) {
                case "skip" -> skipEffect();
                case "reverse" -> reverseEffect();
                case "wild2" -> wild2Effect();
                case "wild4" -> wild4Effect();
            }
        }

        updateUIElements();
    }

    // Card effects
    public void cardBoughtEffect() {
        if (buyTurnAmount > 0) {
            buyTurnAmount = 0;
            buyTurnCard = null;
        }
    }

    private void skipEffect() {
        setSkip(!this.skip);
    }

    private void reverseEffect() {
        setReverse(!this.reverse);
    }

    private void wild2Effect() {
        setBuyTurnAmount(buyTurnAmount += 2);
        setBuyTurnCard(getCurrentCard());
    }

    private void wild4Effect() {
        setBuyTurnAmount(buyTurnAmount += 4);
        setBuyTurnCard(getCurrentCard());
    }

    // Getters and Setters
    public Player getPlayerByIndex(int index) {
        return players.get(index);
    }

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

    public void setPlayerTurn(int pTurn) {
        this.playerTurn = pTurn;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void onPlayerChange() {

    }

    @Override
    public int getNextPlayer() {
        int amountOfSkips = isSkip() ? 2 : 1;
        int nextPlayer = -1;
        final int INDEX_AMOUNT_OF_PLAYERS = getPlayers().size() - 1;

        if (!isReverse()) {
            if (getPlayerTurn() + amountOfSkips > INDEX_AMOUNT_OF_PLAYERS) {
                nextPlayer = (getPlayerTurn() + amountOfSkips) - (INDEX_AMOUNT_OF_PLAYERS) - 1;
            } else {
                nextPlayer = getPlayerTurn() + amountOfSkips;
            }
        } else {
            if (getPlayerTurn() - amountOfSkips < 0) {
                int skips = Math.abs(getPlayerTurn() - amountOfSkips);
                nextPlayer = getPlayers().size() - skips;
            } else {
                nextPlayer = getPlayerTurn() - amountOfSkips;
            }
        }

        if (nextPlayer < 0 || nextPlayer > getTable().getPlayers().size()) {
            throw new InvalidNextPlayer();
        }

        return nextPlayer;
    }

    @Override
    public void instantiateNextPlayer() {
        setPlayerTurn(getNextPlayer());

        // TODO Remove this placeholder and implement a proper AI
        if (getPlayerByIndex(getPlayerTurn()).isAiEnabled()) {
            instantiateNextPlayer();
        }
    }
}
