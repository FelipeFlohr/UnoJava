package gui;

import gui.panels.LeftPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

    final int WIDTH = 1024;
    final int HEIGHT = 768;

    public Frame(){
        
        // Initial setup for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(new BorderLayout(10, 10));

        new LeftPanel(this);

        // Final setup for the frame
        this.setTitle("Uno - Java Edition");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
