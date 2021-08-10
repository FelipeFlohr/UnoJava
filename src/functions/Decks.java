package functions;

import java.util.ArrayList;
import java.util.Random;

public class Decks {

    public static ArrayList<ArrayList<ArrayList<String>>> getGameDeck() {
        return gameDeck;
    }

    private static ArrayList<ArrayList<ArrayList<String>>> gameDeck = generateInitialDeck();

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

    // Will create a 3D ArrayList to store all players functions
    public static ArrayList<ArrayList<ArrayList<String>>> generateInitialDeck(){
        ArrayList<ArrayList<ArrayList<String>>> decks = new ArrayList<>();
        for(int i = 0; i < GlobalDefs.NUMBER_OF_PLAYERS; i++){
            decks.add(Decks.generateDeck());
        }
        return decks;
    }

}
