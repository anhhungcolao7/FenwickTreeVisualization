package fenwicktreevisualization.Model;

import javafx.scene.layout.Pane;

import java.util.List;

public class Graph {
    private Pane contentPane;
    private GraphModel graphModel;
    public Graph(GraphModel graphModel) {
        this.contentPane = new Pane();
        this.graphModel = graphModel;
    }

    public void update() {
        this.getContentPane().getChildren().clear();
        List<ValueNode> nodes = this.graphModel.getValuesNodes();
        List<Edge> edges = this.graphModel.getEdges();
        this.getContentPane().getChildren().addAll(nodes);
        this.getContentPane().getChildren().addAll(edges);
    }



    public Pane getContentPane() {
        return this.contentPane;
    }

    public GraphModel getGraphModel() {
        return graphModel;
    }

    public void setGraphModel(GraphModel graphModel) {
        this.graphModel = graphModel;
    }

}
