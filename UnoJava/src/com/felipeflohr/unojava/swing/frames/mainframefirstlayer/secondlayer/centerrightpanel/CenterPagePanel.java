package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel;

import com.felipeflohr.unojava.swing.frames.warningframes.PlayerWonWarning;
import com.felipeflohr.unojava.uno.Card;
import com.felipeflohr.unojava.swing.CustomGUIUpdate;
import com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel.CardButton;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.addUIElement;

/**
 * A JPanel which holds the Card buttons
 */
public class CenterPagePanel extends JPanel implements CustomGUIUpdate {

    public CenterPagePanel() {
        setLayout(new GridLayout(getCardGridRows(), getCardGridColumns()));
        setBackground(new Color(115, 111, 111));

        addButtons();
        addUIElement((JComponent) this);
        addUIElement((CustomGUIUpdate) this);
        setCenterPagePanel(this);
    }

    // Public Methods
    @Override
    public void update() {
        redrawButtons();
    }

    @Override
    public String getComponentName() {
        return "Center Page Panel";
    }

    /**
     * Will remove all the buttons from this JPanel, then re-add them.
     */
    public void redrawButtons() {
        removeAllButtons();
        addButtons();
    }

    /**
     * Generates a List containing decks. Each deck represents a page on the UI.
     * @return a List containing decks.
     */
    public static List<List<Card>> getSeparatedPlayerDecks() {
        List<List<Card>> playerDecks = new ArrayList<>();
        double gridSize = getCardGridRows() * getCardGridColumns();
        double amountOfCards = getTable().getPlayerByIndex(getCurrentLocalPlayer()).getAmountOfCards();
        int amountOfPages = (int) Math.ceil(amountOfCards / gridSize);

        for (int i = 0; i < amountOfPages; i++) {
            List<Card> playerDeck = new ArrayList<>();

            try {
                for (int j = (int) gridSize * i; j < gridSize * (i + 1); j++) {
                    playerDeck.add(getTable().getPlayerByIndex(getCurrentLocalPlayer()).getDeck().get(j));
                }
            } catch (IndexOutOfBoundsException ignored) {}

            playerDecks.add(playerDeck);
        }

        return playerDecks;
    }

    // Private Methods
    /**
     * Adds all the player's card as buttons in this JPanel
     */
    private void addButtons() {
        try {
            getSeparatedPlayerDecks()
                    .get(getCurrentPage())
                    .forEach(c -> add(new CardButton(c, getTable())));
        } catch (IndexOutOfBoundsException e) {
            new PlayerWonWarning();
        }
    }

    /**
     * Remove all the buttons from this JPanel
     */
    private void removeAllButtons() {
        Arrays.stream(getComponents()).forEach(this::remove);
    }
}
