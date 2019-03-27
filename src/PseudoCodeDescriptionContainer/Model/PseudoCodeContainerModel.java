package PseudoCodeDescriptionContainer.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class PseudoCodeContainerModel {
    private CodeDescriptionModel codeDescriptionModel;
    private PseudoCodeModel pseudoCodeModel;

    public CodeDescriptionModel getCodeDescriptionModel() { return codeDescriptionModel; }

    public PseudoCodeModel getPseudoCodeModel() { return pseudoCodeModel; }

    public void setAbstraction(String description, String subTitle) { 
        this.codeDescriptionModel.setDescriptionText(description);
        this.codeDescriptionModel.setsubtitleText(subTitle);
    }

    public PseudoCodeContainerModel() {
        pseudoCodeModel = new PseudoCodeModel();
        codeDescriptionModel = new CodeDescriptionModel();
    }
    
    
    
}
