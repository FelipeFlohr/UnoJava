package com.felipeflohr.unojava.uno;

import com.felipeflohr.unojava.exception.InvalidColorException;
import com.felipeflohr.unojava.exception.InvalidNumberException;

import java.util.Random;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;

/**
 * Represents a card object. The main two attributes are the Number and Color.
 * @author Felipe Matheus Flohr
 */
public class Card {

    private final String number;
    private final String color;
    private final boolean special;

    /**
     * Constructor for the Card class. Defines the color and number of it.
     * @param number a String representing the number of the card. Valid numbers are: "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "wild2", "reverse", "skip", "wild4", "wild"
     * @param color a String representing the color of the card. Valid colors are: "black", "blue", "green", "red", "yellow".
     * @throws InvalidNumberException if the number is invalid.
     * @throws InvalidColorException if the color is invalid.
     */
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

    // Static methods
    /**
     * Generates a random card. It can be a normal or special. The probability of a special card be generated is specified on the Global Definitions.
     * @return a random generated Card
     * @throws InvalidNumberException if the Number is invalid
     * @throws InvalidColorException if the Color is invalid
     */
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

    /**
     * Generates a random normal card.
     * @return a random normal card
     */
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

    /**
     * Defines if this card is playable or not.
     * @param table the game's table.
     * @return true if this card is playable
     */
    // Public methods
    public boolean isCardPlayable(Table table) {
        boolean isPlayable;

        // If there is a buying card only turn
        if(table.getBuyTurnCard() != null) {
            isPlayable = switch (this.getNumber()) {
                case "wild2", "wild4" -> table.getCurrentCard().equals(this);
                default -> false;
            };

            // If there's a color selected turn
        } else if (table.getColorSelected() != null) {
            boolean blackCardSameNumber = getColor().equals("black") && getNumber().equals(table.getCurrentCard().getNumber());
            isPlayable = getColor().equals(table.getColorSelected()) || blackCardSameNumber;
        } else if (table.getCurrentCard().getColor().equals("black") && table.getColorSelected() == null) { // If there's a black card on table no color selected
            isPlayable = true;
        } // If there's no matching conditions as these above
        else {
            isPlayable = this.getColor().equals(table.getCurrentCard().getColor())
                    || this.getNumber().equals(table.getCurrentCard().getNumber())
                    || this.getColor().equals("black");
        }

        return isPlayable;
    }

    /**
     * Sets this card as the current card on table. Also, apply its effects.
     */
    public void playCard() {
        getTable().setCurrentCard(this);
        getTable().getPlayerByIndex(getTable().getPlayerTurn()).removeCard(this);
        getTable().applyCardChangeEffects();
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!getNumber().equals(card.getNumber())) return false;
        return getColor().equals(card.getColor());
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (special ? 1 : 0);
        return result;
    }

    // To String
    @Override
    public String toString() {
        return "[ " + number + ", " + color + " ]";
    }

    /**
     * Getter for the card number
     * @return number of the card
     */
    // Getters
    public String getNumber() {
        return number;
    }

    /**
     * Getter for the card color
     * @return color of the card
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for the "Special" attribute
     * @return true if the card is special
     */
    public boolean isSpecial() {
        return special;
    }
}
