/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.Group;

/**
 *
 * @author ahcl
 */
public class FenWickTreeView extends Group {
    private int n;
    private List<NodeView> list;
    public FenWickTreeView(int n) {
        this.n = n;
        Tree tree = new Tree(n);
        tree.buildTree();
        this.list = new ArrayList<>();
        List<NodeView> list1[] = new ArrayList[10];
        for(int i=0;i<10;i++) list1[i] = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            NodeView nodeView = new NodeView(i);
            list1[tree.getHeight(i)].add(nodeView);
        }
        for(int i=0;i<10;i++) {
            for(int j=0;j<list1[i].size();j++) {
                NodeView view = list1[i].get(j);
                view.setLayoutX((j+1) * 45);
                view.setLayoutY((i+1) * 45);
                this.getChildren().add(view);
            }
        }
    }
    
}
