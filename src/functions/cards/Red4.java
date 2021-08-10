package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Red4 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Red4(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.RED_4);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Red 4 card");
    }

}
