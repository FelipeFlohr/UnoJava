package tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResizeImage {

    /**
     * @param imgPath The image's path (can be both relative or absolute)
     * @param w The new image width
     * @param h The new image height
     * @return Returns an Image object rescaled based on the width and height provided
     */
    public static Image resizeImage(String imgPath, int w, int h){
        ImageIcon imageIcon = new ImageIcon(imgPath); // Loads the image as an ImageIcon
        Image image = imageIcon.getImage(); // Transforms it to an Image
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH); // Smoothly transforms it
    }
    
}
