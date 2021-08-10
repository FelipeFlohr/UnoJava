import functions.Decks;
import gui.Frame;

public class Main {

	public static void main(String[] args) {

		new Frame();

		System.out.println(Decks.getGameDeck().get(0));

	}

}
