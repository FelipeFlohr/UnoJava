package com.felipeflohr.unojava.swing.frames.leftmenuframes;

import com.felipeflohr.unojava.uno.Card;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

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

        // Labels
        final JLabel AMOUNT_OF_PLAYERS = new JLabel("Amount of players: ");
        final JLabel AMOUNT_OF_PLAYERS_VALUE = new JLabel(String.valueOf(getTotalAmountOfPlayers()));

        final JLabel PLAYER_WITH_LEAST_CARDS = new JLabel("Player with the least amount of cards: ");
        final JLabel PLAYER_WITH_LEAST_CARDS_VALUE = new JLabel("#" + getTable().getPlayerIdWithLeastCards());

        final JLabel CURRENT_CARD_TABLE = new JLabel("Current card on table: ");
        final JLabel CURRENT_CARD_TABLE_VALUE = cardLabel(getTable().getCurrentCard());

        final JLabel CURRENT_PLAYER = new JLabel("Current player: ");
        final JLabel CURRENT_PLAYER_VALUE = new JLabel(String.valueOf(getTable().getPlayerTurn()));

        final JLabel BUY_TURN_CARD_LABEL = new JLabel("Buy turn card: ");
        final JLabel BUY_TURN_CARD_LABEL_VALUE = buyTurnCardLabel();

        final JLabel BUY_TURN_AMOUNT = new JLabel("Buy turn amount: ");
        final JLabel BUY_TURN_AMOUNT_VALUE = new JLabel(String.valueOf(getTable().getBuyTurnAmount()));

        final JLabel REVERSE_STATUS = new JLabel("Is it reverse? ");
        final JLabel REVERSE_STATUS_VALUE = generateLabel(getTable().isReverse());

        final JLabel SKIP_STATUS = new JLabel("Is it skip? ");
        final JLabel SKIP_STATUS_VALUE = generateLabel(getTable().isSkip());

        final JLabel COLOR_SELECTED_STATUS = new JLabel("Color selected: ");
        final JLabel COLOR_SELECTED_STATUS_VALUE = colorLabel();

        final JLabel AI_ENABLED = new JLabel("Is AI enabled? ");
        final JLabel AI_ENABLED_VALUE = generateLabel(isAiEnabled());

        CONTENT_PANE.add(AMOUNT_OF_PLAYERS); // Amount of players
        CONTENT_PANE.add(AMOUNT_OF_PLAYERS_VALUE);
        CONTENT_PANE.add(PLAYER_WITH_LEAST_CARDS); // Player with the least amount of cards
        CONTENT_PANE.add(PLAYER_WITH_LEAST_CARDS_VALUE);
        CONTENT_PANE.add(CURRENT_CARD_TABLE); // Current card on table
        CONTENT_PANE.add(CURRENT_CARD_TABLE_VALUE);
        CONTENT_PANE.add(CURRENT_PLAYER); // Current player
        CONTENT_PANE.add(CURRENT_PLAYER_VALUE);
        CONTENT_PANE.add(BUY_TURN_CARD_LABEL); // Buy turn card
        CONTENT_PANE.add(BUY_TURN_CARD_LABEL_VALUE);
        CONTENT_PANE.add(BUY_TURN_AMOUNT); // Buy turn amount
        CONTENT_PANE.add(BUY_TURN_AMOUNT_VALUE);
        CONTENT_PANE.add(REVERSE_STATUS); // Reverse status
        CONTENT_PANE.add(REVERSE_STATUS_VALUE);
        CONTENT_PANE.add(SKIP_STATUS); // Skip status
        CONTENT_PANE.add(SKIP_STATUS_VALUE);
        CONTENT_PANE.add(COLOR_SELECTED_STATUS); // Color selected status
        CONTENT_PANE.add(COLOR_SELECTED_STATUS_VALUE);
        CONTENT_PANE.add(AI_ENABLED); // AI Enabled status
        CONTENT_PANE.add(AI_ENABLED_VALUE);

        add(CONTENT_PANE);
        getRootPane().setDefaultButton(null);
        setTitle("Info:");
        setContentPane(CONTENT_PANE);
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        setSize(486, 256);
        setLayout(new GridLayout(10, 2, 1, 1));
        setVisible(true);
    }

    private JLabel generateLabel(boolean value) {
        JLabel label = new JLabel();
        if (value) {
            label.setText("yes");
            label.setForeground(Color.BLUE);
        } else {
            label.setText("no");
            label.setForeground(Color.RED);
        }

        return label;
    }

    private JLabel cardLabel(Card card) {
        JLabel label = new JLabel(card.getNumber().replace(card.getNumber().charAt(0), card.getNumber().toUpperCase().charAt(0)) + ", " + card.getColor());
        switch (card.getColor()) {
            case "blue" -> label.setForeground(Color.BLUE);
            case "green" -> label.setForeground(Color.GREEN);
            case "red" -> label.setForeground(Color.RED);
            case "yellow" -> label.setForeground(Color.YELLOW);
            default -> label.setForeground(Color.BLACK);
        }

        return label;
    }

    private JLabel buyTurnCardLabel() {
        JLabel label = (getTable().getBuyTurnCard() == null) ? new JLabel("none") : new JLabel(getTable().getBuyTurnCard().getNumber() + ", " + getTable().getBuyTurnCard().getColor());
        if (getTable().getBuyTurnCard() != null) {
            switch (getTable().getBuyTurnCard().getColor()) {
                case "blue" -> label.setForeground(Color.BLUE);
                case "green" -> label.setForeground(Color.GREEN);
                case "red" -> label.setForeground(Color.RED);
                case "yellow" -> label.setForeground(Color.YELLOW);
                default -> label.setForeground(Color.BLACK);
            }
        }

        return label;
    }

    private JLabel colorLabel() {
        final String COLOR_SELECTED = (getTable().getColorSelected() == null) ? "none" : getTable().getColorSelected();
        JLabel label = new JLabel(COLOR_SELECTED);

        if (!COLOR_SELECTED.equals("none")) {
            switch (COLOR_SELECTED) {
                case "blue" -> label.setForeground(Color.BLUE);
                case "green" -> label.setForeground(Color.GREEN);
                case "red" -> label.setForeground(Color.RED);
                case "yellow" -> label.setForeground(Color.YELLOW);
                default -> label.setForeground(Color.BLACK);
            }
        }

        return label;
    }
}