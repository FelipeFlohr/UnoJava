package com.felipeflohr.unojava.swing.frames.leftmenuframes;

import javax.swing.JOptionPane;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.restartTable;

public class RestartGameDialog {

    public RestartGameDialog() {
        final String MESSAGE = "Do you want to start a new game?";
        final String TITLE = "Start a new game";

        int dialog = JOptionPane.showConfirmDialog(null, MESSAGE, TITLE, JOptionPane.YES_NO_OPTION);
        if (dialog == 0) {
            restartTable();
        }
    }
}
