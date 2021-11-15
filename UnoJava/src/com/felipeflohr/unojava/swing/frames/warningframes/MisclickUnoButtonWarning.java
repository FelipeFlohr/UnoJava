package com.felipeflohr.unojava.swing.frames.warningframes;

import javax.swing.JOptionPane;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getUnoMisclickAmountOfCards;

public class MisclickUnoButtonWarning {

    public MisclickUnoButtonWarning() {
        final String MESSAGE = "You were not supposed to press the Uno button! " + getUnoMisclickAmountOfCards() + " card(s) will be bought";
        final String TITLE = "UNO :(";
        JOptionPane.showMessageDialog(null, MESSAGE, TITLE, JOptionPane.WARNING_MESSAGE);
    }
}
