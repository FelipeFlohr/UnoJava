package functions;

import gui.panels.centerpanel.left.CenterCenterLeftPanel;

import java.util.ArrayList;
import java.util.Random;

import static gui.panels.centerpanel.left.CenterCenterLeftPanel.GRID_COLS;
import static gui.panels.centerpanel.left.CenterCenterLeftPanel.GRID_ROWS;

public class Decks {

    private static ArrayList<ArrayList<ArrayList<String>>> gameDeck = generateInitialDeck();
    private static ArrayList<ArrayList<ArrayList<String>>> currentPlayerDecks = generateCurrentPlayerDividedDecks();

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

    // Will create a 3D ArrayList to store all players deck
    public static ArrayList<ArrayList<ArrayList<String>>> generateInitialDeck(){
        ArrayList<ArrayList<ArrayList<String>>> decks = new ArrayList<>();
        for(int i = 0; i < GlobalDefs.NUMBER_OF_PLAYERS; i++){
            decks.add(Decks.generateDeck());
        }
        return decks;
    }

    public static ArrayList<ArrayList<ArrayList<String>>> generateCurrentPlayerDividedDecks(){
        int gridSize = GRID_ROWS * GRID_COLS;
        ArrayList<ArrayList<String>> currentPlayerDeck = getGameDeck().get(0);
        ArrayList<ArrayList<ArrayList<String>>> allDecks = new ArrayList<>();
        int amountOfPages = GlobalDefs.totalAmountOfPages;

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

            System.out.println("Iteration: "+i+" | Starting from: "+(i * gridSize)+" | Until: "+iterationLimit);

            for(int j = (i * gridSize); j < iterationLimit; j++){
                currentDeck.add(currentPlayerDeck.get(j));
            }
            System.out.println(currentDeck);
            allDecks.add(currentDeck);
        }

        return allDecks;
    }

    public static int generateTotalAmountOfPages(){
        return (int) Math.ceil((double) Decks.getGameDeck().get(GlobalDefs.PLAYER_ID).size() / (double) (CenterCenterLeftPanel.GRID_ROWS * CenterCenterLeftPanel.GRID_COLS));
    }

    public static ArrayList<ArrayList<ArrayList<String>>> getGameDeck() {
        return gameDeck;
    }

    public static ArrayList<ArrayList<ArrayList<String>>> getCurrentPlayerDecks() {
        return currentPlayerDecks;
    }

}
