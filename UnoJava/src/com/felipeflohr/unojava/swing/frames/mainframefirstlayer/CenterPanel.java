package com.felipeflohr.unojava.swing.frames.mainframefirstlayer;

import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.CenterLeftPanel;
import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.CenterRightPanel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * A JPanel that serves to hold the main game panels
 */
public class CenterPanel extends JPanel {

    public CenterPanel() {
        setLayout(new GridLayout());
        setBackground(Color.BLACK);
        setOpaque(true);

        add(new CenterLeftPanel());
        add(new CenterRightPanel());
    }

}
