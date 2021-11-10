package com.felipeflohr.unojava.uno.ailogic;

import com.felipeflohr.unojava.exception.AINoConditionAvailableException;
import com.felipeflohr.unojava.uno.Card;
import com.felipeflohr.unojava.uno.Player;
import com.felipeflohr.unojava.uno.Table;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getTable;
import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.isAiDebugMessagesEnabled;

public class AIPlayer extends Player {

    public AIPlayer(int id) {
        super(id);
        this.setAiEnabled(true);
    }

    public void defaultAI() {
        // FIXME Skip status is not setting to null when a card is played
        if (!isAiEnabled()) {
            aiPrint("AI is not enabled. Skipping player #" + getId() + " turn.");
            getTable().moveToNextPlayer();
        } else {
            if (atLeastOneCardPlayable()) {
                aiPrint("\nThere is at least one playable card. Starting AI #" + getId() + " turn of choosing a card");

                aiPrint("\n1. The only playable card is +4, the buy turn amount is 0 and the player has more than one card");
                if (wild4OnlyPlayableCard() && getTable().getBuyTurnAmount() == 0 && getDeck().size() > 1) {
                    aiPrint("Condition #1 Matched!");
                    aiBuyCard();
                    if (atLeastOneCardPlayable()) {
                        aiPrint("There is a playable card. Playing it");
                        getRandomCard().playCard();
                        aiApplyCardEffects();
                    } else {
                        aiPrint("There isn't a playable card.");
                    }

                    aiPrint("Moving to the next player");
                    getTable().moveToNextPlayer();
                } else {
                    aiPrint("Condition #1 not matched. Moving to Condition 2");

                    aiPrint("\n2. Buy turn amount is greater than 0 and player has the buying turn card");
                    if (getTable().getBuyTurnAmount() > 0 && hasCard(getTable().getBuyTurnCard())) {
                        aiPrint("Condition #2 Matched!");
                        aiPrint("There is a playable card. Playing it");
                        getRandomCard().playCard();
                        aiApplyCardEffects();
                        getTable().moveToNextPlayer();
                    } else {
                        aiPrint("Condition #2 not matched. Moving to Condition 3");

                        aiPrint("\n3. Next player's deck size is smaller than 3 and current player has a +4 or +2 card");
                        boolean nextPlayerLowOnCards = getTable().getPlayerByIndex(getTable().getNextPlayer()).getDeck().size() < 3;
                        boolean currentPlayerWild2or4 = hasWild4or2();
                        if (nextPlayerLowOnCards && currentPlayerWild2or4) {
                            aiPrint("Condition #3 Matched!");

                            aiPrint("Checking if player has a +4 card");
                            if (hasCard(new Card("wild4", "black"))) {
                                aiPrint("Player has a +4 card. Playing it");
                                Card wild4Card = new Card("wild4", "black");
                                wild4Card.playCard();
                            } else {
                                aiPrint("There are no +4 cards. Playing a +2");
                                getWild2Card().playCard();
                            }
                            aiPrint("Card played");
                            aiApplyCardEffects();
                            getTable().moveToNextPlayer();
                        }
                        else {
                            aiPrint("Condition #3 not matched. Moving to Condition 4");

                            aiPrint("\n4. Player has a skip card and it is playable");
                            if (hasSkip()) {
                                aiPrint("Condition #4 Matched!");
                                getSkipCard().playCard();
                                aiApplyCardEffects();
                                getTable().moveToNextPlayer();
                            } else {
                                aiPrint("Condition #4 not matched. Moving to Condition 5");

                                aiPrint("\n5. Player has a reverse card and it is playable");
                                if (hasReverse()) {
                                    aiPrint("Condition #5 Matched!");
                                    getReverseCard().playCard();
                                    aiApplyCardEffects();
                                    getTable().moveToNextPlayer();
                                } else {
                                    aiPrint("Condition #5 not matched. Moving to Condition 6");

                                    aiPrint("\n6. Player has any normal card");
                                    if (hasAnyNormalCard()) {
                                        aiPrint("Condition #6 Matched!");
                                        getNormalCard().playCard();
                                        aiApplyCardEffects();
                                        getTable().moveToNextPlayer();
                                    } else {
                                        aiPrint("Condition #6 not matched. Moving to Condition 7");

                                        aiPrint("\n7. Player has a wild");
                                        if (hasCard(new Card("wild", "black"))) {
                                            aiPrint("Condition #7 Matched!");
                                            Card wild = new Card("wild", "black");
                                            wild.playCard();
                                            aiApplyCardEffects();
                                            getTable().moveToNextPlayer();
                                        } else {
                                            aiPrint("Condition #7 not matched. Moving to Condition 8");

                                            aiPrint("\n8. Player has a +2 and it's playable");
                                            if (hasWild2()) {
                                                aiPrint("Condition #8 Matched!");
                                                getWild2Card().playCard();
                                                aiApplyCardEffects();
                                                getTable().moveToNextPlayer();
                                            } else {
                                                aiPrint("No condition was found for player #" + getId() + ". A exception will be raised");
                                                throw new AINoConditionAvailableException();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                aiPrint("There are no playable cards");
                aiBuyCard();
                if (getTable().getBuyTurnAmount() <= 0) {
                    if (atLeastOneCardPlayable()) {
                        getRandomCard().playCard();
                    }
                }
                getTable().moveToNextPlayer();
            }
        }
    }

    // AI Methods
    private boolean wild4OnlyPlayableCard() {
        List<String> playableCards = new ArrayList<>();

        getDeck().forEach(pCard -> {
                    if (pCard.isCardPlayable(getTable())) {
                        playableCards.add(pCard.getNumber());
                    }
                });

        aiPrint("The playable numbers are: " + playableCards);

        Predicate<String> wild4Predicate = card -> card.equals("wild4");
        return playableCards.stream().allMatch(wild4Predicate) && playableCards.size() > 0;
    }

    private boolean atLeastOneCardPlayable() {
        return getDeck().stream().anyMatch(card -> card.isCardPlayable(getTable()));
    }

    private void aiBuyCard() {
        if (getTable().getBuyTurnAmount() > 0) {
            buyCard(getTable().getBuyTurnAmount());
            aiPrint("Player #" + getId() + " bought " + getTable().getBuyTurnAmount() + " cards");
        } else {
            buyCard();
            aiPrint("Player #" + getId() + " bought one card");
        }
    }

    private Card getRandomCard() {
        AtomicReference<Card> card = new AtomicReference<>();
        Consumer<Card> cardConsumer = card::set;

        getDeck().stream()
            .filter(c -> c.isCardPlayable(getTable()))
            .findFirst().ifPresent(cardConsumer);

        return card.get();
    }

    private boolean hasCard(Card card) {
        System.out.println("Searching for card: " + card);
        boolean result = getDeck().stream().anyMatch(card::equals);
        System.out.println("Card found: " + result);
        return result;
    }

    private void aiApplyCardEffects() {
        if (getTable().getCurrentCard().getColor().equals("black")) {
            aiPrint("Applying the AI Card effect");
            final String color = getPlayerMostColors();
            aiPrint("AI Selected color is: " + color);
            getTable().setColorSelected(color);
        }
    }

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
            prevValue = yellow;
        }

        return majorColor;
    }

    private boolean hasWild4or2() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("wild2") || card.getNumber().equals("wild4"));
    }

    private boolean hasSkip() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("skip"));
    }

    private boolean hasReverse() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("reverse"));
    }

    private boolean hasAnyNormalCard() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> !card.isSpecial());
    }

    private boolean hasWild2() {
        return getDeck().stream()
                .filter(filter -> filter.isCardPlayable(getTable()))
                .anyMatch(card -> card.getNumber().equals("wild2"));
    }

    private Card getWild2Card() {
        return getDeck().stream().filter(c1 -> c1.getNumber().equals("wild2")).findFirst().get();
    }

    private Card getSkipCard() {
        return getDeck().stream().filter(c1 -> c1.getNumber().equals("skip")).findFirst().get();
    }

    private Card getReverseCard() {
        return getDeck().stream().filter(c1 -> c1.getNumber().equals("reverse")).findFirst().get();
    }

    private Card getNormalCard() {
        return getDeck().stream().filter(c1 -> !c1.isSpecial()).findFirst().get();
    }

    // AI Print
    private void aiPrint(Object message) {
        if (isAiDebugMessagesEnabled()) {
            System.out.println(message);
        }
    }
}
