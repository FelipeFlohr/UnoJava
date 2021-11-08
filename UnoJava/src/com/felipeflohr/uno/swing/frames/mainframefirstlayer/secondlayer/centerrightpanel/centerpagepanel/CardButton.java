package com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.centerpagepanel;

import com.felipeflohr.uno.exception.InvalidCardIconNumber;
import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.logic.Card;
import com.felipeflohr.uno.logic.Table;
import com.felipeflohr.uno.swing.frames.colorselectorframe.SelectColorDialog;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.*;
import static com.felipeflohr.uno.swing.frames.mainframefirstlayer.secondlayer.centerrightpanel.CenterPagePanel.getSeparatedPlayerDecks;
import static com.felipeflohr.uno.tools.ResizeImage.resizeImage;

public class CardButton extends JButton implements ActionListener, CustomCardGUI {

    private final Card card;
    private final Table table;
    private final String cardNumber;
    private final String cardColor;

    public CardButton(Card card, Table table) {
        this.card = card;
        this.table = table;
        cardNumber = card.getNumber();
        cardColor = card.getColor();

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setFocusable(false);
        setBackground(getCardColor());
        setIcon(new ImageIcon(getCardIcon()));
        setEnabled(card.isCardPlayable(table));
        addActionListener(this);

        addUIElement(this);
        addCardElement(this);
    }

    // Public Methods
    @Override
    public void onCardClick() {
        if (getSeparatedPlayerDecks().get(getCurrentPage()).size() <= 1) {
            setCurrentPage(getCurrentPage() - 1);
        }

        setEnabled(card.isCardPlayable(table));
    }

    @Override
    public String getCardName() {
        return "Card button ([" + cardNumber + ", " + cardColor + "])";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkColorSelected();
        onCardClick();
        colorSelectorDialog();

        card.playCard();
        updateUIElements();
    }

    // Private Methods
    private Image getCardIcon() {
        return switch (cardColor) {
            case "black" -> switch (cardNumber) {
                case "wild4" -> resizeImage("res/cards/+4.PNG", getCardIconWidth(), getCardIconHeight());
                case "wild" -> resizeImage("res/cards/wild.PNG", getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid black card number");
            };
            case "blue" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/blue0.PNG", getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage("res/cards/blue1.PNG", getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage("res/cards/blue2.PNG", getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage("res/cards/blue3.PNG", getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage("res/cards/blue4.PNG", getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage("res/cards/blue5.PNG", getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage("res/cards/blue6.PNG", getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage("res/cards/blue7.PNG", getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage("res/cards/blue8.PNG", getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage("res/cards/blue9.PNG", getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage("res/cards/blue+2.PNG", getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage("res/cards/bluereverse.PNG", getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage("res/cards/blueskip.PNG", getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid blue card number");
            };
            case "red" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/red0.PNG", getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage("res/cards/red1.PNG", getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage("res/cards/red2.PNG", getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage("res/cards/red3.PNG", getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage("res/cards/red4.PNG", getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage("res/cards/red5.PNG", getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage("res/cards/red6.PNG", getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage("res/cards/red7.PNG", getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage("res/cards/red8.PNG", getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage("res/cards/red9.PNG", getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage("res/cards/red+2.PNG", getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage("res/cards/redreverse.PNG", getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage("res/cards/redskip.PNG", getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid red card number");
            };
            case "yellow" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/yellow0.PNG", getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage("res/cards/yellow1.PNG", getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage("res/cards/yellow2.PNG", getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage("res/cards/yellow3.PNG", getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage("res/cards/yellow4.PNG", getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage("res/cards/yellow5.PNG", getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage("res/cards/yellow6.PNG", getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage("res/cards/yellow7.PNG", getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage("res/cards/yellow8.PNG", getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage("res/cards/yellow9.PNG", getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage("res/cards/yellow+2.PNG", getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage("res/cards/yellowreverse.PNG", getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage("res/cards/yellowskip.PNG", getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid yellow card number");
            };
            case "green" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/green0.PNG", getCardIconWidth(), getCardIconHeight());
                case "1" -> resizeImage("res/cards/green1.PNG", getCardIconWidth(), getCardIconHeight());
                case "2" -> resizeImage("res/cards/green2.PNG", getCardIconWidth(), getCardIconHeight());
                case "3" -> resizeImage("res/cards/green3.PNG", getCardIconWidth(), getCardIconHeight());
                case "4" -> resizeImage("res/cards/green4.PNG", getCardIconWidth(), getCardIconHeight());
                case "5" -> resizeImage("res/cards/green5.PNG", getCardIconWidth(), getCardIconHeight());
                case "6" -> resizeImage("res/cards/green6.PNG", getCardIconWidth(), getCardIconHeight());
                case "7" -> resizeImage("res/cards/green7.PNG", getCardIconWidth(), getCardIconHeight());
                case "8" -> resizeImage("res/cards/green8.PNG", getCardIconWidth(), getCardIconHeight());
                case "9" -> resizeImage("res/cards/green9.PNG", getCardIconWidth(), getCardIconHeight());
                case "wild2" -> resizeImage("res/cards/green+2.PNG", getCardIconWidth(), getCardIconHeight());
                case "reverse" -> resizeImage("res/cards/greenreverse.PNG", getCardIconWidth(), getCardIconHeight());
                case "skip" -> resizeImage("res/cards/greenskip.PNG", getCardIconWidth(), getCardIconHeight());
                default -> throw new InvalidCardIconNumber("Invalid green card number");
            };
            default -> throw new InvalidColorException();
        };
    }

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

    private void colorSelectorDialog() {
        if (this.card.getNumber().equals("wild") || this.card.getNumber().equals("wild4")) {
            var colorDialog = new SelectColorDialog();
            colorDialog.pack();
            colorDialog.setVisible(true);
        }
    }

    private void checkColorSelected() {
        if (getTable().getColorSelected() != null) {
            getTable().setColorSelected(null);
        }
    }
}
