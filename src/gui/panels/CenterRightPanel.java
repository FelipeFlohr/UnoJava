package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CenterRightPanel extends JPanel {

    JPanel panelMain;

    CenterRightPanel(JPanel panelMain){
        this.panelMain = panelMain;

        // Initializing Panel
        this.setBackground(Color.BLUE);
        this.setOpaque(true);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.EAST);
    }

}
