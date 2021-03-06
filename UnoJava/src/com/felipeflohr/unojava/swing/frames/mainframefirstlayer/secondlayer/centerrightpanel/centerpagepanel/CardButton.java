package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel;

import com.felipeflohr.unojava.exception.InvalidCardIconNumber;
import com.felipeflohr.unojava.exception.InvalidColorException;
import com.felipeflohr.unojava.swing.frames.warningframes.ForgotUnoButtonWarning;
import com.felipeflohr.unojava.uno.Card;
import com.felipeflohr.unojava.uno.Player;
import com.felipeflohr.unojava.uno.Table;
import com.felipeflohr.unojava.swing.frames.colorselectorframe.SelectColorDialog;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.*;
import static com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.CenterPagePanel.getSeparatedPlayerDecks;
import static com.felipeflohr.unojava.tools.ResizeImage.resizeImage;

/**
 * A JButton class that represents a Card button
 * @author Felipe Matheus Flohr
 */
public class CardButton extends JButton implements ActionListener, CustomCardGUI {

    private final Card card;
    private final Table table;
    private final String cardNumber;
    private final String cardColor;

    /**
     * Constructor for the card button
     * @param card The card this button will represent
     * @param table The game's table
     */
    public CardButton(Card card, Table table) {
        this.card = card;
        this.table = table;
        cardNumber = card.getNumber();
        cardColor = card.getColor();

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setFocusable(false);
        setBackground(getCardColor());
        setIcon(new ImageIcon(getCardIcon()));
        setEnabled(card.isCardPlayable(table) && getTable().getPlayerTurn() == getCurrentLocalPlayer());
        addActionListener(this);

        addUIElement(this);
        addCardElement(this);
    }

    // Public Methods
    @Override
    public void onCardClick() {
        if (getSeparatedPlayerDecks().get(getCurrentPage()).size() <= 1 && getCurrentPage() != 0) {
            setCurrentPage(getCurrentPage() - 1);
        }

        setEnabled(card.isCardPlayable(table) && getTable().getPlayerTurn() == getCurrentLocalPlayer());
    }

