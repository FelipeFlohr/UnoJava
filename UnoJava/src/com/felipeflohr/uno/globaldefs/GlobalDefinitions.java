package com.felipeflohr.uno.globaldefs;

public class GlobalDefinitions {

    private static final int TOTAL_AMOUNT_OF_PLAYERS = 4;
    private static final int INITIAL_CARDS = 7;
    private static final boolean AI_ENABLED = true;
    private static final int CHANCE_OF_SPECIAL_CARD = 40;
    private static final int CHANCE_OF_BLACK_SPECIAL_CARD = 35;

    // Static getters
    public static int getTotalAmountOfPlayers() {
        return TOTAL_AMOUNT_OF_PLAYERS;
    }

    public static int getInitialCardsAmount() {
        return INITIAL_CARDS;
    }

    public static boolean isAiEnabled() {
        return AI_ENABLED;
    }

    public static int getChanceOfSpecialCard() {
        return CHANCE_OF_SPECIAL_CARD;
    }

    public static int getChanceOfBlackSpecialCard() {
        return CHANCE_OF_BLACK_SPECIAL_CARD;
    }
}
