package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blue0 extends Button implements ActionListener{

    JPanel mainPanel;

    public Blue0(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setIcon(CardsMethods.BLUE_0);
        this.addActionListener(this);

        mainPanel.add(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Blue 0 card");
    }
}
