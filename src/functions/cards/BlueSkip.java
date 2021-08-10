package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlueSkip extends JButton implements ActionListener {

    JPanel mainPanel;

    public BlueSkip(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.BLUE_SKIP);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Skip Blue card");
    }

}
