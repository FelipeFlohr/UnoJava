package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer;

import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.CenterPagePanel;
import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.SkipPagePanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * A JPanel which serves to hold other JComponents related to the Right Side
 * @author Felipe Matheus Flohr
 */
public class CenterRightPanel extends JPanel {

    public CenterRightPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        add(new CenterPagePanel(), BorderLayout.CENTER);
        add(new SkipPagePanel(), BorderLayout.SOUTH);
    }
}
