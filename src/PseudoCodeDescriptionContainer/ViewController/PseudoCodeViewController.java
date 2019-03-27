/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PseudoCodeDescriptionContainer.ViewController;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import PseudoCodeDescriptionContainer.Model.PseudoCodeModel;

import static Constant.Constant.*;


/**
 *
 * @author mac
 */
public class PseudoCodeViewController extends VBox {

    private PseudoCodeModel pseudoCodeModel;
    private Pane[] panes;
    private Label[] labels;
    private int prev = -1; // prev present for Id of array that this index is selected previously

    public PseudoCodeViewController(PseudoCodeModel pseudoCodeModel) {
        this.pseudoCodeModel = pseudoCodeModel;
        initPaneView();
    }
    
    private void initPaneView(){
        panes = new Pane[QUICKSORT_PSEUDO_CODE.length];
        labels = new Label[QUICKSORT_PSEUDO_CODE.length];
        
        for (int i=0; i<QUICKSORT_PSEUDO_CODE.length; i++){
            labels[i] = new Label(QUICKSORT_PSEUDO_CODE[i]);
            setupLabelInContainer(labels[i]);
            panes[i] = new Pane();
            panes[i].getChildren().add(labels[i]);
            getChildren().add(panes[i]);
        }
        
        this.setPadding(new Insets(15, 0, 15, 0));
        this.setSpacing(5);
        this.setBackground(new Background(new BackgroundFill(Color.web(COLOR_PSEUDOCODE_VIEW_BACKGROUND), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
     protected void setupLabelInContainer(Label label) {
        
        label.setTextFill(Color.valueOf(COLOR_PSEUDOCODE_TEXT_PSEUDOCODE_CONTAINER));
        //label.setFont(new Font(FONT_PSEUDOCODE_CONTAINER_TEXT, SIZE_PSEUDOCODE_CONTAINER_TEXT));
//        label.setMinWidth(Region.USE_PREF_SIZE);
    }
    
    public void setHightlight(int newId){
        int id = QUICKSORT_PSEUDO_CODE_ARRAY_DEFINE[newId];
        if (prev != -1){
            undoSelectedHightlight(prev);
        }
        setSelectedHightlight(id);
        prev = id;
    }
    
    private void undoSelectedHightlight(int id){
        panes[id].setBackground(Background.EMPTY);
        labels[id].setTextFill(Color.valueOf(COLOR_PSEUDOCODE_TEXT_PSEUDOCODE_CONTAINER));
    }
    
    private void setSelectedHightlight(int id){
        panes[id].setBackground(new Background(new BackgroundFill(Color.web(COLOR_SELECTED_PSEUDOCODE_VIEW_BACKGROUND), CornerRadii.EMPTY, Insets.EMPTY)));
        labels[id].setTextFill(Color.valueOf(COLOR_SELECTED_PSEUDOCODE_TEXT_PSEUDOCODE_CONTAINER));
    }

    
    
}
