package com.felipeflohr.uno.tools;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ResizeImage {

    public static Image resizeImage(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

}
