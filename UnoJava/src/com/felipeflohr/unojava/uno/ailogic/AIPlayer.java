package com.felipeflohr.unojava.uno.ailogic;

import com.felipeflohr.unojava.exception.AINoConditionAvailableException;
import com.felipeflohr.unojava.globaldefs.GlobalDefinitions;
import com.felipeflohr.unojava.uno.Card;
import com.felipeflohr.unojava.uno.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getTable;
import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.isAiDebugMessagesEnabled;

/**
 * A player-inherited class that defines the behaviour for the AI
 * @author Felipe Matheus Flohr
 */
public class AIPlayer extends Player {

    /**
     * Constructor for the class. Will set the AI enabled to true when called.
     * @param id an integer representing the player ID. Must be distinct from other players.
     */
    public AIPlayer(int id) {
        super(id);
        this.setAiEnabled(true);
    }

    /**
     * The default AI Behaviour. The AI will make its decision based on the first true condition.
     * @throws InterruptedException if no condition is reached.
     */
    public void defaultAI() throws InterruptedException {
        System.out.println("==========================");
        System.out.println("AI Called");

        aiPrintln("It's player #" + getId() + " turn.");
        aiPrintln(getTable());

        getTable().setSkip(false);

        // The AI will be based on conditions
        final boolean CONDITION_1 = wild4OnlyPlayableCard() && getTable().getBuyTurnAmount() == 0 && getDeck().size() > 1;
        final boolean CONDITION_2 = getTable().getBuyTurnAmount() > 0 && hasBuyTurnCard();
        final boolean CONDITION_3 = getTable().getPlayerByIndex(getTable().getNextPlayer()).getDeck().size() < 3 && hasWild4or2();
        final boolean CONDITION_4 = hasSkip();
        final boolean CONDITION_5 = hasReverse();
        final boolean CONDITION_6 = hasAnyNormalCard();
        final boolean CONDITION_7 = hasCard(new Card("wild", "black"));
        final boolean CONDITION_8 = hasWild2();
        final boolean CONDITION_9 = !atLeastOneCardPlayable();

        // AI Print about conditions
        aiPrintln("--------------------------");
        aiPrintln("Conditions:");
        aiPrintln("Condition 1 = " + CONDITION_1 + " | Buy turn amount is greater than 0 (current " + getTable().getBuyTurnAmount() + ") & only playable card is +4 (status: " + wild4OnlyPlayableCard() + ") & the player has more than one card (status: " + (getDeck().size() > 1) + ")");
        aiPrintln("Condition 2 = " + CONDITION_2 + " | Buy turn amount is greater than 0 (current " + getTable().getBuyTurnAmount() + ") and player has the buying turn card (status: " + hasBuyTurnCard() + ")");
        aiPrintln("Condition 3 = " + CONDITION_3 + " | Player's deck size is smaller than 3 (current: " + getTable().getPlayerByIndex(getTable().getNextPlayer()).getDeck().size() + ", status: " + (getTable().getPlayerByIndex(getTable().getNextPlayer()).getDeck().size() < 3) + ") and current player has a +4 or +2 card (status: " + hasWild4or2() +")");
        aiPrintln("Condition 4 = " + CONDITION_4 + " | Player has a skip card and it is playable (status: " + hasSkip() + ")");
        aiPrintln("Condition 5 = " + CONDITION_5 + " | Player has a reverse card and it is playable (status: " + hasReverse() + ")");
        aiPrintln("Condition 6 = " + CONDITION_6 + " | Player has any playable normal card (status: " + hasAnyNormalCard() + ")");
        aiPrintln("Condition 7 = " + CONDITION_7 + " | Player has a wild card (status: " + hasCard(new Card("wild", "black")) + ")");
        aiPrintln("Condition 8 = " + CONDITION_8 + " | Player has a +2 card (status: " + hasWild2() + ")");
        aiPrintln("Condition 9 = " + CONDITION_9 + " | Player doesn't has any playable card, so a card will be bought");

        // The AI will choose the first condition available
        if (GlobalDefinitions.isAiEnabled()) {
            if (CONDITION_1) { // Condition 1
                aiPrintln("\nCondition 1 was taken. A card will be bought. ");

                aiBuyCard();
                if (atLeastOneNormalCardPlayable()) {
                    aiPrint("There's at least one normal card. It will be played");
                    getNormalCard().playCard();
                } else {
                    aiPrint("There isn't one normal card to be played");
                }
            } else if (CONDITION_2) { // Condition 2
                aiPrintln("\nCondition 2 was taken. The player will play the buy turn card");

                getBuyTurnCard().playCard();
            } else if (CONDITION_3) { // Condition 3
                aiPrintln("\nCondition 3 was taken. ");

                if (hasWild2()) {
                    aiPrint("A +2 will be played.");
                    getWild2Card().playCard();
                } else {
                    aiPrint("A +4 will be played");
                    Card wild4Card = new Card("wild4", "black");

                    wild4Card.playCard();
                }
            } else if (CONDITION_4) {
                aiPrintln("\nCondition 4 was taken. A skip will be played");

                getSkipCard().playCard();
            } else if (CONDITION_5) {
                aiPrintln("\nCondition 5 was taken. A reverse will be played");

                getReverseCard().playCard();
            } else if (CONDITION_6) {
                aiPrintln("\nCondition 6 was taken. A normal card will be played");

                getNormalCard().playCard();
            } else if (CONDITION_7) {
                aiPrintln("\nCondition 7 was taken. A wild card will be played");

                Card wildCard = new Card("wild", "black");
                wildCard.playCard();
            } else if (CONDITION_8) {
                aiPrintln("\nCondition 8 was taken. A +2 card will be played");

                getWild2Card().playCard();
            } else if (CONDITION_9) {
                aiPrintln("\nCondition 9 was taken. Card(s) will be bought");

                aiBuyCard();
                if (atLeastOneNormalCardPlayable()) {
                    aiPrint(". Also, a normal card will be played");
                    getNormalCard().playCard();
                }
            } else {
                System.out.println("Player #" + getId() + " reach out of conditions.");
                System.out.println("His deck: " + this);
                System.out.println("Size of the deck: " + getDeck().size());
                System.out.println("An exception will be thrown within three seconds");
                Thread.sleep(3000);

                throw new AINoConditionAvailableException("There's no condition available for player #" + getId());
            }
        } else {
            aiPrintln("AI is not enabled");
        }

        aiApplyCardEffects();
        aiPrintln("Card on table is: " + getTable().getCurrentCard());
        getTable().moveToNextPlayer();
    }

