package com.felipeflohr.uno.swing.firstlayer.secondlayer;

import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerleftpanel.BottomPagePanel;
import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerleftpanel.TopPagePanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CenterLeftPanel extends JPanel {

    public CenterLeftPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);

        add(new JLabel("Here the table's card will be displayed"), BorderLayout.CENTER);
        add(new TopPagePanel(), BorderLayout.NORTH);
        add(new BottomPagePanel(), BorderLayout.SOUTH);
    }
}
