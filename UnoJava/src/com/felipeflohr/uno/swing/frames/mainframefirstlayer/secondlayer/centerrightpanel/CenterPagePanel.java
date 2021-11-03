package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel;

import com.felipeflohr.uno.logic.Card;
import com.felipeflohr.uno.swing.CustomGUIUpdate;
import com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel.CardButton;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;

public class CenterPagePanel extends JPanel implements CustomGUIUpdate {

    public CenterPagePanel() {
        setLayout(new GridLayout(getCardGridRows(), getCardGridColumns()));
        setBackground(new Color(115, 111, 111));

        addButtons();
        addUIElement((JComponent) this);
        addUIElement((CustomGUIUpdate) this);
        setCenterPagePanel(this);
    }

    public void redrawButtons() {
        removeAllButtons();
        addButtons();
    }

    private List<List<Card>> getSeparatedPlayerDecks() {
        List<List<Card>> playerDecks = new ArrayList<>();
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentPlayer()).getAmountOfCards();
        int amountOfPages = (int) Math.ceil(amountOfCards / gridSize);

        for (int i = 0; i < amountOfPages; i++) {
            List<Card> playerDeck = new ArrayList<>();

            try {
                for (int j = (int) gridSize * i; j < gridSize * (i + 1); j++) {
                    playerDeck.add(getTable().getPlayerByIndex(getCurrentPlayer()).getDeck().get(j));
                }
            } catch (IndexOutOfBoundsException ignored) {}

            playerDecks.add(playerDeck);
        }

        return playerDecks;
    }

    private void addButtons() {
        getSeparatedPlayerDecks()
                .get(getCurrentPage())
                .forEach(c -> add(new CardButton(c, getTable())));
    }

    private void removeAllButtons() {
        Arrays.stream(getComponents()).forEach(this::remove);
    }

    @Override
    public void update() {
        redrawButtons();
    }

    @Override
    public String getComponentName() {
        return "Center Page Panel";
    }
}
