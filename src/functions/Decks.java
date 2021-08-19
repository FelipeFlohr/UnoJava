package functions;

import java.util.ArrayList;
import java.util.Random;

import static gui.panels.centerpanel.left.CenterCenterLeftPanel.GRID_COLS;
import static gui.panels.centerpanel.left.CenterCenterLeftPanel.GRID_ROWS;

/**
 * Class responsible for holding cards-related methods
 */
public class Decks {

    /**
     * Holds the deck of all players inside a 3D ArrayList
     */
    private static ArrayList<ArrayList<ArrayList<String>>> gameDeck = generateInitialDeck();
    /**
     * Holds the deck of the current player divided by the total amount of pages
     */
    private static ArrayList<ArrayList<ArrayList<String>>> currentPlayerDecks = generateCurrentPlayerDividedDecks();

    /**
     * Generates a deck with both normal and special cards
     * @return Returns a 2D ArrayList in a deck
     */
    // Will create a 2D ArrayList to store a player deck
    public static ArrayList<ArrayList<String>> generateDeck(){
        ArrayList<ArrayList<String>> deck = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < GlobalDefs.NUMBER_OF_INITIAL_CARDS; i++){
            int cardTypeGenerated = random.nextInt(100);
            ArrayList<String> carta;
            if(cardTypeGenerated <= GlobalDefs.CHANCE_OF_NORMAL_CARD){
                carta = CardsMethods.generateNormalCard();
            }
            else{
                carta = CardsMethods.generateSpecialCard();
            }
            deck.add(carta);
        }
        return deck;
    }

    /**
     * Will create a 3D ArrayList holding all players decks.
     * @return Returns a 3D ArrayList holding all players decks.
     */
    // Will create a 3D ArrayList to store all players deck
    public static ArrayList<ArrayList<ArrayList<String>>> generateInitialDeck(){
        ArrayList<ArrayList<ArrayList<String>>> decks = new ArrayList<>();
        for(int i = 0; i < GlobalDefs.NUMBER_OF_PLAYERS; i++){
            decks.add(Decks.generateDeck());
        }
        return decks;
    }

    /**
     * Generates the current player (set on GlobalDefs) deck divided by the total amount of pages
     * @return Return a 3D ArrayList of the current player deck divided by the total amount of pages
     */
    public static ArrayList<ArrayList<ArrayList<String>>> generateCurrentPlayerDividedDecks(){
        int gridSize = GRID_ROWS * GRID_COLS;
        ArrayList<ArrayList<String>> currentPlayerDeck = getGameDeck().get(0);
        ArrayList<ArrayList<ArrayList<String>>> allDecks = new ArrayList<>();
        int amountOfPages = generateTotalAmountOfPages();

        for(int i = 0; i < amountOfPages; i++){
            ArrayList<ArrayList<String>> currentDeck = new ArrayList<>();
            int iterationLimit;

            // This will define how many cards must be iterated
            if(amountOfPages == 1){
                iterationLimit = currentPlayerDeck.size();
            }
            else if(i != (amountOfPages - 1)){
                iterationLimit = gridSize * (i + 1);
            }
            else{
                iterationLimit = (i * gridSize) + (currentPlayerDeck.size() - (i * gridSize));
            }

            for(int j = (i * gridSize); j < iterationLimit; j++){
                currentDeck.add(currentPlayerDeck.get(j));
            }
            allDecks.add(currentDeck);
        }
        return allDecks;
    }

    /**
     * Generates the total amount of pages for the current player deck
     * @return returns an integer with the total amount of pages
     */
    public static int generateTotalAmountOfPages(){
        int gridSize = GRID_ROWS * GRID_COLS;
        int playerDeckSize = Decks.getGameDeck().get(GlobalDefs.PLAYER_ID).size();

        return (int) Math.ceil((double) playerDeckSize / gridSize);
    }

    public static void removeCard(int playerID, String cardNumber, String cardColor){
        var deck = getGameDeck();
        int cardIndex = 0;

        for(int i = 0; i < deck.get(playerID).size(); i++){
            if(deck.get(playerID).get(i).get(0).equals(cardNumber) &&
               deck.get(playerID).get(i).get(1).equals(cardColor)){
                cardIndex = Integer.parseInt(Integer.toString(i));
                break;
            }
        }

        // Removing the card
        deck.get(playerID).remove(cardIndex);

        // Setting the deck
        setGameDeck(deck);
    }

    // Getters
    /**
     * Getter for the game deck
     * @return returns the game deck
     */
    public static ArrayList<ArrayList<ArrayList<String>>> getGameDeck() {
        return gameDeck;
    }

    /**
     * Getter for the current player decks
     * @return returns the current player decks
     */
    public static ArrayList<ArrayList<ArrayList<String>>> getCurrentPlayerDecks() {
        return currentPlayerDecks;
    }

    public static void setGameDeck(ArrayList<ArrayList<ArrayList<String>>> gameDeck) {
        Decks.gameDeck = gameDeck;
    }

    public static void setCurrentPlayerDecks(ArrayList<ArrayList<ArrayList<String>>> currentPlayerDecks) {
        Decks.currentPlayerDecks = currentPlayerDecks;
    }

}
