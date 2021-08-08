package tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResizeImage {

    public static Image resizeImage(String imgPath, int w, int h){
        ImageIcon imageIcon = new ImageIcon(imgPath); // Loads the image as an ImageIcon
        Image image = imageIcon.getImage(); // Transforms it to an Image
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH); // Smoothly transforms it
    }
    
}
