package gui;

import gui.panels.LeftMenuPanel;
import gui.panels.CenterPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

    final int WIDTH = 1280;
    final int HEIGHT = 720;

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
