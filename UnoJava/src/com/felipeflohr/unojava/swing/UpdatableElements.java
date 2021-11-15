package com.felipeflohr.unojava.swing;

import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel.CustomCardGUI;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;

public class UpdatableElements {

    private static final List<JComponent> uiElements = new ArrayList<>();
    private static final List<CustomGUIUpdate> customUiElements = new ArrayList<>();
    private static final List<CustomCardGUI> cardsElements = new ArrayList<>();

    public static void updateUIElements() {
        customUiElements.forEach(e -> {
            e.update();
            if (isPrintUpdateMessages()) System.out.println("Custom updatable element updated: " + e.getComponentName());
        });

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

        cardsElements.forEach(element -> {
            element.onCardClick();
            if (isPrintUpdateMessages()) System.out.println("Card status updated: " + element.getCardName());
        });

        getTable().checkPlayersAmountOfCards();
    }

    public static void addUIElement(JComponent element) {
        uiElements.add(element);
        if (isPrintAddedElementMessages()) System.out.println("Element added to Updatable Elements: " + element.getUIClassID());
    }

    public static void addUIElement(CustomGUIUpdate element) {
        customUiElements.add(element);
        if (isPrintAddedElementMessages()) System.out.println("Element added to Custom Updatable Elements: " + element.getComponentName());
    }

    public static void addCardElement(CustomCardGUI cardButton) {
        cardsElements.add(cardButton);
    }
}
