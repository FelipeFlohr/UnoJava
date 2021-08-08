package gui.panels;

import gui.labels.TopCenterLeftLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TopCenterLeftPanel extends JPanel {

    JPanel panelMain;

    TopCenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));

        // Initializing Panel
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);

        // Adding components to the panel
        new TopCenterLeftLabel(this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.NORTH);
    }

}
