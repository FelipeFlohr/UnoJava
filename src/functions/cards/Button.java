package functions.cards;

import javax.swing.*;

public class Button extends JButton {

    JPanel mainPanel;

    public Button(JPanel mainPanel){
        this.mainPanel = mainPanel;

        this.setFocusable(false);
        this.setContentAreaFilled(false);
    }

}
