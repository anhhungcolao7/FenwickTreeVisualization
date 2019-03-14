/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import java.util.function.Function;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author ahcl
 */
public class FirstFX extends Application {
    
    @Override
    public void start(Stage stage) {
//        FenWickTreeView fenWickTree = new FenWickTreeView(16);
        NodeView node = new NodeView(1);
        NodeView node1 = new NodeView(2);
        NodeView node2 = new NodeView(3);
        node.setLayoutX(100);
        node.setLayoutY(100);
        node1.setLayoutX(100);
        node1.setLayoutY(234);
        node2.setLayoutX(345);
        node2.setLayoutY(456);
//        EdgeView edgeView = new EdgeView(node, node1);
//        EdgeView edgeView1 = new EdgeView(node1, node2);
        DirectionEdgeView directionEdgeView = new DirectionEdgeView(node, node1);
        Button button = new Button("move");
        button.setOnAction(event -> {
            double x = 100;
            double y = 234 + Math.random() * 1000;
            node1.setLayoutX(x);
            node1.setLayoutY(y);
        });
        
        Pane pane = new Pane(node, node1, node2, directionEdgeView, button);
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
