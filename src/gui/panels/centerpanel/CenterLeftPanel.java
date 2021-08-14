package gui.panels.centerpanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import gui.panels.centerpanel.left.BottomCenterLeftPanel;
import gui.panels.centerpanel.left.CenterCenterLeftPanel;
import gui.panels.centerpanel.left.TopCenterLeftPanel;

/**
 * Center left panel.
 * Panel responsible for holding the cards' panel and information label
 * This panel is added to the Center Panel
 */
public class CenterLeftPanel extends JPanel {

    JPanel panelMain;
    public static CenterCenterLeftPanel centerLeftPanel;

    public CenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setLayout(new BorderLayout());

        // Initializing Panel
        this.setBackground(Color.RED);
        this.setOpaque(true);

        // Adding components to the panel
        new TopCenterLeftPanel(this);
        centerLeftPanel = new CenterCenterLeftPanel(this);
        new BottomCenterLeftPanel(this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.WEST);
    }

}
