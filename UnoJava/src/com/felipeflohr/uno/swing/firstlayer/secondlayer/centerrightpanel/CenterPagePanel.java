package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel;

import com.felipeflohr.uno.logic.Card;
import com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel.centerpagepanel.CardButton;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;

public class CenterPagePanel extends JPanel {

    public CenterPagePanel() {
        setLayout(new GridLayout(getCardGridRows(), getCardGridColumns()));
        setBackground(new Color(119, 5, 5));

        addButtons();
        addUIElement(this);
    }

    private void addButtons() {
        List<List<Card>> playerDecks = new ArrayList<>();
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentPlayer()).getAmountOfCards();
        int amountOfPages = (int) Math.ceil(amountOfCards / gridSize);

        for (int i = 0; i < amountOfPages; i++) {
            List<Card> playerDeck = new ArrayList<>();

            try {
                for (int j = 0; j < gridSize; j++) {
                    playerDeck.add(getTable().getPlayerByIndex(getCurrentPlayer()).getDeck().get(j));
                }
            } catch (IndexOutOfBoundsException ignored) {

            }

            playerDecks.add(playerDeck);
        }

        for (int i = 0; i < playerDecks.get(getCurrentPage()).size(); i++) {
            add(new CardButton(playerDecks.get(getCurrentPage()).get(i), getTable()));
        }
    }
}
