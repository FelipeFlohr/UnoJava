package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer;

import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.CenterPagePanel;
import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.SkipPagePanel;

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
