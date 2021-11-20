package com.felipeflohr.unojava.swing;

/**
 * Interface which its purpose is for updating custom JComponent elements
 * @author Felipe Matheus Flohr
 */
public interface CustomGUIUpdate {

    /**
     * Updates the UI according to the implement method
     */
    void update();

    /**
     * Gets the component name
     * @return component name
     */
    String getComponentName();

}
