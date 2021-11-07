package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;
import com.felipeflohr.uno.globaldefs.GlobalDefinitions;

import java.util.Random;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;

public class Card {

    private final String number;
    private final String color;
    private final boolean special;

    public Card(String number, String color) throws InvalidNumberException, InvalidColorException {
        this.number = number;
        this.color = color;
        this.special = color.equals("black")
                || number.equals("wild2")
                || number.equals("reverse")
                || number.equals("skip");

        boolean isNumeric;
        try {
            isNumeric = Integer.parseInt(number) >= 0 && Integer.parseInt(number) <= 9;
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        if (!isNumeric && !special) {
            throw new InvalidNumberException();
        }

        if (!color.equals("black")
                && !color.equals("red")
                && !color.equals("blue")
                && !color.equals("yellow")
                && !color.equals("green")) {
            throw new InvalidColorException();
        }
    }

    public static Card generateRandomCard() throws InvalidNumberException, InvalidColorException {
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

    public static Card generateRandomNormalCard() {
        String sortedColor;
        String sortedNumber;

        final String[] COLORS = { "red", "blue", "green", "yellow" };
        final String[] NORMAL_NUMBERS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        Random random = new Random();
        int cardNumberIndex = random.nextInt(0, NORMAL_NUMBERS.length);
        int cardColorIndex = random.nextInt(0, COLORS.length);

        sortedNumber = NORMAL_NUMBERS[cardNumberIndex];
        sortedColor = COLORS[cardColorIndex];

        return new Card(sortedNumber, sortedColor);
    }

    public boolean isCardPlayable(Table table) {
        boolean isPlayable;

        if (getTable().getPlayerTurn() == GlobalDefinitions.getCurrentLocalPlayer()) {
            // If there is a buying card only turn
            if(table.getBuyTurnCard() != null) {
                isPlayable = switch (this.getNumber()) {
                    case "wild2", "wild4" -> table.getCurrentCard().equals(this);
                    default -> false;
                };

                // If there's a color selected turn
            } else if (table.getColorSelected() != null) {
                isPlayable = getColor().equals(table.getColorSelected()) || getColor().equals("black");
            } else if (table.getCurrentCard().getColor().equals("black") && table.getColorSelected() == null) { // If there's a black card on table no color selected
                isPlayable = true;
            } // If there's no matching conditions as these above
            else {
                isPlayable = this.getColor().equals(table.getCurrentCard().getColor())
                        || this.getNumber().equals(table.getCurrentCard().getNumber())
                        || this.getColor().equals("black");
            }
        } else {
            isPlayable = false;
        }

        return isPlayable;
    }

    public void playCard() {
        getTable().setCurrentCard(this);
        getTable().getPlayerByIndex(getCurrentLocalPlayer()).removeCard(this);
        getTable().applyCardChangeEffects();
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return number.equals(card.number);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (special ? 1 : 0);
        return result;
    }

    // Getters
    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public boolean isSpecial() {
        return special;
    }

    @Override
    public String toString() {
        return "[ " + number + ", " + color + " ]";
    }
}
