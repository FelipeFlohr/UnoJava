package gui.panels;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panels.centerpanel.CenterLeftPanel;
import gui.panels.centerpanel.CenterRightPanel;

/**
 * Center panel of the window. Mainly responsible for holding the in-game objects
 */
public class CenterPanel extends JPanel {

    JFrame frame;

    public CenterPanel(JFrame frame){
        this.frame = frame;

        // Initializing Panel
        this.setLayout(new GridLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(true);

        // Adding left and right panel
        new CenterLeftPanel(this);
        new CenterRightPanel(this);

        // Adding component to frame
        frame.add(this);
    }

}
