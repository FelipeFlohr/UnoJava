package com.felipeflohr.unojava.globaldefs;

import com.felipeflohr.unojava.uno.Table;
import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.CenterPagePanel;

import static com.felipeflohr.unojava.swing.UpdatableElements.updateUIElements;

/**
 * Class that holds static variables that represents global game definitions
 */
public class GlobalDefinitions {

    private static final int CHANCE_OF_SPECIAL_CARD = 40;
    private static final int CHANCE_OF_BLACK_SPECIAL_CARD = 35;
    private static final int UNO_MISCLICK_AMOUNT_OF_CARDS = 2;
    private static final int NON_AI_PLAYER = 0;
    private static final int CURRENT_LOCAL_PLAYER = 0;
    private static int totalAmountOfPlayers = 4;
    private static int initialCards = 7;
    private static int cardIconWidth = 86;
    private static int cardIconHeight = 128;
    private static int cardGridRows = 3;
    private static int cardGridColumns = 3;
    private static int currentCardImageWidth = 256;
    private static int currentCardImageHeight = 400;
    private static int currentPage = 0;
    private static boolean printUpdateMessages = false;
    private static boolean printAddedElementMessages = false;
    private static boolean aiEnabled = true;
    private static boolean aiDebugMessagesEnabled = false;
    private static CenterPagePanel centerPagePanel;
    private static Table table = new Table();

    // Methods
    public static void restartTable() {
        table = new Table();
        updateUIElements();
    }

    // Custom static getters & setters
    public static int getCurrentLocalPlayer() {
        return CURRENT_LOCAL_PLAYER;
    }

    // Default static getters & setters
    public static int getTotalAmountOfPlayers() {
        return totalAmountOfPlayers;
    }

    public static void setTotalAmountOfPlayers(int amount) {
        totalAmountOfPlayers = amount;
    }

    public static int getInitialCardsAmount() {
        return initialCards;
    }

    public static void setInitialCardsAmount(int amount) {
        initialCards = amount;
    }

    public static boolean isAiEnabled() {
        return aiEnabled;
    }

    public static void setAiEnabled(boolean value) {
        aiEnabled = value;
    }

    public static boolean isAiDebugMessagesEnabled() {
        return aiDebugMessagesEnabled;
    }

    public static void setAiDebugMessagesEnabled(boolean value) {
        aiDebugMessagesEnabled = value;
    }

    public static int getChanceOfSpecialCard() {
        return CHANCE_OF_SPECIAL_CARD;
    }

    public static int getChanceOfBlackSpecialCard() {
        return CHANCE_OF_BLACK_SPECIAL_CARD;
    }

    public static Table getTable() {
        return table;
    }

    public static int getCardIconWidth() {
        return cardIconWidth;
    }

    public static void setCardIconWidth(int amount) {
        cardIconWidth = amount;
    }

    public static int getCardIconHeight() {
        return cardIconHeight;
    }

    public static void setCardIconHeight(int amount) {
        cardIconHeight = amount;
    }

    public static int getCardGridRows() {
        return cardGridRows;
    }

    public static void setCardGridRows(int amount) {
        cardGridRows = amount;
    }

    public static int getCardGridColumns() {
        return cardGridColumns;
    }

    public static void setCardGridColumns(int amount) {
        cardGridColumns = amount;
    }

    public static int getNonAiPlayer() {
        return NON_AI_PLAYER;
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

    public static int getUnoMisclickAmountOfCards() {
        return UNO_MISCLICK_AMOUNT_OF_CARDS;
    }

    public static int getCurrentCardImageWidth() {
        return currentCardImageWidth;
    }

    public static void setCurrentCardImageWidth(int amount) {
        currentCardImageWidth = amount;
    }

    public static int getCurrentCardImageHeight() {
        return currentCardImageHeight;
    }

    public static void setCurrentCardImageHeight(int amount) {
        currentCardImageHeight = amount;
    }

    public static boolean isPrintUpdateMessages() {
        return printUpdateMessages;
    }

    public static void setPrintUpdateMessages(boolean value) {
        printUpdateMessages = value;
    }

    public static boolean isPrintAddedElementMessages() {
        return printAddedElementMessages;
    }

    public static void setPrintAddedElementMessages(boolean value) {
        printAddedElementMessages = value;
    }
}