    // AI Methods
    /**
     * Checks if the only playable card on player's deck is +4
     * @return true if the only playable card is +4
     */
    private boolean wild4OnlyPlayableCard() {
        List<String> playableCards = new ArrayList<>();

        getDeck().forEach(pCard -> {
                    if (pCard.isCardPlayable(getTable())) {
                        playableCards.add(pCard.getNumber());
                    }
                });

        Predicate<String> wild4Predicate = card -> card.equals("wild4");
        return playableCards.stream().allMatch(wild4Predicate) && playableCards.size() > 0;
    }

    /**
     * Checks if at least there is one playable card on the deck
     * @return true if at least there is one playable card
     */
    private boolean atLeastOneCardPlayable() {
        return getDeck().stream().anyMatch(card -> card.isCardPlayable(getTable()));
    }

    /**
     * Checks if at least there is one normal playable card on the deck
     * @return true if at least there is one normal playable card
     */
    private boolean atLeastOneNormalCardPlayable() {
        return getDeck().stream()
                .filter(card -> card.isCardPlayable(getTable()))
                .anyMatch(card -> !card.isSpecial());
    }

    /**
     * Will buy one or more cards according to the Table's stats.
     */
    private void aiBuyCard() {
        if (getTable().getBuyTurnAmount() > 0) {
            buyCard(getTable().getBuyTurnAmount());
            aiPrintln("Player #" + getId() + " bought " + getTable().getBuyTurnAmount() + " cards");
        } else {
            buyCard();
            aiPrintln("Player #" + getId() + " bought one card");
        }
        getTable().setBuyTurnCard(null);
        getTable().setBuyTurnAmount(0);
    }

