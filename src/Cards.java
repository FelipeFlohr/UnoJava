import java.util.ArrayList;
import java.util.Random;

public class Cards {

	public static ArrayList<String> generateNormalCard(){
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

	public static ArrayList<String> generateSpecialCard(){
		Random random = new Random();
		ArrayList<String> card = new ArrayList<>();
		final String[] COLORS = {"blue", "yellow", "red", "green"};
		final String[] SPECIAL_NUMBERS = {"+4", "+2", "skip", "reverse", "wild"};

		int randomCardIndex = random.nextInt(SPECIAL_NUMBERS.length);
		int randomColorIndex = random.nextInt(COLORS.length);

		String cardNum = SPECIAL_NUMBERS[randomCardIndex];
		String cardColor;

		if(cardNum.equals("+4") || cardNum.equals("wild")){
			cardColor = "black";
		}
		else{
			cardColor = COLORS[randomColorIndex];
		}
		card.add(cardNum);
		card.add(cardColor);

		return card;
	}

}
