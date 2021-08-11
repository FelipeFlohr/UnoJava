package functions.cards;

import functions.CardsMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blue4 extends JButton implements ActionListener {

    JPanel mainPanel;

    public Blue4(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setContentAreaFilled(false);
        this.setIcon(CardsMethods.BLUE_4);
        this.addActionListener(this);

        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You pressed a Blue 4 card");
    }

}
