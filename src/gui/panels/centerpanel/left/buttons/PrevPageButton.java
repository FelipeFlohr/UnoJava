package gui.panels.centerpanel.left.buttons;

import functions.GlobalDefs;
import gui.UpdateGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrevPageButton extends JButton implements ActionListener {

    static String buttonText;
    JPanel mainPanel;
    NextPageButton nextPageButton;

    public PrevPageButton(JPanel mainPanel, NextPageButton nextPageButton){
        // Construction
        this.mainPanel = mainPanel;
        this.nextPageButton = nextPageButton;

        // Initializing the Panel
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setFont(new Font("Ubuntu", Font.PLAIN, 20));

        // Enabling and disabling the buttons
        if(GlobalDefs.totalAmountOfPages == 1){
            buttonText = "Previous page 1/1";
            this.setText(buttonText);
            this.setEnabled(false);
        }
        else if(GlobalDefs.currentPage - 1 < 0){
            buttonText = "Previous page 0/"+GlobalDefs.totalAmountOfPages;
            this.setText(buttonText);
            this.setEnabled(false);
        }
        else{
            int nextPage = GlobalDefs.currentPage + 1;
            buttonText = "Previous page "+ nextPage + "/" +GlobalDefs.totalAmountOfPages;
            this.setText(buttonText);
            this.setEnabled(true);
        }

        // Adding it to the main panel
        this.addActionListener(this);
        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GlobalDefs.currentPage -= 1;
        UpdateGUI.updateGUI.updateAllGUI();
    }

}
