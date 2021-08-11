package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YellowWild2 extends JButton implements ActionListener {

    JPanel mainPanel;

    public YellowWild2(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.YELLOW_PLUS2);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Yellow +2 card");
    }
}
