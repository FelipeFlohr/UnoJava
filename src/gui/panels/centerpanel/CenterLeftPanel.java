package gui.panels.centerpanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import gui.panels.centerpanel.left.CenterCenterLeftPanel;
import gui.panels.centerpanel.left.TopCenterLeftPanel;

public class CenterLeftPanel extends JPanel {

    JPanel panelMain;

    public CenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setLayout(new BorderLayout());

        // Initializing Panel
        this.setBackground(Color.RED);
        this.setOpaque(true);

        // Adding components to the panel
        new TopCenterLeftPanel(this);
        new CenterCenterLeftPanel(this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.WEST);
    }

}
