package com.felipeflohr.uno.swing.frames.colorselectorframe;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectColorFrame extends JDialog {
    private JPanel contentPane;
    private JButton GreenButton;
    private JButton BlueButton;
    private JButton RedButton;
    private JButton YellowButton;
    private JButton buttonOK;

    public SelectColorFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

}
