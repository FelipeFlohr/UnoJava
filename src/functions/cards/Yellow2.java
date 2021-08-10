package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yellow2 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Yellow2(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.YELLOW_2);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Yellow 2 card");
    }

}
