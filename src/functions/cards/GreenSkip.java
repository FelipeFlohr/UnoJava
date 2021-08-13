package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreenSkip extends Button implements ActionListener {

    JPanel mainPanel;

    public GreenSkip(JPanel mainPanel){
        super(mainPanel);
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setIcon(CardsMethods.GREEN_SKIP);
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Skip Green card");
    }

}