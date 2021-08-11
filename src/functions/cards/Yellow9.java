package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yellow9 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Yellow9(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.YELLOW_9);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Yellow 9 card");
    }

}
