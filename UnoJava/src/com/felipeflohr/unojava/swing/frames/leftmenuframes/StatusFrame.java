package com.felipeflohr.unojava.swing.frames.leftmenuframes;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;

public class StatusFrame extends JDialog {

    public StatusFrame() {
        /* Labels:
        - Amount of players
        - Player with the least amount of cards
        - Current card on table
        - Current player
        - Buy turn card
        - Buy turn amount
        - Is it reverse?
        - Is it skip?
        - Is there a color selected?
        - Is AI enabled?
         */

        final JPanel CONTENT_PANE = new JPanel();
        final String BUY_TURN_CARD = (getTable().getBuyTurnCard() == null) ? "none" : getTable().getBuyTurnCard().getNumber() + ", " + getTable().getBuyTurnCard().getColor();
        final String COLOR_SELECTED = (getTable().getColorSelected() == null) ? "none" : getTable().getColorSelected();

        final JLabel AMOUNT_OF_PLAYERS = new JLabel("Amount of players: " + getTotalAmountOfPlayers());
        final JLabel PLAYER_WITH_LEAST_CARDS = new JLabel("Player with the least amount of cards: #" + getTable().getPlayerIdWithLeastCards());
        final JLabel CURRENT_CARD_TABLE = new JLabel("Current card on table: " + getTable().getCurrentCard().getNumber() + ", " + getTable().getCurrentCard().getColor());
        final JLabel CURRENT_PLAYER = new JLabel("Current player: " + getTable().getPlayerTurn());
        final JLabel BUY_TURN_CARD_LABEL = new JLabel("Buy turn card: " + BUY_TURN_CARD);
        final JLabel BUY_TURN_AMOUNT = new JLabel("Buy turn amount: " + getTable().getBuyTurnAmount());
        final JLabel REVERSE_STATUS = new JLabel("Is it reverse? " + getTable().isReverse());
        final JLabel SKIP_STATUS = new JLabel("Is it skip? " + getTable().isSkip());
        final JLabel COLOR_SELECTED_STATUS = new JLabel("Color selected: " + COLOR_SELECTED);
        final JLabel AI_ENABLED = new JLabel("Is AI enabled? " + isAiEnabled());

        CONTENT_PANE.add(AMOUNT_OF_PLAYERS);
        CONTENT_PANE.add(PLAYER_WITH_LEAST_CARDS);
        CONTENT_PANE.add(CURRENT_CARD_TABLE);
        CONTENT_PANE.add(CURRENT_PLAYER);
        CONTENT_PANE.add(BUY_TURN_CARD_LABEL);
        CONTENT_PANE.add(BUY_TURN_AMOUNT);
        CONTENT_PANE.add(REVERSE_STATUS);
        CONTENT_PANE.add(SKIP_STATUS);
        CONTENT_PANE.add(COLOR_SELECTED_STATUS);
        CONTENT_PANE.add(AI_ENABLED);

        getRootPane().setDefaultButton(null);
        setTitle("Info:");
        setContentPane(CONTENT_PANE);
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        setSize(256, 220);
        setVisible(true);
    }
}
