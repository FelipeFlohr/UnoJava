package com.felipeflohr.unojava.swing.frames.mainframefirstlayer;

import com.felipeflohr.unojava.tools.ResizeImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftMenuPanel extends JPanel implements ActionListener {

    private final JButton leaderButton;
    private final JButton startButton;
    private final JButton settingsButton;
    private final JButton restartButton;

    public LeftMenuPanel() {
        final int PANEL_WIDTH = 50;
        final int PANEL_HEIGHT = 100;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(new Color(176, 193, 255));
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));

        startButton = new JButton();
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setContentAreaFilled(false);
        startButton.setIcon(new ImageIcon(ResizeImage.resizeImage("res/plus.png", 32, 32)));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        restartButton = new JButton();
        restartButton.setBorder(BorderFactory.createEmptyBorder());
        restartButton.setContentAreaFilled(false);
        restartButton.setIcon(new ImageIcon(ResizeImage.resizeImage("res/restart.png", 32, 32)));
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);

        leaderButton = new JButton();
        leaderButton.setBorder(BorderFactory.createEmptyBorder());
        leaderButton.setContentAreaFilled(false);
        leaderButton.setIcon(new ImageIcon(ResizeImage.resizeImage("res/trophy.png", 50, 50)));
        leaderButton.setFocusable(false);
        leaderButton.addActionListener(this);

        settingsButton = new JButton();
        settingsButton.setBorder(BorderFactory.createEmptyBorder());
        settingsButton.setContentAreaFilled(false);
        settingsButton.setIcon(new ImageIcon(ResizeImage.resizeImage("res/settings.png", 32, 32)));
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);

        add(startButton);
        add(restartButton);
        add(leaderButton);
        add(settingsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Button actions
    }
}
