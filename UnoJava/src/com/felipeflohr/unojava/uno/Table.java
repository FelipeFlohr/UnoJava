package com.felipeflohr.unojava.uno;

import com.felipeflohr.unojava.exception.InvalidNextPlayer;
import com.felipeflohr.unojava.exception.PlayerNoCardsException;
import com.felipeflohr.unojava.swing.frames.warningframes.PlayerWonWarning;
import com.felipeflohr.unojava.uno.ailogic.AIPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.updateUIElements;

/**
 * The game's table. Its purpose is to hold match info, like the current card, the current turn's player and so on.
 * @author Felipe Matheus Flohr
 */
public class Table {

    private Card currentCard;
    private Card buyTurnCard;
    private String colorSelected;
    private boolean reverse;
    private boolean skip;
    private int buyTurnAmount;
    private int playerTurn;
    private final List<Player> players = new ArrayList<>();

    /**
     * Constructor for the Table class. Will generate default valeus for the "table"
     * Default values are:
     * Current card: a random normal card will be generated using the generateRandomNormalCard() method;
     * Reverse: false;
     * Buy turn card: null;
     * Buy turn amount: 0;
     * Skip: false;
     * Color selected: null;
     * Current turn player: 0.
     */
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

    /**
     * Will check everyone's deck size.
     * @throws PlayerNoCardsException if some player has 0 cards
     */
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

    /**
     * Will get the player who has the least amount of cards on its deck
     * @return ID of the player with the least amount of cards
     */
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

    /**
     * Check all player's deck size to see if every deck has the same size
     * @return a true value if all players have the same amount of cards
     */
    public boolean everyoneHasTheSameAmountOfCards() {
        return players.parallelStream()
                .allMatch(p -> p.getDeck().size() == players.get(getPlayerIdWithLeastCards()).getDeck().size());
    }

    /**
     * Will apply the card effect on the table according to the current card
     */
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

    /**
     * Generates the ID of the next player
     * @return the ID value of the next player
     */
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

    /**
     * Will set the current player to the next player
     * @throws InterruptedException related to the default AI
     */
    public void moveToNextPlayer() throws InterruptedException {
        setPlayerTurn(getNextPlayer());
        checkAllPlayersUnoStatus();

        if (getPlayerByIndex(getPlayerTurn()).isAiEnabled()) {
            var aiPlayer =  ((AIPlayer) getPlayerByIndex(getPlayerTurn()));
            aiPlayer.defaultAI();
        }
    }

    /**
     * Gets a player by its index on the player list.
     * @param index player's index.
     * @return a Player class.
     */
    public Player getPlayerByIndex(int index) {
        return players.get(index);
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

    /**
     * Will apply the effect of a player buying a card.
     */
    // Card effects
    public void cardBoughtEffect() {
        if (buyTurnAmount > 0) {
            buyTurnAmount = 0;
            buyTurnCard = null;
        }
    }

    // Private method(s)
    /**
     * Will apply the Skip card effects. Will set the skip to true and the selected color to null.
     */
    private void skipEffect() {
        setSkip(true);
        setColorSelected(null);
    }

    /**
     * Will apply the Reverse card effects. Will set the Reverse to the opposite value the current reverse status. Also, it will set the selected color to null.
     */
    private void reverseEffect() {
        setReverse(!this.reverse);
        setColorSelected(null);
    }

    /**
     * Will apply the +2 card effects. Will increment by two the Buy Turn Amount. Also, it will set the buy turn card to the current card and set the selected color to null.
     */
    private void wild2Effect() {
        setBuyTurnAmount(buyTurnAmount += 2);
        setBuyTurnCard(getCurrentCard());
        setColorSelected(null);
    }

    /**
     * Will apply the +4 card effects. Will increment by four the Buy turn Amount. Also, it will set the buy turn card to the current card.
     */
    private void wild4Effect() {
        setBuyTurnAmount(buyTurnAmount += 4);
        setBuyTurnCard(getCurrentCard());
    }

    /**
     * Generates the players accordingly to the total amount of players. The non-AI player will be the one specified on the Global Definitions.
     */
    private void generatePlayers() {
        for (int i = 0; i < getTotalAmountOfPlayers(); i++) {
            if (i == getNonAiPlayer()) {
                players.add(new Player(i));
            } else {
                players.add(new AIPlayer(i));
            }
        }
    }

    /**
     * Check all player Uno status.
     */
    private void checkAllPlayersUnoStatus() {
        getPlayers().parallelStream().forEach(p -> {
            if (p.isUno() && !p.isUnoAllowed()) {
                p.setUno(false);
            }
        });
    }

    // Getters and Setters
    /**
     * Gets the current card on the table
     * @return current card
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * Sets the current card on table
     * @param currentCard a Card-type object to be set as the current card.
     */
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    /**
     * Returns the reverse value of the table
     * @return current reverse value
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * Sets the reverse value of the table
     * @param reverse boolean expression which defines the reverse value
     */
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    /**
     * Gets the buy turn card
     * @return Buy turn card
     */
    public Card getBuyTurnCard() {
        return buyTurnCard;
    }

    /**
     * Sets the buy turn card
     * @param buyTurnCard Card-type object to be set as the buy turn card
     */
    public void setBuyTurnCard(Card buyTurnCard) {
        this.buyTurnCard = buyTurnCard;
    }

    /**
     * Gets the buy turn amount
     * @return an integer representing the buy turn amount
     */
    public int getBuyTurnAmount() {
        return buyTurnAmount;
    }

    /**
     * Sets the buy turn amount
     * @param buyTurnAmount an integer which defines the buy turn amount
     */
    public void setBuyTurnAmount(int buyTurnAmount) {
        this.buyTurnAmount = buyTurnAmount;
    }

    /**
     * Gets the selected color
     * @return selected color
     */
    public String getColorSelected() {
        return colorSelected;
    }

    /**
     * Sets the selected color
     * @param colorSelected the color to be defined as the Selected Color. It can be "black", "blue", "green", "red" or "yellow".
     */
    public void setColorSelected(String colorSelected) {
        this.colorSelected = colorSelected;
    }

    /**
     * Gets the skip value
     * @return skip value
     */
    public boolean isSkip() {
        return skip;
    }

    /**
     * Sets the skip value
     * @param skip boolean value for the skip
     */
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    /**
     * Gets the current turn player
     * @return current turn player
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Sets the current turn player
     * @param pTurn an integer representing the player ID to be set as the current turn player
     */
    public void setPlayerTurn(int pTurn) {
        this.playerTurn = pTurn;
    }

    /**
     * Gets the list of players
     * @return the list of players
     */
    public List<Player> getPlayers() {
        return players;
    }
}
