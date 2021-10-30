package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.uno.swing.UpdatableElements.updateUIElements;

public class SkipPagePanel extends JPanel implements ActionListener {

    private JButton prevPageBtn;
    private JButton nextPageBtn;
    private final int WIDTH = 100; // Can be any number
    private final int HEIGHT = 50;

    public SkipPagePanel() {
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(new Color(0xBBBBC2));

        // Previous Page button
        prevPageBtn = new JButton();
        prevPageBtn.setText("Previous Page: ");
        prevPageBtn.addActionListener(this);
        prevPageBtn.setBorder(BorderFactory.createEmptyBorder());
        prevPageBtn.setBackground(new Color(0xD4D4DA));
        prevPageBtn.setFocusable(false);

        // Current Page
        JLabel currentPage = new JLabel();
        currentPage.setText("Current Page: ");
        currentPage.setHorizontalAlignment(SwingConstants.CENTER);

        // Next Page button
        nextPageBtn = new JButton();
        nextPageBtn.setText("Next Page: ");
        nextPageBtn.addActionListener(this);
        nextPageBtn.setBorder(BorderFactory.createEmptyBorder());
        nextPageBtn.setBackground(new Color(0xD4D4DA));
        nextPageBtn.setFocusable(false);

        add(prevPageBtn);
        add(currentPage);
        add(nextPageBtn);

        addUIElement(prevPageBtn);
        addUIElement(currentPage);
        addUIElement(nextPageBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevPageBtn) {
            // TODO Previous page button
            updateUIElements();
        } else if (e.getSource() == nextPageBtn) {
            // TODO Next page button
            updateUIElements();
        }
    }
}
