package com.felipeflohr.uno.globaldefs;

import com.felipeflohr.uno.logic.Table;
import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel.CenterPagePanel;

import static com.felipeflohr.uno.swing.UpdatableElements.updateUIElements;

public class GlobalDefinitions {

    private static final int TOTAL_AMOUNT_OF_PLAYERS = 4;
    private static final int INITIAL_CARDS = 12;
    private static final boolean AI_ENABLED = true;
    private static final int CHANCE_OF_SPECIAL_CARD = 40;
    private static final int CHANCE_OF_BLACK_SPECIAL_CARD = 35;
    private static final int CARD_ICON_WIDTH = 96;
    private static final int CARD_ICON_HEIGHT = 128;
    private static final Table TABLE = new Table();
    private static final int CARD_GRID_ROWS = 3;
    private static final int CARD_GRID_COLUMNS = 3;
    private static int currentPlayer = 0;
    private static int nonAiPlayer = 0;
    private static int currentPage = 0;
    private static CenterPagePanel centerPagePanel; // The panel where the buttons are being hold

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

    public static Table getTable() {
        return TABLE;
    }

    public static int getCardIconWidth() {
        return CARD_ICON_WIDTH;
    }

    public static int getCardIconHeight() {
        return CARD_ICON_HEIGHT;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(int playerID) {
        currentPlayer = playerID;
        updateUIElements();
    }

    public static int getCardGridRows() {
        return CARD_GRID_ROWS;
    }

    public static int getCardGridColumns() {
        return CARD_GRID_COLUMNS;
    }

    public static int getNonAiPlayer() {
        return nonAiPlayer;
    }

    public static void setNonAiPlayer(int nonAiPlayer) {
        GlobalDefinitions.nonAiPlayer = nonAiPlayer;
    }

    public static int getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(int currentPage) {
        GlobalDefinitions.currentPage = currentPage;
    }

    public static CenterPagePanel getCenterPagePanel() {
        return centerPagePanel;
    }

    public static void setCenterPagePanel(CenterPagePanel centerPagePanel) {
        GlobalDefinitions.centerPagePanel = centerPagePanel;
    }
}
