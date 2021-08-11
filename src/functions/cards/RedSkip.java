package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedSkip extends JButton implements ActionListener {

    JPanel mainPanel;

    public RedSkip(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.RED_SKIP);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Skip Red card");
    }

}
