/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization;

import fenwicktreevisualization.Controller.Control;
import fenwicktreevisualization.Model.Graph;
import fenwicktreevisualization.Model.GraphModel;
import fenwicktreevisualization.Model.Layout;
import fenwicktreevisualization.Model.VisualizeModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author ahcl
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GraphModel graphModel = new GraphModel();
        Graph graph = new Graph(graphModel);
        graphModel.initGraph();
        graph.update();
        BorderPane root = new BorderPane();
        root.setTop(graph.getContentPane());
        Layout layout = new Layout(graph);
        layout.update();
        Control controls = new Control(new VisualizeModel(graphModel, graph, layout));
        controls.initComponents();
        root.setLeft(controls);
        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
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
