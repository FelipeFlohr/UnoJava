package gui.panels;

import tools.ResizeImage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftPanel extends JPanel implements ActionListener {

    int panel_width = 50;
    int panel_height = 100;
    JFrame frame;
    JButton leaderButton;

    public LeftPanel(JFrame frame){
        // Constructing variables
        this.frame = frame;

        // Initializing Panel
        this.setPreferredSize(new Dimension(panel_width, panel_height));
        this.setBackground(new Color(102, 153, 255));
        this.setOpaque(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));

        // Creating the leaderboard button
        leaderButton = new JButton();
        leaderButton.setBorder(BorderFactory.createEmptyBorder());
        leaderButton.setContentAreaFilled(false);
        leaderButton.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/trophy.png", 50, 50)));
        leaderButton.addActionListener(this);

        // Adding components to the panel
        this.add(leaderButton);

        // Adding panel to the frame
        frame.add(this, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaderButton){
            System.out.println("button pressed");
        }
    }

}
