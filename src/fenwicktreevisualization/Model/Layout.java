package fenwicktreevisualization.Model;

import fenwicktreevisualization.Common.Constant;
import fenwicktreevisualization.Common.Math2DHelper;
import fenwicktreevisualization.Common.Vector2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Layout {
    private Graph graph;

    public Layout(Graph graph) {
        this.graph = graph;
    }

    private void drawEdge(Edge edge) {
        Line line = edge.getLine();
        line.toBack();
        line.setStrokeWidth(2);
        line.setStroke(Color.GRAY);
        Node firstNode = edge.getFirstNode();
        Node secondNode = edge.getSecondNode();
//        System.out.println(firstNode.localToScene(firstNode.getBoundsInParent()).getMaxY() - 2 * Constant.NODE_RADIUS);
        Vector2D O = new Vector2D(0, 0);
        O.setX(firstNode.localToScene(firstNode.getLayoutBounds()).getMinX() + Constant.NODE_RADIUS);
        O.setY(firstNode.localToScene(firstNode.getLayoutBounds()).getMinY() + Constant.NODE_RADIUS);
        Vector2D O1 = new Vector2D(0, 0);
        O1.setX(secondNode.localToScene(secondNode.getLayoutBounds()).getMinX() + Constant.NODE_RADIUS);
        O1.setY(secondNode.localToScene(secondNode.getLayoutBounds()).getMinY() + Constant.NODE_RADIUS);
        Vector2D vector = O1.sub(O);
        Vector2D startPoint = Math2DHelper.translate(O, vector, Constant.NODE_RADIUS + 15);
        Vector2D endPoint = Math2DHelper.translate(O1, vector.getNegativeVector(), Constant.NODE_RADIUS);
//        startPoint = O;
//        endPoint = O1;
        line.setStartX(startPoint.getX());
        line.setStartY(startPoint.getY());
        line.setEndX(endPoint.getX());
        line.setEndY(endPoint.getY());
    }

    private void drawNodes(List<ValueNode> valueNodes, FenWickTree fenWickTree) {
        List<Integer> currentIndexs = new ArrayList<>(Collections.nCopies(valueNodes.size() + 1, 0));
        List<Integer> numberOfNodeWithHeight = new ArrayList<>(Collections.nCopies(fenWickTree.getMaxHeight() + 1, 0));
        double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 2;
        double WIDTH = Screen.getPrimary().getBounds().getWidth();
        double PADDING = 50;
        for (ValueNode node : valueNodes) {
            int index = node.getIndex();
            int height = fenWickTree.getHeight(index);
            numberOfNodeWithHeight.set(height, numberOfNodeWithHeight.get(height) + 1);
        }
        for (ValueNode valueNode : valueNodes) {
            int index = valueNode.getIndex();
            int height = fenWickTree.getHeight(index);
            currentIndexs.set(height, currentIndexs.get(height) + 1);
            double a = 5;
            double T = numberOfNodeWithHeight.get(height);
            double v0 = (WIDTH - PADDING - T * T * a / 2) / T;
            double t = currentIndexs.get(height) - 1;
            double x = (v0 * t + a * t * t / 2) + PADDING;
            double y = (height - 1) * (HEIGHT / fenWickTree.getMaxHeight()) + PADDING;
            valueNode.setLayoutX(x);
            valueNode.setLayoutY(y);
            valueNode.getNode().getCircle().setFill(Color.LIGHTGOLDENRODYELLOW);
//            node.getCircle().setStroke(Color.GRAY);
            valueNode.getNode().getText().setText(valueNode.getIndex() + "");
            valueNode.getNode().getCircle().setStrokeWidth(2);
            valueNode.getNode().getText().setStyle("-fx-font-size: 17px;");
            valueNode.getTxtValue().setStyle("-fx-font-size: 17px;-fx-font-weight: bold;");
            valueNode.setValue(fenWickTree.getValue(index));
//            valueNode.setValue((new Random()).nextInt(10));
            highlight(valueNode.getNode().getCircle(), Color.BLACK, Color.YELLOW);

            valueNode.toFront();
        }
    }

    public void resetColor() {
        List<ValueNode> valueNodes = this.graph.getGraphModel().getValuesNodes();
        List<Edge> edges = this.graph.getGraphModel().getEdges();
        FenWickTree fenWickTree = this.graph.getGraphModel().getFenWickTree();
        for (ValueNode valueNode : valueNodes) {
//            valueNode.getNode().getCircle().setStroke(Color.BLACK);
            valueNode.setValue(fenWickTree.getValue(valueNode.getIndex()));
            valueNode.getNode().setColor(Color.BLACK);
            valueNode.getNode().getCircle().setFill(Color.YELLOW);
            highlight(valueNode.getTxtValue(), Color.BLACK, Color.BLACK);
        }
        for (Edge edge : edges) {
            edge.getLine().setStroke(Color.GRAY);
        }

    }

    public void update() {
        List<ValueNode> valueNodes = this.graph.getGraphModel().getValuesNodes();
        List<Edge> edges = this.graph.getGraphModel().getEdges();
        drawNodes(valueNodes, this.graph.getGraphModel().getFenWickTree());
        for (Edge edge : edges) {
            drawEdge(edge);
        }
    }

    private Edge findEdge(List<Edge> edges, int index1, int index2) {
        for (Edge e : edges) {
            if (e.getFirstNode().getIndex() == index1 && e.getSecondNode().getIndex() == index2) {
                return e;
            }
            if (e.getFirstNode().getIndex() == index2 && e.getSecondNode().getIndex() == index1) {
                return e;
            }
        }
        return null;
    }

    public void highlight(Shape shape, Paint strokeColor, Paint fillColor) {
        shape.setStroke(strokeColor);
        if (fillColor != null) shape.setFill(fillColor);
    }
    public void highlight(Shape shape, Paint strokeColor) {
        shape.setStroke(strokeColor);
        shape.toFront();
    }

    public void blink(Shape shape, Paint color, int time) {
        Paint defaultColor = shape.getStroke();
        highlight(shape, color);
        sleep(time);
        highlight(shape, defaultColor);
        sleep(time);
        highlight(shape, color);
        sleep(time);
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void blink(Shape shape, Paint strokeColor, Paint fillColor, int time) {
        Paint defaultStrokeColor = shape.getStroke();
        Paint defaultFillColor = shape.getFill();
        highlight(shape, strokeColor, fillColor);
        sleep(time);
        highlight(shape, defaultStrokeColor, defaultFillColor);
        sleep(time);
        highlight(shape, strokeColor, fillColor);
        sleep(time);
    }


    //TODO move all color to Constant interface
    public void doGetAnimation (int index, int currentSum, List<Integer> childs) {
        List<ValueNode> valueNodes = this.graph.getGraphModel().getValuesNodes();
        List<Edge> edges = this.graph.getGraphModel().getEdges();
        blink(valueNodes.get(index - 1).getNode().getCircle(), Color.valueOf("96C42E"), Color.valueOf("FF312E"), 1000);
        FenWickTree fenWickTree = this.graph.getGraphModel().getFenWickTree();

        for(int u:childs) {
            if (u!=index) {
                highlight(valueNodes.get(u-1).getNode().getCircle(), Color.BLACK, Color.valueOf("FFB4B3"));
                highlight(findEdge(edges, u, fenWickTree.getParent(u)).getLine(), Color.BLUE);
            }
        }
        sleep(1000);
    }

    public void doUpdateAnimation(int lastIndex, int index, int value, int newValue) {
        List<ValueNode> valueNodes = this.graph.getGraphModel().getValuesNodes();
        List<Edge> edges = this.graph.getGraphModel().getEdges();
        if (lastIndex > 0) {
            Edge e = findEdge(edges, lastIndex, index);
            highlight(e.getLine(), Color.BLUE);
            sleep(1000);
        }
        highlight(valueNodes.get(index - 1).getNode().getCircle(), Color.valueOf("96C42E"), Color.valueOf("FF312E"));
        sleep(1000);
        valueNodes.get(index - 1).getTxtValue().setText(valueNodes.get(index - 1).getValue() + " + ( " + value + " )= " + newValue);
        highlight(valueNodes.get(index - 1).getTxtValue(), Color.valueOf("10A73A"), Color.valueOf("10A73A"));
        sleep(1000);
    }
}
