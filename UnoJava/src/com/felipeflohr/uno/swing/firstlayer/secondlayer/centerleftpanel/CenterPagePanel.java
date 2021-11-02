package com.felipeflohr.uno.swing.firstlayer.secondlayer.centerleftpanel;

import com.felipeflohr.uno.exception.InvalidCardIconNumber;
import com.felipeflohr.uno.exception.InvalidColorException;
import com.felipeflohr.uno.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.uno.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.uno.tools.ResizeImage.resizeImage;

public class CenterPagePanel extends JPanel implements CustomGUIUpdate {

    JLabel chosenColorLabel;
    JLabel currentCardImage;

    public CenterPagePanel() {
        setLayout(new BorderLayout());
        setChosenColorBackground();

        // Current card label
        JLabel currentCardLabel = new JLabel("Current card:", SwingConstants.CENTER);
        currentCardLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentCardLabel.setBackground(new Color(168, 158, 158));
        currentCardLabel.setOpaque(true);

        // Chosen color
        chosenColorLabel = new JLabel();
        chosenColorLabel.setText("Placeholder");
        chosenColorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        chosenColorLabel.setVerticalAlignment(SwingConstants.CENTER);
        chosenColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setChosenColorText();

        // Current card image
        currentCardImage = new JLabel();
        currentCardImage.setHorizontalAlignment(SwingConstants.CENTER);
        currentCardImage.setVerticalAlignment(SwingConstants.CENTER);
        setCurrentCardImage();

        add(currentCardImage, BorderLayout.CENTER);
        add(currentCardLabel, BorderLayout.NORTH);
        add(chosenColorLabel, BorderLayout.SOUTH);

        addUIElement((JComponent) this);
        addUIElement((CustomGUIUpdate) this);
        addUIElement(chosenColorLabel);
        addUIElement(currentCardImage);
    }

    @Override
    public void update() {
        setChosenColorText();
        setChosenColorBackground();
        setCurrentCardImage();
    }

    @Override
    public String getComponentName() {
        return "Center Page Panel";
    }

    private void setChosenColorText() {
        String text;

        try {
            if (getTable().getColorSelected().equals("black") || getTable().getColorSelected().equals("yellow")) {
                chosenColorLabel.setForeground(Color.BLACK);
            } else {
                chosenColorLabel.setForeground(Color.WHITE);
            }
        } catch (NullPointerException ignored) {}

        try {
            text = switch (getTable().getColorSelected()) {
                case "black" -> "You can only pick black cards";
                case "red" -> "You can only pick red cards";
                case "yellow" -> "You can only pick yellow cards";
                case "blue" -> "You can only pick blue cards";
                case "green" -> "You can only pick green cards";
                default -> "";
            };
        } catch (NullPointerException e) {
            text = "";
        }

        chosenColorLabel.setText(text);
    }

    private void setChosenColorBackground() {
        Color bgColor;

        try{
            bgColor = switch (getTable().getColorSelected()) {
                case "black" -> new Color(16, 15, 15);
                case "red" -> new Color(255, 55, 55);
                case "yellow" -> new Color(255, 244, 58);
                case "blue" -> new Color(51, 51, 243);
                case "green" -> new Color(52, 180, 79);
                default -> new Color(115, 111, 111);
            };
        } catch (NullPointerException e) {
            bgColor = new Color(115, 111, 111);
        }

        setBackground(bgColor);
    }

    private void setCurrentCardImage() {
        String cardColor = getTable().getCurrentCard().getColor();
        String cardNumber = getTable().getCurrentCard().getNumber();
        final int CARD_WIDTH = getCurrentCardImageWidth();
        final int CARD_HEIGHT = getCurrentCardImageHeight();

        Image cardImage = switch (cardColor) {
            case "black" -> switch (cardNumber) {
                case "wild4" -> resizeImage("res/cards/+4.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "wild" -> resizeImage("res/cards/wild.PNG", CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid black card number");
            };
            case "blue" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/blue0.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage("res/cards/blue1.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage("res/cards/blue2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage("res/cards/blue3.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage("res/cards/blue4.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage("res/cards/blue5.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage("res/cards/blue6.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage("res/cards/blue7.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage("res/cards/blue8.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage("res/cards/blue9.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage("res/cards/blue+2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage("res/cards/bluereverse.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage("res/cards/blueskip.PNG", CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid blue card number");
            };
            case "red" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/red0.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage("res/cards/red1.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage("res/cards/red2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage("res/cards/red3.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage("res/cards/red4.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage("res/cards/red5.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage("res/cards/red6.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage("res/cards/red7.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage("res/cards/red8.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage("res/cards/red9.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage("res/cards/red+2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage("res/cards/redreverse.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage("res/cards/redskip.PNG", CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid red card number");
            };
            case "yellow" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/yellow0.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage("res/cards/yellow1.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage("res/cards/yellow2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage("res/cards/yellow3.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage("res/cards/yellow4.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage("res/cards/yellow5.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage("res/cards/yellow6.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage("res/cards/yellow7.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage("res/cards/yellow8.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage("res/cards/yellow9.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage("res/cards/yellow+2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage("res/cards/yellowreverse.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage("res/cards/yellowskip.PNG", CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid yellow card number");
            };
            case "green" -> switch (cardNumber) {
                case "0" -> resizeImage("res/cards/green0.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage("res/cards/green1.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage("res/cards/green2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage("res/cards/green3.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage("res/cards/green4.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage("res/cards/green5.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage("res/cards/green6.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage("res/cards/green7.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage("res/cards/green8.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage("res/cards/green9.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage("res/cards/green+2.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage("res/cards/greenreverse.PNG", CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage("res/cards/greenskip.PNG", CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid green card number");
            };
            default -> throw new InvalidColorException();
        };

        currentCardImage.setIcon(new ImageIcon(cardImage));
    }
}
