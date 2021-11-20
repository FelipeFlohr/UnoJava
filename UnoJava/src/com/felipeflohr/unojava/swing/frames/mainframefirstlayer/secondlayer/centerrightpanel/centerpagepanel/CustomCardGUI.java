package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel;

/**
 * Interface for the card button
 * @author Felipe Matheus Flohr
 */
public interface CustomCardGUI {

    /**
     * Actions performed when a user clicks on the button
     */
    void onCardClick();

    /**
     * The String return of a card
     * @return the card number and color
     */
    String getCardName();
}
