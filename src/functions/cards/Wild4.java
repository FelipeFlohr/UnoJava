package functions.cards;

import functions.CardsMethods;
import functions.Decks;
import functions.GlobalDefs;
import gui.UpdateGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static functions.Decks.getGameDeck;

public class Wild4 extends Button implements ActionListener {

    JPanel mainPanel;

    public Wild4(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setIcon(CardsMethods.WILD_4);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Decks.removeCard(0, "+4", "black");
        GlobalDefs.currentPage = 0;
        UpdateGUI.updateGUI.updateAllGUI();
        System.out.println("You pressed a +4 card");
    }
}
