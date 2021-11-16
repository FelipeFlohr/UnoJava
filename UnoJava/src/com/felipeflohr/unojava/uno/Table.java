package com.felipeflohr.unojava.uno;

import com.felipeflohr.unojava.exception.InvalidNextPlayer;
import com.felipeflohr.unojava.exception.PlayerNoCardsException;
import com.felipeflohr.unojava.swing.frames.warningframes.PlayerWonWarning;
import com.felipeflohr.unojava.uno.ailogic.AIPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.updateUIElements;

public class Table {

    private Card currentCard;
    private Card buyTurnCard;
    private String colorSelected;
    private boolean reverse;
    private boolean skip;
    private int buyTurnAmount;
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
                try {
                    throw new PlayerNoCardsException("Player ID" + p.getId() + "has no cards");
                } catch (PlayerNoCardsException e) {
                    new PlayerWonWarning();
                }
            }
        });
    }

    public int getPlayerIdWithLeastCards() {
        int id = -1;
        int cards = -1;

        for (Player player : players) {
            if (id == -1 && cards == -1) {
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
        } else {
            setBuyTurnCard(null);
            setBuyTurnAmount(0);
            setSkip(false);
            setColorSelected(null);
        }

        updateUIElements();
    }

    public int getNextPlayer() {
        int amountOfSkips = isSkip() ? 2 : 1;
        int nextPlayer;
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

    public void moveToNextPlayer() throws InterruptedException {
        setPlayerTurn(getNextPlayer());
        checkAllPlayersUnoStatus();

        if (getPlayerByIndex(getPlayerTurn()).isAiEnabled()) {
            var aiPlayer =  ((AIPlayer) getPlayerByIndex(getPlayerTurn()));
            aiPlayer.defaultAI();
        }
    }

    // To String
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

    // Card effects
    public void cardBoughtEffect() {
        if (buyTurnAmount > 0) {
            buyTurnAmount = 0;
            buyTurnCard = null;
        }
    }

    // Private method(s)
    private void skipEffect() {
        setSkip(true);
        setColorSelected(null);
    }

    private void reverseEffect() {
        setReverse(!this.reverse);
        setColorSelected(null);
    }

    private void wild2Effect() {
        setBuyTurnAmount(buyTurnAmount += 2);
        setBuyTurnCard(getCurrentCard());
        setColorSelected(null);
    }

    private void wild4Effect() {
        setBuyTurnAmount(buyTurnAmount += 4);
        setBuyTurnCard(getCurrentCard());
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

    private void checkAllPlayersUnoStatus() {
        getPlayers().parallelStream().forEach(p -> {
            if (p.isUno() && !p.isUnoAllowed()) {
                p.setUno(false);
            }
        });
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
}
