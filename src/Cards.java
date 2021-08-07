import java.util.ArrayList;
import java.util.Random;

public class Cards {
	
	public ArrayList<String> sortNormalCard(){
		Random random = new Random();
		ArrayList<String> card = new ArrayList<>();
		final String[] COLORS = {"blue", "yellow", "red", "green"};

		String cardNum = String.valueOf(random.nextInt(9)); 
		int sortColorIndex = random.nextInt(COLORS.length);
		String sortColor = COLORS[sortColorIndex];
		card.add(cardNum);
		card.add(sortColor);

		return card;
	}

}