    @Override
    public String getCardName() {
        return "Card button ([" + cardNumber + ", " + cardColor + "])";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkColorSelected();
        onCardClick();

        if (isUnoSafe()) {
            colorSelectorDialog();
            card.playCard();
        } else {
            getTable().getPlayerByIndex(getTable().getPlayerTurn()).unoBuyCards();
        }

        try {
            getTable().moveToNextPlayer();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        updateUIElements();
    }

    // Private Methods
    /**
     * Gets the Image of the card. Example: if the card is a +4, then it will return a +4 image.
     * @return the Image of the card
     */
    private Image getCardIcon() {
        return switch (cardColor) {
            case "black" -> switch (cardNumber) {
                case "wild4" -> resizeImage(getClass().getResource("/cards/+4.PNG"), getCardIconWidth(), getCardIconHeight());
                case "wild" -> resizeImage(getClass().getResource("/cards/wild.PNG"), getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid black card number");
            };
            case "blue" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/blue0.PNG"), getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage(getClass().getResource("/cards/blue1.PNG"), getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage(getClass().getResource("/cards/blue2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage(getClass().getResource("/cards/blue3.PNG"), getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage(getClass().getResource("/cards/blue4.PNG"), getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage(getClass().getResource("/cards/blue5.PNG"), getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage(getClass().getResource("/cards/blue6.PNG"), getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage(getClass().getResource("/cards/blue7.PNG"), getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage(getClass().getResource("/cards/blue8.PNG"), getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage(getClass().getResource("/cards/blue9.PNG"), getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage(getClass().getResource("/cards/blue+2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage(getClass().getResource("/cards/bluereverse.PNG"), getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage(getClass().getResource("/cards/blueskip.PNG"), getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid blue card number");
            };
            case "red" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/red0.PNG"), getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage(getClass().getResource("/cards/red1.PNG"), getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage(getClass().getResource("/cards/red2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage(getClass().getResource("/cards/red3.PNG"), getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage(getClass().getResource("/cards/red4.PNG"), getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage(getClass().getResource("/cards/red5.PNG"), getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage(getClass().getResource("/cards/red6.PNG"), getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage(getClass().getResource("/cards/red7.PNG"), getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage(getClass().getResource("/cards/red8.PNG"), getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage(getClass().getResource("/cards/red9.PNG"), getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage(getClass().getResource("/cards/red+2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage(getClass().getResource("/cards/redreverse.PNG"), getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage(getClass().getResource("/cards/redskip.PNG"), getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid red card number");
            };
            case "yellow" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/yellow0.PNG"), getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage(getClass().getResource("/cards/yellow1.PNG"), getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage(getClass().getResource("/cards/yellow2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage(getClass().getResource("/cards/yellow3.PNG"), getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage(getClass().getResource("/cards/yellow4.PNG"), getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage(getClass().getResource("/cards/yellow5.PNG"), getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage(getClass().getResource("/cards/yellow6.PNG"), getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage(getClass().getResource("/cards/yellow7.PNG"), getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage(getClass().getResource("/cards/yellow8.PNG"), getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage(getClass().getResource("/cards/yellow9.PNG"), getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage(getClass().getResource("/cards/yellow+2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage(getClass().getResource("/cards/yellowreverse.PNG"), getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage(getClass().getResource("/cards/yellowskip.PNG"), getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid yellow card number");
            };
            case "green" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/green0.PNG"), getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage(getClass().getResource("/cards/green1.PNG"), getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage(getClass().getResource("/cards/green2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage(getClass().getResource("/cards/green3.PNG"), getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage(getClass().getResource("/cards/green4.PNG"), getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage(getClass().getResource("/cards/green5.PNG"), getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage(getClass().getResource("/cards/green6.PNG"), getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage(getClass().getResource("/cards/green7.PNG"), getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage(getClass().getResource("/cards/green8.PNG"), getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage(getClass().getResource("/cards/green9.PNG"), getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage(getClass().getResource("/cards/green+2.PNG"), getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage(getClass().getResource("/cards/greenreverse.PNG"), getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage(getClass().getResource("/cards/greenskip.PNG"), getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid green card number");
            };
            default -> throw new InvalidColorException();
        };
    }

    /**
     * Gets a Color-type object related to the card color
     * @return Color-type object representing this card color
     */
    private Color getCardColor() {
        return switch (this.cardColor) {
            case "black" -> new Color(45, 41, 41);
            case "red" -> new Color(245, 55, 32);
            case "blue" -> new Color(85, 85, 255);
            case "green" -> new Color(97, 197, 97);
            case "yellow" -> new Color(233, 246, 86);
            default -> throw new InvalidColorException();
        };
    }

    /**
     * Invokes the color selector dialog
     */
    private void colorSelectorDialog() {
        if (this.card.getNumber().equals("wild") || this.card.getNumber().equals("wild4")) {
            var colorDialog = new SelectColorDialog();
            colorDialog.pack();
            colorDialog.setVisible(true);
        }
    }

    /**
     * If there is a selected color, then it will set to null
     */
    private void checkColorSelected() {
        if (getTable().getColorSelected() != null) {
            getTable().setColorSelected(null);
        }
    }

    /**
     * Checks if the card played is safe from the Uno Warning
     * @return true if it is safe from Uno Warning
     */
    private boolean isUnoSafe() {
        final Player CURRENT_PLAYER = getTable().getPlayerByIndex(getTable().getPlayerTurn());

        if (!CURRENT_PLAYER.isAiEnabled()) {
            if (CURRENT_PLAYER.getDeck().size() <= 2 && !CURRENT_PLAYER.isUno()) {
                new ForgotUnoButtonWarning();
                return false;
            }
        }
        return true;
    }
}
