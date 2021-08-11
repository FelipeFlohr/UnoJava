package gui.panels.centerpanel.left;

import gui.panels.centerpanel.left.buttons.NextPageButton;
import gui.panels.centerpanel.left.buttons.PrevPageButton;
import gui.panels.centerpanel.left.label.BottomCenterLeftLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BottomCenterLeftPanel extends JPanel {
    JPanel panelMain;
    public static NextPageButton nextButton;
    public static BottomCenterLeftLabel currentPageLabel;
    public static PrevPageButton prevButton;

    public BottomCenterLeftPanel(JPanel panelMain){
        // Initializing Panel
        this.panelMain = panelMain;
        this.setPreferredSize(new Dimension(10, 50));
        this.setLayout(new GridLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);

        // Creating buttons for this panel
        JButton previousPageButton = new JButton("Previous page");
        JButton nextPageButton = new JButton("Next page");

        previousPageButton.setBorder(new LineBorder(Color.BLACK));
        nextPageButton.setBorder(new LineBorder(Color.BLACK));

        previousPageButton.setBackground(Color.GRAY);
        nextPageButton.setBackground(Color.GRAY);

        previousPageButton.setForeground(Color.WHITE);
        nextPageButton.setForeground(Color.WHITE);

        previousPageButton.setFocusable(false);
        nextPageButton.setFocusable(false);

        // Adding components to this panel
        prevButton = new PrevPageButton(this, nextButton);
        currentPageLabel = new BottomCenterLeftLabel(this);
        nextButton = new NextPageButton(this, prevButton);

        // Adding component to main panel
        panelMain.add(this, BorderLayout.SOUTH);
    }
}
