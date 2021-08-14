package gui;

import functions.GlobalDefs;
import gui.panels.centerpanel.CenterLeftPanel;
import gui.panels.centerpanel.left.BottomCenterLeftPanel;
import gui.panels.centerpanel.left.CenterCenterLeftPanel;
import gui.panels.centerpanel.left.buttons.NextPageButton;
import gui.panels.centerpanel.left.buttons.PrevPageButton;
import gui.panels.centerpanel.left.label.BottomCenterLeftLabel;

import javax.swing.*;

import static gui.panels.centerpanel.left.CenterCenterLeftPanel.renderCard;

/**
 * @author Felipe Flohr
 * The class responsible for updating the GUI
 */
public class UpdateGUI {

    NextPageButton nextPageButton;
    PrevPageButton prevPageButton;
    BottomCenterLeftLabel currentPageLabel;
    JPanel buttonsPanel;

    /**
     * @param nextPageButton The next page button
     * @param prevPageButton The previous page button
     * @param currentPageLabel The label that shows the current page
     * @param buttonsPanel The panel where the buttons are placed within
     */
    UpdateGUI(NextPageButton nextPageButton, PrevPageButton prevPageButton, BottomCenterLeftLabel currentPageLabel, JPanel buttonsPanel){
        this.nextPageButton = nextPageButton;
        this.prevPageButton = prevPageButton;
        this.currentPageLabel = currentPageLabel;
        this.buttonsPanel = buttonsPanel;
    }

    /**
     * Method responsible for updating all the GUI. No params are needed
     */
    public void updateAllGUI(){
        updateButtons(this.buttonsPanel);
        updatePrevPageButton(this.prevPageButton);
        updateNextPageButton(this.nextPageButton);
        updateCurrentPageLabel(this.currentPageLabel);
    }

    /**
     * A static variable for holding a "UpdateGUI" class. Useful for updating the GUI
     * in other classes
     */
    public static UpdateGUI updateGUI = new UpdateGUI(BottomCenterLeftPanel.nextButton,
                                                     BottomCenterLeftPanel.prevButton,
                                                     BottomCenterLeftPanel.currentPageLabel,
                                                     CenterLeftPanel.centerLeftPanel);

    /**
     * Updates the next page button
     * @param nextPageButton The next page button
     */
    public static void updateNextPageButton(NextPageButton nextPageButton){
        if(GlobalDefs.totalAmountOfPages == 1){
            String buttonText = "Next page 1/1";
            nextPageButton.setText(buttonText);
            nextPageButton.setEnabled(false);
        }
        else if(GlobalDefs.totalAmountOfPages - 1 == GlobalDefs.currentPage){
            int nextPage = GlobalDefs.currentPage + 2;
            String buttonText = "Next page "+ nextPage +"/"+GlobalDefs.totalAmountOfPages;
            nextPageButton.setText(buttonText);
            nextPageButton.setEnabled(false);
        }
        else{
            int nextPage = GlobalDefs.currentPage + 2;
            String buttonText = "Next page "+ nextPage + "/" +GlobalDefs.totalAmountOfPages;
            nextPageButton.setText(buttonText);
            nextPageButton.setEnabled(true);
        }
    }

    /**
     * Updates the previous page button
     * @param prevPageButton The previous page button
     */
    public static void updatePrevPageButton(PrevPageButton prevPageButton){
        String buttonText;
        if(GlobalDefs.totalAmountOfPages == 1){
            buttonText = "Previous page 1/1";
            prevPageButton.setText(buttonText);
            prevPageButton.setEnabled(false);
        }
        else if(GlobalDefs.currentPage - 1 < 0){
            int prevPage = GlobalDefs.currentPage ;
            buttonText = "Previous page "+ prevPage +"/"+GlobalDefs.totalAmountOfPages;
            prevPageButton.setText(buttonText);
            prevPageButton.setEnabled(false);
        }
        else{
            int prevPage = GlobalDefs.currentPage ;
            buttonText = "Previous page "+ prevPage + "/" +GlobalDefs.totalAmountOfPages;
            prevPageButton.setText(buttonText);
            prevPageButton.setEnabled(true);
        }
    }

    /**
     * Updates the label which displays the current page
     * @param currentPageLabel label where displays the current page
     */
    public static void updateCurrentPageLabel(BottomCenterLeftLabel currentPageLabel){
        int currentPage = GlobalDefs.currentPage + 1;
        String text = "Current page: "+currentPage;
        currentPageLabel.setText(text);
    }

    /**
     * Updates all buttons inside the button's label
     * @param buttonsPanel Label where the buttons will be placed
     */
    public static void updateButtons(JPanel buttonsPanel){
        // Remove section
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button1);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button2);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button3);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button4);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button5);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button6);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button7);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button8);
        } catch(NullPointerException ignored) {

        }
        try{
            buttonsPanel.remove(CenterCenterLeftPanel.button9);
        } catch(NullPointerException ignored) {

        }

        // Adding section
        CenterCenterLeftPanel.button1 = renderCard(buttonsPanel,0);
        CenterCenterLeftPanel.button2 = renderCard(buttonsPanel,1);
        CenterCenterLeftPanel.button3 = renderCard(buttonsPanel,2);
        CenterCenterLeftPanel.button4 = renderCard(buttonsPanel,3);
        CenterCenterLeftPanel.button5 = renderCard(buttonsPanel,4);
        CenterCenterLeftPanel.button6 = renderCard(buttonsPanel,5);
        CenterCenterLeftPanel.button7 = renderCard(buttonsPanel,6);
        CenterCenterLeftPanel.button8 = renderCard(buttonsPanel,7);
        CenterCenterLeftPanel.button9 = renderCard(buttonsPanel,8);
    }

}
