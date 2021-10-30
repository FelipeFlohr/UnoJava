package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;

public class Player {

    private List<Card> deck = new ArrayList<>();
    private final int id;
    private int initialAmountOfCards;

    public Player(int id) throws InvalidNumberException, InvalidColorException {
        this.id = id;

        for (int i = 0; i < getInitialCardsAmount(); i++) {
            deck.add(generateRandomCard());
        }
    }

    public Player(int id, int initialAmountOfCards) throws InvalidNumberException, InvalidColorException {
        this.id = id;
        this.initialAmountOfCards = initialAmountOfCards;

        for (int i = 0; i < initialAmountOfCards; i++) {
            deck.add(generateRandomCard());
        }
    }

    private Card generateRandomCard() throws InvalidNumberException, InvalidColorException {
        String sortedColor;
        String sortedNumber;

        final String BLACK_COLOR = "black";
        final String[] COLORS = { "red", "blue", "green", "yellow" };
        final String[] NORMAL_NUMBERS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        final String[] SPECIAL_NUMBERS = { "wild2", "reverse", "skip" };
        final String[] BLACK_NUMBERS = { "wild4", "wild" };

        Random random = new Random();
        boolean isCardSpecial = random.nextInt(100) >= (100 - getChanceOfSpecialCard());

        if (isCardSpecial) {
            boolean isBlackCard = random.nextInt(100) >= (100 - getChanceOfBlackSpecialCard());

            if (isBlackCard) {
                int cardNumberIndex = random.nextInt(0, BLACK_NUMBERS.length);
                sortedNumber = BLACK_NUMBERS[cardNumberIndex];
                sortedColor = BLACK_COLOR;
            } else {
                int cardNumberIndex = random.nextInt(0, SPECIAL_NUMBERS.length);
                int cardColorIndex = random.nextInt(0, COLORS.length);

                sortedNumber = SPECIAL_NUMBERS[cardNumberIndex];
                sortedColor = COLORS[cardColorIndex];
            }
        } else {
            int cardNumberIndex = random.nextInt(0, NORMAL_NUMBERS.length);
            int cardColorIndex = random.nextInt(0, COLORS.length);

            sortedNumber = NORMAL_NUMBERS[cardNumberIndex];
            sortedColor = COLORS[cardColorIndex];
        }

        return new Card(sortedNumber, sortedColor);
    }

    public void removeCardByIndex(int i) {
        deck.remove(i);
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
}
