/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package PseudoCodeDescriptionContainer.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mac
 */
public class CodeDescriptionModel {

    // define description object 
    private StringProperty descriptionText = new SimpleStringProperty();
    
    public String getDescriptionText() { return descriptionText.get(); }

    public void setDescriptionText(String value) { this.descriptionText.set(value); }
    
    public StringProperty descriptionTextProperty() {return descriptionText; }
    
    
    // define subtitle object 
    private StringProperty subtitleText = new SimpleStringProperty();

    public String getsubtitleText() { return subtitleText.get(); }

    public void setsubtitleText(String value) { this.subtitleText.set(value); }
    
    public StringProperty subtitleTextProperty() {return subtitleText; }


}
