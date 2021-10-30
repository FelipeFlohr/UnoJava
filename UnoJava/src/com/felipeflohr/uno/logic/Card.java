package com.felipeflohr.uno.logic;

import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.exception.InvalidNumberException;

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
