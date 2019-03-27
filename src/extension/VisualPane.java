/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extension;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahcl
 */
public class VisualPane extends Group {
    private List<Rectangle> list;
    final int WIDTH = 20;
    final int HEIGHT = 10;
    public VisualPane() {
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

//    @Override
//    public ObservableList<Node> getChildren() {
//        return FXCollections.observableArrayList(this.list);
//    }
}
