package com.felipeflohr.unojava.tools;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class ResizeImage {

    /**
     * Resizes an image according to the specified parameters. Method created by Thomas Pummer.
     * Taken from: https://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/
     *
     * @param imageURL The URL of the image
     * @param width The width you want the image to be
     * @param height The height you want the image to be
     * @return the image smoothly resized according to the width x height parameters
     * @author Thomas Pummer
     */
    public static Image resizeImage(URL imageURL, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imageURL);
        Image image = imageIcon.getImage();
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

}
