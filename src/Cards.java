import tools.ResizeImage;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Cards {

	// Variables for each card
	private static final int CARD_IMAGE_WIDTH = 128;
	private static final int CARD_IMAGE_HEIGHT = 128;

	public static final ImageIcon WILD_4 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/+4.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon WILD = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/wild.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_0 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue0.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_1 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue1.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_3 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue3.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_4 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue4.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_5 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue5.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_6 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue6.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_7 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue7.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_8 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue8.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_9 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue9.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_REVERSE = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/bluereverse.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_SKIP = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blueskip.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon BLUE_PLUS2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/blue+2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_0 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green0.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_1 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green1.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_3 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green3.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_4 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green4.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_5 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green5.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_6 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green6.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_7 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green7.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_8 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green8.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_9 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green9.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_REVERSE = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/greenreverse.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_SKIP = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/greenskip.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon GREEN_PLUS2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/green+2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_0 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red0.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_1 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red1.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_3 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red3.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_4 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red4.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_5 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red5.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_6 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red6.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_7 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red7.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_8 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red8.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_9 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red9.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_REVERSE = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/redreverse.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_SKIP = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/redskip.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon RED_PLUS2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/red+2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_0 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow0.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_1 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow1.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_3 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow3.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_4 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow4.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_5 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow5.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_6 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow6.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_7 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow7.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_8 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow8.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_9 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow9.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_REVERSE = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellowreverse.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_SKIP = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellowskip.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));
	public static final ImageIcon YELLOW_PLUS2 = new ImageIcon(ResizeImage.resizeImage("src/gui/images/cards/yellow+2.PNG", CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT));

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
