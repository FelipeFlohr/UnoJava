package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerleftpanel;

import com.felipeflohr.uno.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.uno.swing.UpdatableElements.updateUIElements;

public class BottomPagePanel extends JPanel implements ActionListener, CustomGUIUpdate {

    private final JButton unoBtn;
    private final JLabel unoLabel;
    private final JButton buyCardBtn;

    public BottomPagePanel() {
        setLayout(new GridLayout());
        setBackground(new Color(245, 236, 236));
        setPreferredSize(new Dimension(0, 50));

        // Uno button
        unoBtn = new JButton();
        unoBtn.setText("UNO!");
        unoBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        unoBtn.setFocusable(false);
        unoBtn.setBackground(new Color(0xF1F1F6));
        unoBtn.addActionListener(this);
        unoBtn.setFont(new Font("Arial", Font.PLAIN, 25));

        // Uno label
        unoLabel = new JLabel();
        setLabelName();
        unoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        unoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        unoLabel.setBackground(new Color(0xD5D5DE));
        unoLabel.setOpaque(true);

        // Buy card button
        buyCardBtn = new JButton();
        buyCardBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buyCardBtn.setFocusable(false);
        buyCardBtn.setBackground(new Color(0xF1F1F6));
        buyCardBtn.addActionListener(this);
        buyCardBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        setBuyCardButtonName();

        add(unoBtn);
        add(unoLabel);
        add(buyCardBtn);

        addUIElement(unoBtn);
        addUIElement(buyCardBtn);
        addUIElement((CustomGUIUpdate) this);

        setButtonsEnabled();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unoBtn) {
            // TODO Better Uno Button implementation
            if (getTable().getPlayers().get(getCurrentLocalPlayer()).isUnoAllowed()) {
                getTable().getPlayers().get(getCurrentLocalPlayer()).setUno(true);
            } else {
                getTable().getPlayers().get(getCurrentLocalPlayer()).setUno(false);
                getTable().getPlayers().get(getCurrentLocalPlayer()).buyCard(getUnoMisclickAmountOfCards());
                getTable().moveToNextPlayer();
            }
        }

        if (e.getSource() == buyCardBtn) {
            if (getTable().getBuyTurnAmount() > 1) {
                // Cards will be bought accordingly to the current turn amount
                getTable().getPlayerByIndex(getCurrentLocalPlayer()).buyCard(getTable().getBuyTurnAmount());
            } else {
                getTable().getPlayerByIndex(getCurrentLocalPlayer()).buyCard();
            }

            getTable().cardBoughtEffect();
            getTable().moveToNextPlayer();
        }
        updateUIElements();
    }

    // Public methods
    @Override
    public void update() {
        setLabelName();
        setBuyCardButtonName();
        setButtonsEnabled();
    }

    @Override
    public String getComponentName() {
        return "Bottom Page Panel";
    }

    // Private methods
    private void setLabelName() {
        if (getTable().getPlayers().get(getCurrentLocalPlayer()).isUno()) {
            unoLabel.setText("You are Uno!");
        } else {
            unoLabel.setText("You are not Uno");
        }
    }

    private void setBuyCardButtonName() {
        if (getTable().getBuyTurnAmount() > 1) {
            buyCardBtn.setText("Buy " + getTable().getBuyTurnAmount() + " cards");
        } else {
            buyCardBtn.setText("Buy one card");
        }
    }

    private void setButtonsEnabled() {
        if (getCurrentLocalPlayer() == getTable().getPlayerTurn()) {
            buyCardBtn.setEnabled(true);
            unoBtn.setEnabled(true);
        } else {
            buyCardBtn.setEnabled(false);
            unoBtn.setEnabled(false);
        }
    }
}
