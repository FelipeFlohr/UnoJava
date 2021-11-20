package com.felipeflohr.unojava.swing.frames.mainframefirstlayer.secondlayer.centerleftpanel;

import com.felipeflohr.unojava.exception.InvalidCardIconNumber;
import com.felipeflohr.unojava.exception.InvalidColorException;
import com.felipeflohr.unojava.swing.CustomGUIUpdate;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.*;
import static com.felipeflohr.unojava.swing.UpdatableElements.addUIElement;
import static com.felipeflohr.unojava.tools.ResizeImage.resizeImage;

/**
 * A JPanel to be added to the Left Panel at the Center Direction. Holds the current card on table
 * @author Felipe Matheus Flohr
 */
public class CenterPagePanel extends JPanel implements CustomGUIUpdate {

    private final JLabel chosenColorLabel;
    private final JLabel currentCardImage;

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

    // Public methods
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

    // Private methods
    /**
     * Sets the "Chosen Color" text foreground color. Turns Black if the selected color is yellow
     */
    private void setChosenColorText() {
        String text;

        try {
            if (getTable().getColorSelected().equals("yellow")) {
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

    /**
     * Sets the background according to the selected color
     */
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

    /**
     * Sets the card icon according to the current card on table
     */
    private void setCurrentCardImage() {
        String cardColor = getTable().getCurrentCard().getColor();
        String cardNumber = getTable().getCurrentCard().getNumber();
        final int CARD_WIDTH = getCurrentCardImageWidth();
        final int CARD_HEIGHT = getCurrentCardImageHeight();

        Image cardImage = switch (cardColor) {
            case "black" -> switch (cardNumber) {
                case "wild4" -> resizeImage(getClass().getResource("/cards/+4.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "wild" -> resizeImage(getClass().getResource("/cards/wild.PNG"), CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid black card number");
            };
            case "blue" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/blue0.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage(getClass().getResource("/cards/blue1.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage(getClass().getResource("/cards/blue2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage(getClass().getResource("/cards/blue3.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage(getClass().getResource("/cards/blue4.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage(getClass().getResource("/cards/blue5.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage(getClass().getResource("/cards/blue6.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage(getClass().getResource("/cards/blue7.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage(getClass().getResource("/cards/blue8.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage(getClass().getResource("/cards/blue9.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage(getClass().getResource("/cards/blue+2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage(getClass().getResource("/cards/bluereverse.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage(getClass().getResource("/cards/blueskip.PNG"), CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid blue card number");
            };
            case "red" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/red0.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage(getClass().getResource("/cards/red1.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage(getClass().getResource("/cards/red2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage(getClass().getResource("/cards/red3.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage(getClass().getResource("/cards/red4.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage(getClass().getResource("/cards/red5.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage(getClass().getResource("/cards/red6.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage(getClass().getResource("/cards/red7.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage(getClass().getResource("/cards/red8.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage(getClass().getResource("/cards/red9.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage(getClass().getResource("/cards/red+2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage(getClass().getResource("/cards/redreverse.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage(getClass().getResource("/cards/redskip.PNG"), CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid red card number");
            };
            case "yellow" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/yellow0.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage(getClass().getResource("/cards/yellow1.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage(getClass().getResource("/cards/yellow2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage(getClass().getResource("/cards/yellow3.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage(getClass().getResource("/cards/yellow4.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage(getClass().getResource("/cards/yellow5.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage(getClass().getResource("/cards/yellow6.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage(getClass().getResource("/cards/yellow7.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage(getClass().getResource("/cards/yellow8.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage(getClass().getResource("/cards/yellow9.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage(getClass().getResource("/cards/yellow+2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage(getClass().getResource("/cards/yellowreverse.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage(getClass().getResource("/cards/yellowskip.PNG"), CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid yellow card number");
            };
            case "green" -> switch (cardNumber) {
                case "0" -> resizeImage(getClass().getResource("/cards/green0.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "1" -> resizeImage(getClass().getResource("/cards/green1.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "2" -> resizeImage(getClass().getResource("/cards/green2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "3" -> resizeImage(getClass().getResource("/cards/green3.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "4" -> resizeImage(getClass().getResource("/cards/green4.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "5" -> resizeImage(getClass().getResource("/cards/green5.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "6" -> resizeImage(getClass().getResource("/cards/green6.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "7" -> resizeImage(getClass().getResource("/cards/green7.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "8" -> resizeImage(getClass().getResource("/cards/green8.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "9" -> resizeImage(getClass().getResource("/cards/green9.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "wild2" -> resizeImage(getClass().getResource("/cards/green+2.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "reverse" -> resizeImage(getClass().getResource("/cards/greenreverse.PNG"), CARD_WIDTH, CARD_HEIGHT);
                case "skip" -> resizeImage(getClass().getResource("/cards/greenskip.PNG"), CARD_WIDTH, CARD_HEIGHT);
                default -> throw new InvalidCardIconNumber("Invalid green card number");
            };
            default -> throw new InvalidColorException();
        };

        currentCardImage.setIcon(new ImageIcon(cardImage));
    }
}
