/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PseudoCodeDescriptionContainerX.Model;

import java.util.Vector;

/**
 *
 * @author mac
 */
public class PseudoCodeModel {
    private Vector pseudoCodeList;

    public void addPseudoLineCode(String lineCode) {
        this.pseudoCodeList.add(lineCode);
    }
    
}