    /**
     * Checks if player has the specified card on its deck
     * @param card Card-type object to check if it's present on the deck
     * @return true if player has the card on the deck
     */
    private boolean hasCard(Card card) {
        try{
            return getDeck().stream().anyMatch(card::equals);
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Applies the effect of the current card on table
     */
    private void aiApplyCardEffects() {
        if (getTable().getCurrentCard().getColor().equals("black")) {
            aiPrintln("Applying the AI Card effect");
            final String color = getPlayerMostColors();
            aiPrintln("AI Selected color is: " + color);
            getTable().setColorSelected(color);
        }
    }

    /**
     * Gets the color who appears the most on the player's deck
     * @return the major color on player's deck
     */
    private String getPlayerMostColors() {
        String majorColor = "";
        int blue = 0;
        int green = 0;
        int red = 0;
        int yellow = 0;

        for (int i = 0; i < getDeck().size(); i++) {
            switch (getDeck().get(i).getColor()) {
                case "blue" -> blue += 1;
                case "green" -> green += 1;
                case "red" -> red += 1;
                case "yellow" -> yellow += 1;
            }
        }

        int prevValue = -1;
        if (blue > prevValue) {
            majorColor = "blue";
            prevValue = blue;
        }

        if (green > prevValue) {
            majorColor = "green";
            prevValue = green;
        }

        if (red > prevValue) {
            majorColor = "red";
            prevValue = red;
        }

        if (yellow > prevValue) {
            majorColor = "yellow";
        }

        return majorColor;
    }

    /**
     * Checks if player has +4 or +2
     * @return true if player has +4 or +2
     */
    private boolean hasWild4or2() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("wild2") || card.getNumber().equals("wild4"));
    }

    /**
     * Checks if player has a Skip card
     * @return true if player has a Skip card
     */
    private boolean hasSkip() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("skip"));
    }

    /**
     * Checks if player has a Reverse card
     * @return true if player has a Reverse card
     */
    private boolean hasReverse() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("reverse"));
    }

    /**
     * Checks if player has any normal card
     * @return true if player has any normal card
     */
    private boolean hasAnyNormalCard() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> !card.isSpecial());
    }

    /**
     * Checks if player has +2
     * @return true if player has +2
     */
    private boolean hasWild2() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("wild2"));
    }

    /**
     * Checks if player has the buy turn card
     * @return true if player has the buy turn card
     */
    private boolean hasBuyTurnCard() {
        try {
            return getDeck().stream()
                    .filter(filter -> filter.isCardPlayable(getTable()))
                    .anyMatch(card -> card.getNumber().equals(getTable().getBuyTurnCard().getNumber()));
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Gets a +2 card from player's deck
     * @return a +2 card
     */
    private Card getWild2Card() {
        return getDeck().stream()
                .filter(c1 -> c1.isCardPlayable(getTable()))
                .filter(c1 -> c1.getNumber().equals("wild2"))
                .findFirst()
                .get();
    }

    /**
     * Gets a Skip card from player's deck
     * @return a Skip card
     */
    private Card getSkipCard() {
        return getDeck().stream()
                .filter(c1 -> c1.isCardPlayable(getTable()))
                .filter(c1 -> c1.getNumber().equals("skip"))
                .findFirst()
                .get();
    }

    /**
     * Gets a Reverse card from player's deck
     * @return a Reverse card
     */
    private Card getReverseCard() {
        return getDeck().stream()
                .filter(c1 -> c1.isCardPlayable(getTable()))
                .filter(c1 -> c1.getNumber().equals("reverse")).findFirst()
                .get();
    }

    /**
     * Gets a normal card from player's deck
     * @return a Normal card
     */
    private Card getNormalCard() {
        return getDeck().stream()
                .filter(c1 -> !c1.isSpecial())
                .filter(c1 -> c1.isCardPlayable(getTable()))
                .findFirst()
                .get();
    }

    /**
     * Gets the buy turn card from player's deck
     * @return the buy turn card
     */
    private Card getBuyTurnCard() {
        return getDeck().stream()
                .filter(c1 -> c1.getNumber().equals(getTable().getBuyTurnCard().getNumber()))
                .filter(c1 -> c1.isCardPlayable(getTable()))
                .findFirst()
                .get();
    }

    // AI Print
    /**
     * Will print AI debug messages
     * @param message the message to be printed
     */
    private void aiPrintln(Object message) {
        if (isAiDebugMessagesEnabled()) {
            System.out.println(message);
        }
    }

    /**
     * Will print AI debug messages
     * @param message the message to be printed
     */
    private void aiPrint(Object message) {
        if (isAiDebugMessagesEnabled()) {
            System.out.print(message);
        }
    }
}
