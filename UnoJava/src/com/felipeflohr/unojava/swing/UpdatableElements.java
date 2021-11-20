package com.felipeflohr.unojava.swing;

import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel.CustomCardGUI;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;

/**
 * Class responsible for updating the GUI elements
 * @author Felipe Matheus Flohr
 */
public class UpdatableElements {

    private static final List<JComponent> uiElements = new ArrayList<>();
    private static final List<CustomGUIUpdate> customUiElements = new ArrayList<>();
    private static final List<CustomCardGUI> cardsElements = new ArrayList<>();

    /**
     * Will update the GUI elements.
     */
    public static void updateUIElements() {
        customUiElements.forEach(e -> {
            e.update();
            if (isPrintUpdateMessages()) System.out.println("Custom updatable element updated: " + e.getComponentName());
        });

        try {
            uiElements.forEach(element -> {
                element.repaint();
                element.validate();
                if (isPrintUpdateMessages()) {
                    if (element.getName() != null) {
                        System.out.println("Updatable element updated: " + element.getName());
                    } else {
                        System.out.println("Updatable element updated: " + element.getUIClassID());
                    }
                }
                getTable().checkPlayersAmountOfCards();
            });
        } catch (ConcurrentModificationException ignored) {

        }

        cardsElements.forEach(element -> {
            element.onCardClick();
            if (isPrintUpdateMessages()) System.out.println("Card status updated: " + element.getCardName());
        });

        getTable().checkPlayersAmountOfCards();
    }

    /**
     * Adds a UI element to be updated
     * @param element a JComponent element to be added
     */
    public static void addUIElement(JComponent element) {
        uiElements.add(element);
        if (isPrintAddedElementMessages()) System.out.println("Element added to Updatable Elements: " + element.getUIClassID());
    }

    /**
     * Adds a UI element to be updated
     * @param element a CustomGUIUpdate element to be added
     */
    public static void addUIElement(CustomGUIUpdate element) {
        customUiElements.add(element);
        if (isPrintAddedElementMessages()) System.out.println("Element added to Custom Updatable Elements: " + element.getComponentName());
    }

    /**
     * Adds a card buttons element to be updated
     * @param cardButton a Card button element to be added
     */
    public static void addCardElement(CustomCardGUI cardButton) {
        cardsElements.add(cardButton);
    }
}
