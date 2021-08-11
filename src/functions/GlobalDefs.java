package functions;

import gui.panels.centerpanel.left.CenterCenterLeftPanel;

// This file will be responsible for defining some in-game configs
public class GlobalDefs {

    public final static int NUMBER_OF_PLAYERS = 4;
    public final static int NUMBER_OF_AIPLAYERS = 3;
    public final static int NUMBER_OF_INITIAL_CARDS = 100;
    public final static int CHANCE_OF_NORMAL_CARD = 80; // Will define the chance of a normal card be sorted
    public final static int CHANCE_OF_SPECIAL_CARD = 20; // Will define the chance of a special card be sorted
    public final static int PLAYER_ID = 0; // Will define the Player Number within the ArrayList
    public static int currentPage = 0; // Will define the current player's deck page
    public static int totalAmountOfPages = (int) Math.ceil((double) Decks.getGameDeck().get(GlobalDefs.PLAYER_ID).size() / (double) (CenterCenterLeftPanel.GRID_ROWS * CenterCenterLeftPanel.GRID_COLS));

}
