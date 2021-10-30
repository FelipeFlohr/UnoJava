package com.felipeflohr.uno.swing.firstlayer.secondlayer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;

public class CenterLeftPanel extends JPanel {

    public CenterLeftPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        add(new JLabel("Here the table's card will be displayed"));
    }
}
