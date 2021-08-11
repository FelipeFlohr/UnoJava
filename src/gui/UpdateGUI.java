package gui;

import functions.GlobalDefs;
import gui.panels.centerpanel.left.BottomCenterLeftPanel;
import gui.panels.centerpanel.left.buttons.NextPageButton;
import gui.panels.centerpanel.left.buttons.PrevPageButton;
import gui.panels.centerpanel.left.label.BottomCenterLeftLabel;

public class UpdateGUI {

    NextPageButton nextPageButton;
    PrevPageButton prevPageButton;
    BottomCenterLeftLabel currentPageLabel;

    UpdateGUI(NextPageButton nextPageButton, PrevPageButton prevPageButton, BottomCenterLeftLabel currentPageLabel){
        this.nextPageButton = nextPageButton;
        this.prevPageButton = prevPageButton;
        this.currentPageLabel = currentPageLabel;
    }

    public void updateAllGUI(){
        updatePrevPageButton(this.prevPageButton);
        updateNextPageButton(this.nextPageButton);
        updateCurrentPageLabel(this.currentPageLabel);
    }

    public static UpdateGUI updateGUI = new UpdateGUI(BottomCenterLeftPanel.nextButton,
                                                     BottomCenterLeftPanel.prevButton,
                                                     BottomCenterLeftPanel.currentPageLabel);

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

    public static void updateCurrentPageLabel(BottomCenterLeftLabel currentPageLabel){
        int currentPage = GlobalDefs.currentPage + 1;
        String text = "Current page: "+currentPage;
        currentPageLabel.setText(text);
    }

}
