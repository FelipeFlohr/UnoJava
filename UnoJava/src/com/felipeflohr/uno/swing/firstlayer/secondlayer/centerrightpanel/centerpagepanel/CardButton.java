package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerrightpanel.centerpagepanel;

import com.felipeflohr.uno.exception.InvalidCardIconNumber;
import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.logic.Card;
import com.felipeflohr.uno.logic.Table;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getCardIconHeight;
import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getCardIconWidth;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.uno.tools.ResizeImage.resizeImage;

public class CardButton extends JButton implements ActionListener {

    private final Card card;
    private final String cardNumber;
    private final String cardColor;
    private final Table table;

    public CardButton(Card card, Table table) {
        this.card = card;
        this.table = table;
        cardNumber = card.getNumber();
        cardColor = card.getColor();

        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setIcon(new ImageIcon(getCardIcon()));
        setEnabled(card.isCardPlayable(table));
        addActionListener(this);

        addUIElement(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Add card behaviour
    }

    private Image getCardIcon() {
        Image cardIcon;

        switch (cardColor) {
            case "black":
                cardIcon = switch (cardNumber) {
                    case "wild4" -> resizeImage("res/cards/+4.PNG", getCardIconWidth(), getCardIconHeight());
                    case "wild" -> resizeImage("res/cards/wild.PNG", getCardIconWidth(), getCardIconHeight());
                    default -> throw new InvalidCardIconNumber("Invalid black card number");
                };
                break;
            case "blue":
                cardIcon = switch (cardNumber) {
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
                break;
            case "red":
                cardIcon = switch (cardNumber) {
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
                break;
            case "yellow":
                cardIcon = switch (cardNumber) {
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
                break;
            case "green":
                cardIcon = switch (cardNumber) {
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
                break;
            default:
                throw new InvalidColorException();
        }

        return cardIcon;
    }
}
