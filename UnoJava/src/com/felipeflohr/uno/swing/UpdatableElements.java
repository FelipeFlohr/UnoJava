package com.felipeflohr.uno.swing;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getTable;

public class UpdatableElements {

    private static final List<JComponent> uiElements = new ArrayList<>();
    private static final List<CustomGUIUpdate> customUiElements = new ArrayList<>();

    public static void updateUIElements() {
        customUiElements.stream().forEach(e -> {
            e.update();
            System.out.println("Custom updatable element updated: " + e.getComponentName());
        });

        uiElements.stream().forEach(element -> {
            element.repaint();
            element.validate();
            if (element.getName() != null) {
                System.out.println("Updatable element updated: " + element.getName());
            } else {
                System.out.println("Updatable element updated: " + element.getUIClassID());
            }
            getTable().checkPlayersAmountOfCards();
        });
    }

    public static void addUIElement(JComponent element) {
        uiElements.add(element);
        System.out.println("Element added to Updatable Elements: " + element.getUIClassID());
    }

    public static void addUIElement(CustomGUIUpdate element) {
        customUiElements.add(element);
        System.out.println("Element added to Custom Updatable Elements: " + element.getComponentName());
    }
}
