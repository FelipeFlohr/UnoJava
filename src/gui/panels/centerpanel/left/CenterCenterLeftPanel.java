package gui.panels.centerpanel.left;

import functions.Decks;
import functions.GlobalDefs;
import functions.cards.*;

import java.awt.*;

import javax.swing.*;

public class CenterCenterLeftPanel extends JPanel {

    public final static int GRID_ROWS = 3;
    public final static int GRID_COLS = 3;
    JPanel panelMain;

    public CenterCenterLeftPanel(JPanel panelMain){

        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        // Initializing Panel
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);

        // Adding components to the panel
        generateCardsGUI(GlobalDefs.PLAYER_ID, this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.CENTER);
    }

    // Will create buttons for each card the player have
    private void generateCardsGUI(int playerID, JPanel mainPanel){
        for(int i = 0; i < Decks.getGameDeck().get(playerID).size(); i++){
            switch (Decks.getGameDeck().get(playerID).get(i).get(1)) {
                case "blue":
                    switch (Decks.getGameDeck().get(playerID).get(i).get(0)) {
                        case "0" -> new Blue0(mainPanel);
                        case "1" -> new Blue1(mainPanel);
                        case "2" -> new Blue2(mainPanel);
                        case "3" -> new Blue3(mainPanel);
                        case "4" -> new Blue4(mainPanel);
                        case "5" -> new Blue5(mainPanel);
                        case "6" -> new Blue6(mainPanel);
                        case "7" -> new Blue7(mainPanel);
                        case "8" -> new Blue8(mainPanel);
                        case "9" -> new Blue9(mainPanel);
                        case "+2" -> new BlueWild2(mainPanel);
                        case "reverse" -> new BlueReverse(mainPanel);
                        case "skip" -> new BlueSkip(mainPanel);
                    }
                    break;
                case "green":
                    switch (Decks.getGameDeck().get(playerID).get(i).get(0)) {
                        case "0" -> new Green0(mainPanel);
                        case "1" -> new Green1(mainPanel);
                        case "2" -> new Green2(mainPanel);
                        case "3" -> new Green3(mainPanel);
                        case "4" -> new Green4(mainPanel);
                        case "5" -> new Green5(mainPanel);
                        case "6" -> new Green6(mainPanel);
                        case "7" -> new Green7(mainPanel);
                        case "8" -> new Green8(mainPanel);
                        case "9" -> new Green9(mainPanel);
                        case "+2" -> new GreenWild2(mainPanel);
                        case "reverse" -> new GreenReverse(mainPanel);
                        case "skip" -> new GreenSkip(mainPanel);
                    }
                    break;
                case "red":
                    switch (Decks.getGameDeck().get(playerID).get(i).get(0)) {
                        case "0" -> new Red0(mainPanel);
                        case "1" -> new Red1(mainPanel);
                        case "2" -> new Red2(mainPanel);
                        case "3" -> new Red3(mainPanel);
                        case "4" -> new Red4(mainPanel);
                        case "5" -> new Red5(mainPanel);
                        case "6" -> new Red6(mainPanel);
                        case "7" -> new Red7(mainPanel);
                        case "8" -> new Red8(mainPanel);
                        case "9" -> new Red9(mainPanel);
                        case "+2" -> new RedWild2(mainPanel);
                        case "reverse" -> new RedReverse(mainPanel);
                        case "skip" -> new RedSkip(mainPanel);
                    }
                    break;
                case "yellow":
                    switch (Decks.getGameDeck().get(playerID).get(i).get(0)) {
                        case "0" -> new Yellow0(mainPanel);
                        case "1" -> new Yellow1(mainPanel);
                        case "2" -> new Yellow2(mainPanel);
                        case "3" -> new Yellow3(mainPanel);
                        case "4" -> new Yellow4(mainPanel);
                        case "5" -> new Yellow5(mainPanel);
                        case "6" -> new Yellow6(mainPanel);
                        case "7" -> new Yellow7(mainPanel);
                        case "8" -> new Yellow8(mainPanel);
                        case "9" -> new Yellow9(mainPanel);
                        case "+2" -> new YellowWild2(mainPanel);
                        case "reverse" -> new YellowReverse(mainPanel);
                        case "skip" -> new YellowSkip(mainPanel);
                    }
                    break;
                default:
                    switch (Decks.getGameDeck().get(playerID).get(i).get(0)) {
                        case "+4" -> new Wild4(mainPanel);
                        case "wild" -> new Wild(mainPanel);
                    }
                    break;
            }
        }
    }

}