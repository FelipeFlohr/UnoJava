package gui.panels.centerpanel.left.label;

import functions.GlobalDefs;

import javax.swing.*;
import java.awt.*;

public class BottomCenterLeftLabel extends JLabel {

    JPanel panelMain;

    public BottomCenterLeftLabel(JPanel panelMain){

        this.setText("Current page: "+(GlobalDefs.currentPage+1));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        this.setForeground(new Color(0, 0, 0));

        // Adding label to the panel
        panelMain.add(this);
    }

}
