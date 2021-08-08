import java.util.ArrayList;

public class Decks {

    public static ArrayList<ArrayList<ArrayList<String>>> gameDeck = generateInitialDeck();

    // Will create a 2D ArrayList to store a player deck
    public static ArrayList<ArrayList<String>> generateDeck(){
        ArrayList<ArrayList<String>> deck = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < GlobalDefs.NUMBER_OF_INITIAL_CARDS; i++){
            ArrayList<String> carta = Cards.sortNormalCard(); 
            deck.add(carta);
        }
        return deck;
    }

    // Will create a 3D ArrayList to store all players cards
    public static ArrayList<ArrayList<ArrayList<String>>> generateInitialDeck(){
        ArrayList<ArrayList<ArrayList<String>>> decks = new ArrayList<ArrayList<ArrayList<String>>>();
        for(int i = 0; i < GlobalDefs.NUMBER_OF_PLAYERS; i++){
            decks.add(Decks.generateDeck());
        }
        return decks;
    }

}
