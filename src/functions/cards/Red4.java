package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Red4 extends Button implements ActionListener {

    JPanel mainPanel;

    public Red4(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.setIcon(CardsMethods.RED_4);
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Red 4 card");
    }

}