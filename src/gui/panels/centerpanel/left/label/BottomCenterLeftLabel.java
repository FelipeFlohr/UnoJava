package gui.panels.centerpanel.left.label;

import functions.GlobalDefs;

import javax.swing.*;
import java.awt.*;

/**
 * The bottom center left label is responsible for displaying the current page the user is in.
 */
public class BottomCenterLeftLabel extends JLabel {

    JPanel panelMain;

    /**
     * Constructor of the class. Sets the values for the label
     * @param panelMain The main panel where this label is going to be added (Bottom Center Left Panel)
     */
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
