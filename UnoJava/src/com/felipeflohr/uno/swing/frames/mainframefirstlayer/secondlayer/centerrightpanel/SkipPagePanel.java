package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel;

import com.felipeflohr.uno.globaldefs.GlobalDefinitions;
import com.felipeflohr.uno.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.*;

public class SkipPagePanel extends JPanel implements ActionListener, CustomGUIUpdate {

    private final JButton prevPageBtn;
    private final JLabel currentPage;
    private final JButton nextPageBtn;

    public SkipPagePanel() {
        final int WIDTH = 0;
        final int HEIGHT = 50;

        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(new Color(0xBBBBC2));

        // Previous Page button
        prevPageBtn = new JButton();
        prevPageBtn.setName("Previous Page Button");
        prevPageBtn.setText("Previous Page");
        prevPageBtn.addActionListener(this);
        prevPageBtn.setBorder(BorderFactory.createEmptyBorder());
        prevPageBtn.setBackground(new Color(0xD4D4DA));
        prevPageBtn.setFocusable(false);
        prevPageBtn.setEnabled(isPreviousPageAllowed());

        // Current Page
        currentPage = new JLabel();
        currentPage.setName("Current Page Label");
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        currentPage.setHorizontalAlignment(SwingConstants.CENTER);

        // Next Page button
        nextPageBtn = new JButton();
        nextPageBtn.setName("Next Page Button");
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
        addUIElement((CustomGUIUpdate) this);
    }

    // Public Methods
    @Override
    public void update() {
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());
    }

    @Override
    public String getComponentName() {
        return "Skip Page Panel";
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

    public void onPreviousPage() {
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());

        GlobalDefinitions.getCenterPagePanel().redrawButtons();
        setCurrentPage(getCurrentPage() - 1);
    }

    public void onNextPage() {
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());

        GlobalDefinitions.getCenterPagePanel().redrawButtons();
        setCurrentPage(getCurrentPage() + 1);
    }

    // Private Methods
    private int getTotalAmountOfPages() {
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentLocalPlayer()).getAmountOfCards();

        return ((int) Math.ceil(amountOfCards / gridSize)) - 1;
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
