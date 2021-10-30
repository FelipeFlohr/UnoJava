package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;

import java.util.Random;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getChanceOfBlackSpecialCard;
import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getChanceOfSpecialCard;

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

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (special != card.special) return false;
        if (!number.equals(card.number)) return false;
        return color.equals(card.color);
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
        return "Number: " + number + "\nColor: " + color + "\nIs special: " + special;
    }
}
