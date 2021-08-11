package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Green4 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Green4(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.GREEN_4);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Green 4 card");
    }

}
