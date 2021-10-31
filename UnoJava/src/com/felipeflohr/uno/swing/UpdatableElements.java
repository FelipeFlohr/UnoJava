package com.felipeflohr.uno.swing;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getTable;

public class UpdatableElements {

    private static final List<JComponent> uiElements = new ArrayList<>();

    public static void updateUIElements() {
        uiElements.parallelStream().forEach(element -> {
            element.repaint();
            element.validate();
            System.out.println("Updatable element updated: " + element.getUIClassID());
            getTable().checkPlayersAmountOfCards();
        });
    }

    public static void addUIElement(JComponent element) {
        uiElements.add(element);
        System.out.println("Element added to Updatable Elements: " + element.getUIClassID());
    }
}
