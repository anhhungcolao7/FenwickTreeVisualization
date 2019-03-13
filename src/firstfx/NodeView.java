/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

/**
 *
 * @author ahcl
 */
public class NodeView extends StackPane {
    public static final double radius = 20;
    private Circle circle;
    private Text text;
    private int index;
    public NodeView(int index) {
        this.circle = new Circle(index * radius * 2, 100, radius);
        this.circle.setFill(Color.WHITE);
        this.circle.setStroke(Color.AQUA);
        this.text = new Text(index + "");
        text.setBoundsType(TextBoundsType.VISUAL);
        this.getChildren().addAll(circle, text);
        this.setOnDragDetected(event -> {
            System.out.println("On Drag detected!");
            Dragboard db = this.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString("asdf");
                db.setContent(content);
                
                event.consume();
        });
        
        // Event when drag a Node view
        
//        this.setOnMousePressed(event -> {
//        });
//        this.setOnMouseReleased(event -> {
//        });
//        this.setOnDragDetected(event -> {
//        });
    }
}
