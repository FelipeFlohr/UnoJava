package com.felipeflohr.uno.swing.firstlayer;

import com.felipeflohr.uno.swing.firstlayer.secondlayer.CenterLeftPanel;
import com.felipeflohr.uno.swing.firstlayer.secondlayer.CenterRightPanel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class CenterPanel extends JPanel {

    public CenterPanel() {
        setLayout(new GridLayout());
        setBackground(Color.BLACK);
        setOpaque(true);

        add(new CenterLeftPanel());
        add(new CenterRightPanel());
    }

}
