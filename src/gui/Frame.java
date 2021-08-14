package gui;

import gui.panels.LeftMenuPanel;
import gui.panels.CenterPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The main frame of the game.
 * @author Felipe Flohr
 */
public class Frame extends JFrame {

    /**
     * Constant that holds the width size of the window.
     */
    final int WIDTH = 1280;
    /**
     * Constant that holds the height size of the window.
     */
    final int HEIGHT = 720;

    /**
     * Constructor for the class. Holds values related to the behaviour of the window
     */
    public Frame(){
        
        // Initial setup for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(new BorderLayout());

        // Implementing the panels
        new LeftMenuPanel(this);
        new CenterPanel(this);

        // Final setup for the frame
        this.setTitle("Uno - Java Edition");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
