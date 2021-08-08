package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

    JFrame frame;

    public BottomPanel(JFrame frame){
        this.frame = frame;

        int panel_width = 5;
        int panel_height = 150;

        // Initializing Panel
        this.setPreferredSize(new Dimension(panel_width, panel_height));
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);

        // Placeholder
        JLabel label = new JLabel();
        label.setText("Placeholder. The cards will be here");
        label.setFont(new Font("Arial", Font.PLAIN, 30));

        // Adding components to panel
        this.add(label);

        // Adding panel to the frame
        frame.add(this, BorderLayout.SOUTH);
    }

}
