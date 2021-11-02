package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerleftpanel;

import com.felipeflohr.uno.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.uno.swing.UpdatableElements.updateUIElements;

public class BottomPagePanel extends JPanel implements ActionListener, CustomGUIUpdate {

    JButton unoBtn;
    JLabel unoLabel;

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

        add(unoBtn);
        add(unoLabel);

        addUIElement(unoBtn);
        addUIElement((CustomGUIUpdate) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unoBtn) {
            if (getTable().getPlayers().get(getCurrentPlayer()).isUnoAllowed()) {
                getTable().getPlayers().get(getCurrentPlayer()).setUno(true);
            } else {
                getTable().getPlayers().get(getCurrentPlayer()).setUno(false);
                getTable().getPlayers().get(getCurrentPlayer()).buyCard(getUnoMisclickAmountOfCards());
            }
        }
        updateUIElements();
    }

    @Override
    public void update() {
        setLabelName();
    }

    @Override
    public String getComponentName() {
        return "Bottom Page Panel";
    }

    private void setLabelName() {
        if (getTable().getPlayers().get(getCurrentPlayer()).isUno()) {
            unoLabel.setText("You are Uno!");
        } else {
            unoLabel.setText("You are not Uno");
        }
    }
}
