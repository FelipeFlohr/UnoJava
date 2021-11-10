package com.felipeflohr.unojava.swing.frames.colorselectorframe;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;

import static com.felipeflohr.unojava.globaldefs.GlobalDefinitions.getTable;

public class SelectColorDialog extends JDialog {

    public SelectColorDialog() {
        JPanel contentPane = new JPanel();
        JButton yellowBtn = new JButton("Yellow");
        JButton blueBtn = new JButton("Blue");
        JButton greenBtn = new JButton("Green");
        JButton redBtn = new JButton("Red");

        yellowBtn.setForeground(new Color(190, 168, 9));
        blueBtn.setForeground(new Color(64, 64, 229));
        greenBtn.setForeground(new Color(24, 178, 24));
        redBtn.setForeground(new Color(253, 43, 43));

        contentPane.add(blueBtn);
        contentPane.add(greenBtn);
        contentPane.add(redBtn);
        contentPane.add(yellowBtn);

        setTitle("Pick your color:");
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(null);
        blueBtn.addActionListener(e -> {
            getTable().setColorSelected("blue");
            dispose();
        });
        greenBtn.addActionListener(e -> {
            getTable().setColorSelected("green");
            dispose();
        });
        redBtn.addActionListener(e -> {
            getTable().setColorSelected("red");
            dispose();
        });
        yellowBtn.addActionListener(e -> {
            getTable().setColorSelected("yellow");
            dispose();
        });
    }
}
