package com.felipeflohr.unojava.swing.frames.leftmenuframes;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.updateUIElements;

public class SettingsFrame extends JDialog {
    private JPanel contentPane;
    private JComboBox<String> amountOfPlayersComboBox;
    private JTextField initialAmountOfCardsTxtField;
    private JTextField cardButtonIconWidthTxtField;
    private JTextField cardButtonIconHeightTxtField;
    private JTextField cardButtonsGridRowsTxtField;
    private JTextField cardButtonsGridColumnsTxtField;
    private JTextField currentCardWidthTxtField;
    private JTextField currentCardHeightTxtField;
    private JButton initialAmountCardsBtn;
    private JButton cardButtonIconWidthBtn;
    private JButton cardButtonIconHeightBtn;
    private JButton cardButtonsGridRowsBtn;
    private JButton cardButtonsGridColumnsBtn;
    private JButton currentCardWidthBtn;
    private JButton currentCardHeightBtn;
    private JButton saveBtn;
    private JCheckBox printUpdateMessagesCheckBox;
    private JCheckBox printAddedElementsCheckBox;
    private JCheckBox printAIMessagesCheckBox;
    private JCheckBox aiEnabledCheckBox;

    public SettingsFrame() {
        /* Settings:
        - Total amount of players
        - Initial amount of cards
        - Card icon width
        - Card icon height
        - Card grid -> rows
        - Card grid -> columns
        - Icon of cardButtonsGridRowsBtn on table width
        - Icon of cardButtonsGridRowsBtn on table height
        - Non-AI player / Current local Player
        - Print update messages
        - Print added element messages
        - Print AI Debug
        - AI Enabled
         */

        // Settings variables
        AtomicInteger totalAmountOfPlayers = new AtomicInteger(getTotalAmountOfPlayers());
        AtomicInteger initialCards = new AtomicInteger(getInitialCardsAmount());
        AtomicInteger cardIconWidth = new AtomicInteger(getCardIconWidth());
        AtomicInteger cardIconHeight = new AtomicInteger(getCardIconHeight());
        AtomicInteger cardGridRows = new AtomicInteger(getCardGridRows());
        AtomicInteger cardGridColumns = new AtomicInteger(getCardGridColumns());
        AtomicInteger cardOnTableWidth = new AtomicInteger(getCurrentCardImageWidth());
        AtomicInteger cardOnTableHeight = new AtomicInteger(getCurrentCardImageHeight());
        AtomicBoolean printUpdateMessages = new AtomicBoolean(isPrintUpdateMessages());
        AtomicBoolean printAddedElementMessages = new AtomicBoolean(isPrintAddedElementMessages());
        AtomicBoolean printAiDebug = new AtomicBoolean(isAiDebugMessagesEnabled());
        AtomicBoolean aiEnabled = new AtomicBoolean(isAiEnabled());

        // Settings text fields
        initialAmountOfCardsTxtField.setText(String.valueOf(initialCards.get()));

        // Amount of players combo box
        final String[] NUMBERS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };
        Arrays.stream(NUMBERS).forEachOrdered(num -> amountOfPlayersComboBox.addItem(num));
        amountOfPlayersComboBox.addActionListener(e -> totalAmountOfPlayers.set(Integer.parseInt((String) Objects.requireNonNull(amountOfPlayersComboBox.getSelectedItem()))));
        amountOfPlayersComboBox.setSelectedItem(String.valueOf(totalAmountOfPlayers));

        // Initial amount of Cards - Button listener
        initialAmountCardsBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(initialAmountOfCardsTxtField.getText());

