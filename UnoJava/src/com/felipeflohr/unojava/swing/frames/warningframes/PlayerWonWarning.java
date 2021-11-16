package com.felipeflohr.unojava.swing.frames.warningframes;

import javax.swing.JOptionPane;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getTable;
import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.restartTable;

public class PlayerWonWarning {

    public PlayerWonWarning() {
        final String MESSAGE = "Player #" + getTable().getPlayerTurn() + " won! Do you want to start a new game? (Closing this window or pressing yes will close the game)";
        final String TITLE = "Player #" + getTable().getPlayerTurn() + "won!";

        int dialog = JOptionPane.showConfirmDialog(null, MESSAGE, TITLE, JOptionPane.YES_NO_OPTION);
        if (dialog == 0) {
            restartTable();
        } else {
            System.exit(0);
        }
    }
}
