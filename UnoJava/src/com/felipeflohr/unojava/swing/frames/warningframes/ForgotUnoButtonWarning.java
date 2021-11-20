package com.felipeflohr.unojava.swing.frames.warningframes;

import javax.swing.JOptionPane;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getUnoMisclickAmountOfCards;

/**
 * A JOptionPane dialog that is invoked when the player forgets to press the Uno button
 * @author Felipe Matheus Flohr
 */
public class ForgotUnoButtonWarning {

    public ForgotUnoButtonWarning() {
        final String MESSAGE = "You forgot to press the Uno button. " + getUnoMisclickAmountOfCards() + " card(s) will be bought";
        final String TITLE = "UNO?";
        JOptionPane.showMessageDialog(null, MESSAGE, TITLE, JOptionPane.WARNING_MESSAGE);
    }
}
