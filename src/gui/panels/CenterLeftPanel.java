package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CenterLeftPanel extends JPanel {

    JPanel panelMain;

    CenterLeftPanel(JPanel panelMain){
        this.panelMain = panelMain;
        this.setLayout(new BorderLayout());

        // Initializing Panel
        this.setBackground(Color.RED);
        this.setOpaque(true);

        // Adding components to the panel
        new TopCenterLeftPanel(this);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.WEST);
    }

}
