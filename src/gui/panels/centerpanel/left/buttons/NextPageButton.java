package gui.panels.centerpanel.left.buttons;

import functions.GlobalDefs;
import gui.UpdateGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextPageButton extends JButton implements ActionListener {

    static String buttonText;
    JPanel mainPanel;
    PrevPageButton prevPageButton;

    public NextPageButton(JPanel mainPanel, PrevPageButton prevPageButton){
        // Construction
        this.mainPanel = mainPanel;
        this.prevPageButton = prevPageButton;

        // Initializing the Panel
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setFont(new Font("Ubuntu", Font.PLAIN, 20));

        // Enabling and disabling the buttons
        if(GlobalDefs.totalAmountOfPages == 1){
            buttonText = "Next page 1/1";
            this.setText(buttonText);
            this.setEnabled(false);
        }
        else if(GlobalDefs.totalAmountOfPages == GlobalDefs.currentPage){
            buttonText = "Next page "+GlobalDefs.currentPage+"/"+GlobalDefs.totalAmountOfPages;
            this.setText(buttonText);
            this.setEnabled(false);
        }
        else{
            int nextPage = GlobalDefs.currentPage + 2;
            buttonText = "Next page "+ nextPage + "/" +GlobalDefs.totalAmountOfPages;
            this.setText(buttonText);
            this.setEnabled(true);
        }

        // Adding it to the main panel
        this.addActionListener(this);
        mainPanel.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GlobalDefs.currentPage += 1;
        UpdateGUI.updateGUI.updateAllGUI();
    }

}
