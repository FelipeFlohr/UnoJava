package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer;

import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerleftpanel.BottomPagePanel;
import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerleftpanel.CenterPagePanel;
import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerleftpanel.TopPagePanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CenterLeftPanel extends JPanel {

    public CenterLeftPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);

        add(new CenterPagePanel(), BorderLayout.CENTER);
        add(new TopPagePanel(), BorderLayout.NORTH);
        add(new BottomPagePanel(), BorderLayout.SOUTH);
    }
}