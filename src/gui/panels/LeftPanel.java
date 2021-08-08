package gui.panels;

import tools.ResizeImage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {

    int panel_width = 50;
    int panel_height = 100;
    JFrame frame;

    public LeftPanel(JFrame frame){
        // Constructing variables
        this.frame = frame;

        // Initializing Panel
        this.setPreferredSize(new Dimension(panel_width, panel_height));
        this.setBackground(new Color(102, 153, 255));
        this.setOpaque(true);

        // Adding buttons to the panel
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/menu.png", 32, 32)));

        // Adding components to the panel
        this.add(label);

        // Adding panel to the frame
        frame.add(this, BorderLayout.WEST);

    }

}
