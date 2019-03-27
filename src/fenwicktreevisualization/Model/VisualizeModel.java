package fenwicktreevisualization.Model;

public class VisualizeModel {
    private GraphModel graphModel;
    private Graph graph;
    private Layout layout;

    public VisualizeModel(GraphModel graphModel, Graph graph, Layout layout) {
        this.graphModel = graphModel;
        this.graph = graph;
        this.layout = layout;
    }

    public GraphModel getGraphModel() {
        return graphModel;
    }

    public void setGraphModel(GraphModel graphModel) {
        this.graphModel = graphModel;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
