package gui.panels.centerpanel.left;

import cards.Decks;
import cards.GlobalDefs;

import java.awt.*;

import javax.swing.*;

public class CenterCenterLeftPanel extends JPanel {

    JPanel panelMain;

    public CenterCenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));
        this.setLayout(new GridLayout(3, 3));

        // Initializing Panel
        this.setBackground(Color.ORANGE);
        this.setOpaque(true);

        // Adding components to the panel
        for(int i = 0; i <= Decks.gameDeck.get(GlobalDefs.PLAYER_ID).size(); i++){
            JButton button = new JButton(String.valueOf(i));
            this.add(button);
        }

        // Adding component to main panel
        panelMain.add(this, BorderLayout.CENTER);
    }

}
