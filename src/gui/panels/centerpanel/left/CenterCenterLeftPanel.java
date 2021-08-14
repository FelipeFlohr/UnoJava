package gui.panels.centerpanel.left;

import functions.Decks;
import functions.GlobalDefs;
import functions.cards.*;
import functions.cards.Button;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Panel responsible for holding the cards buttons. There's 9 buttons in total, because of the 3x3 card's grid
 */
public class CenterCenterLeftPanel extends JPanel {

    public final static int GRID_ROWS = 3;
    public final static int GRID_COLS = 3;
    JPanel panelMain;
    public static Button button1;
    public static Button button2;
    public static Button button3;
    public static Button button4;
    public static Button button5;
    public static Button button6;
    public static Button button7;
    public static Button button8;
    public static Button button9;

    /**
     * Constructor of the class. Renders the 9 buttons
     * @param panelMain The panel where this panel is going to be added (Center Left Panel)
     */
    public CenterCenterLeftPanel(JPanel panelMain){

        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        // Initializing Panel
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);

        // Adding components to the panel
        button1 = renderCard(this,0);
        button2 = renderCard(this,1);
        button3 = renderCard(this,2);
        button4 = renderCard(this,3);
        button5 = renderCard(this,4);
        button6 = renderCard(this,5);
        button7 = renderCard(this,6);
        button8 = renderCard(this,7);
        button9 = renderCard(this,8);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.CENTER);
    }

    /**
     * Renders a card based on the buttonID and the current page
     * @param mainPanel The panel where the button is going to be added (Center-Center Left Panel)
     * @param buttonID The ID of the button. Represents the index value on the current page's player deck
     * @return Returns a new class based on the card on the deck
     */
    public static Button renderCard(JPanel mainPanel, int buttonID){
        try{
            ArrayList<String> card = Decks.getCurrentPlayerDecks().get(GlobalDefs.currentPage).get(buttonID);
            switch (card.get(1)) {
                case "blue":
                    switch (card.get(0)) {
                        case "0":
                            return new Blue0(mainPanel);
                        case "1":
                            return new Blue1(mainPanel);
                        case "2":
                            return new Blue2(mainPanel);
                        case "3":
                            return new Blue3(mainPanel);
                        case "4":
                            return new Blue4(mainPanel);
                        case "5":
                            return new Blue5(mainPanel);
                        case "6":
                            return new Blue6(mainPanel);
                        case "7":
                            return new Blue7(mainPanel);
                        case "8":
                            return new Blue8(mainPanel);
                        case "9":
                            return new Blue9(mainPanel);
                        case "+2":
                            return new BlueWild2(mainPanel);
                        case "skip":
                            return new BlueSkip(mainPanel);
                        case "reverse":
                            return new BlueReverse(mainPanel);
                    }
                    break;
                case "green":
                    switch (card.get(0)) {
                        case "0":
                            return new Green0(mainPanel);
                        case "1":
                            return new Green1(mainPanel);
                        case "2":
                            return new Green2(mainPanel);
                        case "3":
                            return new Green3(mainPanel);
                        case "4":
                            return new Green4(mainPanel);
                        case "5":
                            return new Green5(mainPanel);
                        case "6":
                            return new Green6(mainPanel);
                        case "7":
                            return new Green7(mainPanel);
                        case "8":
                            return new Green8(mainPanel);
                        case "9":
                            return new Green9(mainPanel);
                        case "+2":
                            return new GreenWild2(mainPanel);
                        case "skip":
                            return new GreenSkip(mainPanel);
                        case "reverse":
                            return new GreenReverse(mainPanel);
                    }
                    break;
                case "red":
                    switch (card.get(0)) {
                        case "0":
                            return new Red0(mainPanel);
                        case "1":
                            return new Red1(mainPanel);
                        case "2":
                            return new Red2(mainPanel);
                        case "3":
                            return new Red3(mainPanel);
                        case "4":
                            return new Red4(mainPanel);
                        case "5":
                            return new Red5(mainPanel);
                        case "6":
                            return new Red6(mainPanel);
                        case "7":
                            return new Red7(mainPanel);
                        case "8":
                            return new Red8(mainPanel);
                        case "9":
                            return new Red9(mainPanel);
                        case "+2":
                            return new RedWild2(mainPanel);
                        case "skip":
                            return new RedSkip(mainPanel);
                        case "reverse":
                            return new RedReverse(mainPanel);
                    }
                    break;
                case "yellow":
                    switch (card.get(0)) {
                        case "0":
                            return new Yellow0(mainPanel);
                        case "1":
                            return new Yellow1(mainPanel);
                        case "2":
                            return new Yellow2(mainPanel);
                        case "3":
                            return new Yellow3(mainPanel);
                        case "4":
                            return new Yellow4(mainPanel);
                        case "5":
                            return new Yellow5(mainPanel);
                        case "6":
                            return new Yellow6(mainPanel);
                        case "7":
                            return new Yellow7(mainPanel);
                        case "8":
                            return new Yellow8(mainPanel);
                        case "9":
                            return new Yellow9(mainPanel);
                        case "+2":
                            return new YellowWild2(mainPanel);
                        case "skip":
                            return new YellowSkip(mainPanel);
                        case "reverse":
                            return new YellowReverse(mainPanel);
                    }
                    break;
                default:
                    if (card.get(0).equals("wild4")) {
                        return new Wild4(mainPanel);
                    } else {
                        return new Wild(mainPanel);
                    }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
        return null;
    }

}