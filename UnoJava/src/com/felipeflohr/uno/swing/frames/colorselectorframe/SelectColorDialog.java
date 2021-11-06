package com.felipeflohr.uno.swing.frames.colorselectorframe;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.felipeflohr.uno.globaldefs.GlobalDefinitions.getTable;

public class SelectColorDialog extends JDialog {
    private JPanel contentPane;
    private JButton yellowBtn;
    private JButton blueBtn;
    private JButton greenBtn;
    private JButton redBtn;
    private JButton buttonOK;

    public SelectColorDialog() {
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(null);
        blueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTable().setColorSelected("blue");
                dispose();
            }
        });
        greenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTable().setColorSelected("green");
                dispose();
            }
        });
        redBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTable().setColorSelected("red");
                dispose();
            }
        });
        yellowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTable().setColorSelected("yellow");
                dispose();
            }
        });
    }
}
