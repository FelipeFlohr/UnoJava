package functions.cards;

import functions.CardsMethods;
import functions.Decks;
import functions.GlobalDefs;
import gui.UpdateGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wild extends Button implements ActionListener {

    JPanel mainPanel;

    public Wild(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setIcon(CardsMethods.WILD);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Decks.removeCard(0, "wild", "black");
        GlobalDefs.currentPage = 0;
        UpdateGUI.updateGUI.updateAllGUI();
        System.out.println("You pressed a Wild card");
    }
}
