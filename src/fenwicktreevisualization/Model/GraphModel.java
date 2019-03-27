package fenwicktreevisualization.Model;

import java.util.ArrayList;
import java.util.List;


//TODO rename to GraphModel
public class GraphModel {

    private FenWickTree fenWickTree;
    private List<ValueNode> valuesNodes;
    private List<Edge> edges;

    public GraphModel() {
        this(0);
    }
    public GraphModel(int numbersOfNode) {
        this.fenWickTree = new FenWickTree(numbersOfNode);
        this.fenWickTree.buildTree();
        this.valuesNodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void update(int numbersOfNode) {
        this.fenWickTree = new FenWickTree(numbersOfNode);
        this.fenWickTree.buildTree();
        this.valuesNodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        initGraph();
    }

    public void addNode(ValueNode node) {
        this.valuesNodes.add(node);
    }

    private void addEdge(Node firstNode, Node secondNode) {
        this.edges.add(new Edge(firstNode, secondNode));
    }

    public void initGraph() {
        //TODO init graph
        for (int i = 1; i < fenWickTree.getNumberOfNode() + 1; i++) this.addNode(new ValueNode(i, fenWickTree.getValue(i)));


        for (int i = 1; i <= fenWickTree.getNumberOfNode(); i++) {
            int parent = i + (i & -i);
            if (parent <= fenWickTree.getNumberOfNode()) this.addEdge(valuesNodes.get(i - 1).getNode(), valuesNodes.get(parent - 1).getNode());
        }
    }

    public List<ValueNode> getValuesNodes() {
        return valuesNodes;
    }

    public void setValuesNodes(List<ValueNode> valuesNodes) {
        this.valuesNodes = valuesNodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public FenWickTree getFenWickTree() {
        return fenWickTree;
    }

    public void setFenWickTree(FenWickTree fenWickTree) {
        this.fenWickTree = fenWickTree;
    }
}
