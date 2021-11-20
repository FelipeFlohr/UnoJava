package com.felipeflohr.unojava.swing.frames.mainframefirstlayer;

import com.felipeflohr.unojava.swing.frames.leftmenuframes.RestartGameDialog;
import com.felipeflohr.unojava.swing.frames.leftmenuframes.SettingsFrame;
import com.felipeflohr.unojava.swing.frames.leftmenuframes.StatusFrame;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.unojava.tools.ResizeImage.resizeImage;

/**
 * A JPanel that represents the Left Menu where the restart, info and setting buttons are located.
 * @author Felipe Matheus Flohr
 */
public class LeftMenuPanel extends JPanel implements ActionListener {

    private final JButton restartButton;
    private final JButton statusButton;
    private final JButton settingsButton;

    public LeftMenuPanel() {
        final int PANEL_WIDTH = 50;
        final int PANEL_HEIGHT = 100;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(new Color(176, 193, 255));
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));

        // Restart Button
        restartButton = new JButton();
        restartButton.setBorder(BorderFactory.createEmptyBorder());
        restartButton.setContentAreaFilled(false);
        restartButton.setIcon(new ImageIcon(resizeImage(getClass().getResource("/leftmenu/restart.png"), 32, 32)));
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);

        // Status Button
        statusButton = new JButton();
        statusButton.setBorder(BorderFactory.createEmptyBorder());
        statusButton.setContentAreaFilled(false);
        statusButton.setIcon(new ImageIcon(resizeImage(getClass().getResource("/leftmenu/status.png"), 30, 40)));
        statusButton.setFocusable(false);
        statusButton.addActionListener(this);

        // Settings Button
        settingsButton = new JButton();
        settingsButton.setBorder(BorderFactory.createEmptyBorder());
        settingsButton.setContentAreaFilled(false);
        settingsButton.setIcon(new ImageIcon(resizeImage(getClass().getResource("/leftmenu/settings.png"), 32, 32)));
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);

        add(restartButton);
        add(statusButton);
        add(settingsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            new RestartGameDialog();
        }

        if (e.getSource() == statusButton) {
            new StatusFrame();
        }

        if (e.getSource() == settingsButton) {
            new SettingsFrame();
        }
    }
}
