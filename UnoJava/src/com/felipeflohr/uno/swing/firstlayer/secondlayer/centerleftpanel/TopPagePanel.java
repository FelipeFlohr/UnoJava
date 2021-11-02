package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerleftpanel;

import com.felipeflohr.uno.swing.CustomGUIUpdate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getTable;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;

public class TopPagePanel extends JPanel implements CustomGUIUpdate {

    JLabel amountOfCards;

    public TopPagePanel() {
        setLayout(new GridLayout());
        setBackground(new Color(245, 236, 236));
        setPreferredSize(new Dimension(0, 50));

        amountOfCards = new JLabel();
        amountOfCards.setVerticalAlignment(SwingConstants.CENTER);
        amountOfCards.setHorizontalAlignment(SwingConstants.CENTER);
        amountOfCards.setFont(new Font("Arial", Font.PLAIN, 20));

        add(amountOfCards);
        setPanelText();
        addUIElement((CustomGUIUpdate) this);
    }

    private void setPanelText() {
        if (getTable().everyoneHasTheSameAmountOfCards()) {
            amountOfCards.setText("Everyone has the same amount of cards");
        } else {
            amountOfCards.setText("Player #" + getTable().getPlayerIdWithLeastCards() + " has the least amount of cards");
        }
    }

    @Override
    public void update() {
        setPanelText();
    }

    @Override
    public String getComponentName() {
        return "TopPagePanel";
    }
}
