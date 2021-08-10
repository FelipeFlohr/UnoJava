package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yellow0 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Yellow0(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.YELLOW_0);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Yellow 0 card");
    }

}