                if (amount <= 2) {
                    throw new NumberFormatException();
                } else {
                    initialCards.set(amount);
                }
            } catch (NumberFormatException initialAmountException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Card icon width
        cardButtonIconWidthTxtField.setText(String.valueOf(cardIconWidth.get()));
        cardButtonIconWidthBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(cardButtonIconWidthTxtField.getText());

                if (amount <= 10) {
                    throw new NumberFormatException();
                } else {
                    cardIconWidth.set(amount);
                }
            } catch (NumberFormatException cardBtnWidthException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Card icon height
        cardButtonIconHeightTxtField.setText(String.valueOf(cardIconHeight.get()));
        cardButtonIconHeightBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(cardButtonIconHeightTxtField.getText());

                if (amount <= 10) {
                    throw new NumberFormatException();
                } else {
                    cardIconHeight.set(amount);
                }
            } catch (NumberFormatException cardBtnHeightException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Card buttons grid - amount of rows
        cardButtonsGridRowsTxtField.setText(String.valueOf(cardGridRows));
        cardButtonsGridRowsBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(cardButtonsGridRowsTxtField.getText());

                if (amount <= 1 || amount > 9) {
                    throw new NumberFormatException();
                } else {
                    cardGridRows.set(amount);
                }
            } catch (NumberFormatException cardBtnGridRowsException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Card buttons grid - amount of columns
        cardButtonsGridColumnsTxtField.setText(String.valueOf(cardGridRows));
        cardButtonsGridColumnsBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(cardButtonsGridColumnsTxtField.getText());

                if (amount <= 1 || amount > 9) {
                    throw new NumberFormatException();
                } else {
                    cardGridColumns.set(amount);
                }
            } catch (NumberFormatException cardBtnGridColumnsException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Current card - width
        currentCardWidthTxtField.setText(String.valueOf(cardOnTableWidth));
        currentCardWidthBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(currentCardWidthBtn.getText());

                if (amount <= 10) {
                    throw new NumberFormatException();
                } else {
                    cardOnTableWidth.set(amount);
                }
            } catch (NumberFormatException cardTableWidthException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Current card - height
        currentCardHeightTxtField.setText(String.valueOf(cardOnTableHeight));
        currentCardHeightBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(currentCardHeightBtn.getText());

                if (amount <= 10) {
                    throw new NumberFormatException();
                } else {
                    cardOnTableHeight.set(amount);
                }
            } catch (NumberFormatException cardTableHeightException) {
                JOptionPane.showMessageDialog(null, "Invalid value", "Warning:", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Print update messages
        printUpdateMessagesCheckBox.setSelected(printUpdateMessages.get());
        printUpdateMessagesCheckBox.setText((printUpdateMessages.get()) ? "True" : "False");
        printUpdateMessagesCheckBox.addActionListener(e -> {
            printUpdateMessages.set(!printUpdateMessages.get());
            printUpdateMessagesCheckBox.setText((printUpdateMessages.get()) ? "True" : "False");
        });

        // Print added elements
        printAddedElementsCheckBox.setSelected(printAddedElementMessages.get());
        printAddedElementsCheckBox.setText((printAddedElementMessages.get()) ? "True" : "False");
        printAddedElementsCheckBox.addActionListener(e -> {
            printAddedElementMessages.set(!printAddedElementMessages.get());
            printAddedElementsCheckBox.setText((printAddedElementMessages.get()) ? "True" : "False");
        });

        // Print AI Debug messages
        printAIMessagesCheckBox.setSelected(printAiDebug.get());
        printAIMessagesCheckBox.setText(printAiDebug.get() ? "True" : "False");
        printAIMessagesCheckBox.addActionListener(e -> {
            printAiDebug.set(!printAiDebug.get());
            printAIMessagesCheckBox.setText(printAiDebug.get() ? "True" : "False");
        });

        // AI Enabled
        aiEnabledCheckBox.setSelected(aiEnabled.get());
        aiEnabledCheckBox.setText((aiEnabled.get()) ? "True" : "False");
        aiEnabledCheckBox.addActionListener(e -> {
            aiEnabled.set(!aiEnabled.get());
            aiEnabledCheckBox.setText((aiEnabled.get()) ? "True" : "False");
        });

        // Save button
        saveBtn.addActionListener(e -> {
            setTotalAmountOfPlayers(totalAmountOfPlayers.get());
            setInitialCardsAmount(initialCards.get());
            setCardIconWidth(cardIconWidth.get());
            setCardIconHeight(cardIconHeight.get());
            setCardGridRows(cardGridRows.get());
            setCardGridColumns(cardGridColumns.get());
            setCurrentCardImageWidth(cardOnTableWidth.get());
            setCurrentCardImageHeight(cardOnTableHeight.get());
            setPrintUpdateMessages(printUpdateMessages.get());
            setPrintAddedElementMessages(printAddedElementMessages.get());
            setAiDebugMessagesEnabled(printAiDebug.get());
            setAiEnabled(aiEnabled.get());

            updateUIElements();
            dispose();
        });

        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        setTitle("Settings:");
        pack();
        setResizable(false);
        setVisible(true);
    }
}
