package com.felipeflohr.uno.swing.frames;

import com.felipeflohr.uno.swing.frames.mainframefirstlayer.CenterPanel;
import com.felipeflohr.uno.swing.frames.mainframefirstlayer.LeftMenuPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import static com.felipeflohr.uno.tools.ResizeImage.resizeImage;

public class MainFrame extends JFrame {

    public MainFrame() {
        final int WIDTH = 1280;
        final int HEIGHT = 720;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setIconImage(resizeImage("res/cards/+4.PNG", 24, 32));

        add(new LeftMenuPanel(), BorderLayout.WEST);
        add(new CenterPanel(), BorderLayout.CENTER);

        setTitle("2flps' Uno - Java Edition");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
