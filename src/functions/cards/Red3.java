package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Red3 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Red3(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.RED_3);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Red 3 card");
    }

}
