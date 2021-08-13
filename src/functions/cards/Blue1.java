package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blue1 extends Button implements ActionListener {

    JPanel mainPanel;

    public Blue1(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setIcon(CardsMethods.BLUE_1);
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Blue 1 card");
    }

}