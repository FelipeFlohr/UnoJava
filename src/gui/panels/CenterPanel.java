package gui.panels;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
