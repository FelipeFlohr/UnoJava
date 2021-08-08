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
    JButton startButton;
    JButton settingsButton;
    JButton restartButton;

    public LeftPanel(JFrame frame){
        // Constructing variables
        this.frame = frame;

        // Initializing Panel
        this.setPreferredSize(new Dimension(panel_width, panel_height));
        this.setBackground(new Color(102, 153, 255));
        this.setOpaque(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));

        // Creating the start game button
        startButton = new JButton();
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setContentAreaFilled(false);
        startButton.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/plus.png", 32, 32))); // Placeholder
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        // Creating the restart button
        restartButton = new JButton();
        restartButton.setBorder(BorderFactory.createEmptyBorder());
        restartButton.setContentAreaFilled(false);
        restartButton.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/restart.png", 32, 32))); // Placeholder
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);

        // Creating the leaderboard button
        leaderButton = new JButton();
        leaderButton.setBorder(BorderFactory.createEmptyBorder());
        leaderButton.setContentAreaFilled(false);
        leaderButton.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/trophy.png", 50, 50))); // Placeholder
        leaderButton.setFocusable(false);
        leaderButton.addActionListener(this);

        // Creating the settings button
        settingsButton = new JButton();
        settingsButton.setBorder(BorderFactory.createEmptyBorder());
        settingsButton.setContentAreaFilled(false);
        settingsButton.setIcon(new ImageIcon(ResizeImage.resizeImage("src/gui/images/settings.png", 32, 32))); // Placeholder
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);

        // Adding components to the panel
        this.add(startButton);
        this.add(restartButton);
        this.add(leaderButton);
        this.add(settingsButton);

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
