package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getCurrentPlayer;
import static com.felipeflohr.uno.swing.UpdatableElements.*;

public class SkipPagePanel extends JPanel implements ActionListener, SkipPageListener {

    private JButton prevPageBtn;
    private JLabel currentPage;
    private JButton nextPageBtn;
    private final int WIDTH = 100; // Can be any number
    private final int HEIGHT = 50;

    public SkipPagePanel() {
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(new Color(0xBBBBC2));

        // Previous Page button
        prevPageBtn = new JButton();
        prevPageBtn.setText("Previous Page");
        prevPageBtn.addActionListener(this);
        prevPageBtn.setBorder(BorderFactory.createEmptyBorder());
        prevPageBtn.setBackground(new Color(0xD4D4DA));
        prevPageBtn.setFocusable(false);
        prevPageBtn.setEnabled(isPreviousPageAllowed());

        // Current Page
        currentPage = new JLabel();
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        currentPage.setHorizontalAlignment(SwingConstants.CENTER);

        // Next Page button
        nextPageBtn = new JButton();
        nextPageBtn.setText("Next Page");
        nextPageBtn.addActionListener(this);
        nextPageBtn.setBorder(BorderFactory.createEmptyBorder());
        nextPageBtn.setBackground(new Color(0xD4D4DA));
        nextPageBtn.setFocusable(false);
        nextPageBtn.setEnabled(isNextPageAllowed());

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
            if (isPreviousPageAllowed()) {
                onPreviousPage();
            }
            updateUIElements();
        } else if (e.getSource() == nextPageBtn) {
            if (isNextPageAllowed()) {
                onNextPage();
            }
            updateUIElements();
        }
    }

    @Override
    public void onPreviousPage() {
        setCurrentPage(getCurrentPage() - 1);
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());
    }

    @Override
    public void onNextPage() {
        setCurrentPage(getCurrentPage() + 1);
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());
    }

    private int getTotalAmountOfPages() {
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentPlayer()).getAmountOfCards();
        int amountOfPages = (int) Math.ceil(amountOfCards / gridSize);

        return amountOfPages;
    }

    private boolean isPreviousPageAllowed() {
        int currentPage = getCurrentPage();
        return currentPage - 1 >= 0;
    }

    private boolean isNextPageAllowed() {
        int currentPage = getCurrentPage();
        return currentPage + 1 <= getTotalAmountOfPages();
    }
}
