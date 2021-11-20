package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel;

import com.felipeflohr.unojava.globaldefs.GlobalDefinitions;
import com.felipeflohr.unojava.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.*;

/**
 * The Skip page JPanel. Holds the buttons for skipping or moving back the page.
 * @author Felipe Matheus Flohr
 */
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

    /**
     * Will apply the effects when the user clicks to move to the previous page
     */
    public void onPreviousPage() {
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());

        GlobalDefinitions.getCenterPagePanel().redrawButtons();
        setCurrentPage(getCurrentPage() - 1);
    }

    /**
     * Will apply the effects when the user clicks to move to the next page
     */
    public void onNextPage() {
        currentPage.setText("Current Page: " + getCurrentPage() + "/" + getTotalAmountOfPages());
        prevPageBtn.setEnabled(isPreviousPageAllowed());
        nextPageBtn.setEnabled(isNextPageAllowed());

        GlobalDefinitions.getCenterPagePanel().redrawButtons();
        setCurrentPage(getCurrentPage() + 1);
    }

    // Private Methods
    /**
     * Gets the total amount of pages
     * @return the total amount of pages
     */
    private int getTotalAmountOfPages() {
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentLocalPlayer()).getAmountOfCards();

        return ((int) Math.ceil(amountOfCards / gridSize)) - 1;
    }

    /**
     * Checks if it is possible to move to the previous page
     * @return true if it is possible to move back to the previous page
     */
    private boolean isPreviousPageAllowed() {
        int currentPage = getCurrentPage();
        return currentPage - 1 >= 0;
    }

    /**
     * Checks if it is possible to move to the next page
     * @return true if it is possible to move to the next page
     */
    private boolean isNextPageAllowed() {
        int currentPage = getCurrentPage();
        return currentPage + 1 <= getTotalAmountOfPages();
    }
}
