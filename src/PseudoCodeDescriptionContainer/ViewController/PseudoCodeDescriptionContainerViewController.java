package PseudoCodeDescriptionContainer.ViewController;

import PseudoCodeDescriptionContainer.Model.PseudoCodeContainerModel;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class PseudoCodeDescriptionContainerViewController extends VBox {

    private PseudoCodeContainerModel pseudoCodeContainerAbstraction;
    
    private CodeDescriptionViewController codeDescriptionViewController;
    private PseudoCodeViewController pseudoCodeViewController;
    
    // set model
    public void settModel(String description, String subTitle, int selectedId){
//        codeDescriptionModel.setDescriptionText(description);
//        codeDescriptionModel.setsubtitleText(subTitle);
        pseudoCodeContainerAbstraction.setAbstraction(description, subTitle);
        
        pseudoCodeViewController.setHightlight(selectedId);
    }
    public void settModel(String description, String subTitle){
//        codeDescriptionModel.setDescriptionText(description);
//        codeDescriptionModel.setsubtitleText(subTitle);
        pseudoCodeContainerAbstraction.setAbstraction(description, subTitle);

    }
 
    public PseudoCodeDescriptionContainerViewController() {
        this.setPadding(new Insets(30, Screen.getPrimary().getBounds().getWidth() / 2 - 100, 30, 30));
        // define model
        pseudoCodeContainerAbstraction = new PseudoCodeContainerModel();
//        pseudoCodeModel = new PseudoCodeModel();
//        codeDescriptionModel = new CodeDescriptionModel();

        // define viewController 
        codeDescriptionViewController = new CodeDescriptionViewController(this.pseudoCodeContainerAbstraction.getCodeDescriptionModel());
        pseudoCodeViewController = new PseudoCodeViewController(this.pseudoCodeContainerAbstraction.getPseudoCodeModel());
        
        getChildren().add(codeDescriptionViewController);
        getChildren().add(pseudoCodeViewController);

        
    }

   

}
