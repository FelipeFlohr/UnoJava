package gui.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopCenterLeftLabel extends JLabel {

    JPanel panelMain;

    public TopCenterLeftLabel(JPanel panelMain){
        this.setText("Placeholder");
        this.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.setForeground(new Color(0, 0, 0));

        // Adding label to the panel
        panelMain.add(this);
    }

}
