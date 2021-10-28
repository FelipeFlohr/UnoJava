package com.felipeflohr.uno.swing;

import com.felipeflohr.uno.swing.firstlayer.CenterPanel;
import com.felipeflohr.uno.swing.firstlayer.LeftMenuPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        add(new LeftMenuPanel(), BorderLayout.WEST);
        add(new CenterPanel());

        setTitle("2flps' Uno - Java Edition");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
