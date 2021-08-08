package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class CenterCenterLeftPanel extends JPanel {

    JPanel panelMain;

    CenterCenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));

        // Initializing Panel
        this.setBackground(Color.ORANGE);
        this.setOpaque(true);

        // Adding components to the panel

        // Adding component to main panel
        panelMain.add(this, BorderLayout.CENTER);
    }

}
