import java.util.ArrayList;

public class Decks {

    public static ArrayList<ArrayList<String>> generateDeck(){
        ArrayList<ArrayList<String>> deck = new ArrayList<ArrayList<String>>();
        for(int i = 0; i <= GlobalDefs.numberOfInitialCards; i++){
            ArrayList<String> carta = Cards.sortNormalCard(); 
            deck.add(carta);
        }
        return deck;
    }

}
