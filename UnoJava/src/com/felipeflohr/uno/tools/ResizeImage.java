package com.felipeflohr.uno.tools;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ResizeImage {

    public static Image resizeImage(String imagePath, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }

}
