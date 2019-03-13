/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

/**
 *
 * @author ahcl
 */
public class VisualPane extends Group {
    private List<Rectangle> list;
    final int WIDTH = 20;
    final int HEIGHT = 10;
    public VisualPane() {
        Scale scale = new Scale();
        int n = 10;
        list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            Rectangle rec = new Rectangle(i * WIDTH, 0, WIDTH, i * HEIGHT);
            rec.setFill(Color.YELLOW);
            rec.setStroke(Color.AQUA);
            list.add(rec);
            this.getChildren().add(rec);
        }
    }
    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= list.size() || secondIndex >=list.size()) return;
        // do swap bar have firstIndex and secondIndex
        // using javafx animation, swap 2 bar in list
    }
    
    
}