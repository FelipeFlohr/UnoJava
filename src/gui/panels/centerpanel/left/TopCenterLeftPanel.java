package gui.panels.centerpanel.left;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import gui.panels.centerpanel.left.label.TopCenterLeftLabel;

public class TopCenterLeftPanel extends JPanel {

    JPanel panelMain;

    public TopCenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));

        // Initializing Panel
        this.setBackground(Color.WHITE);
        this.setOpaque(true);

        // Adding components to the panel
        new TopCenterLeftLabel(this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.NORTH);
    }

}
