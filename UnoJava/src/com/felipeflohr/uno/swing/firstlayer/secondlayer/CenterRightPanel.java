package com.felipeflohr.uno.swing.firstlayer.secondlayer;

import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel.CenterPagePanel;
import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel.SkipPagePanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CenterRightPanel extends JPanel {

    public CenterRightPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        add(new CenterPagePanel(), BorderLayout.CENTER);
        add(new SkipPagePanel(), BorderLayout.SOUTH);
    }
}
