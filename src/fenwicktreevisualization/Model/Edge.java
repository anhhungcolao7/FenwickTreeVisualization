/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization.Model;

import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 *
 * @author ahcl
 */
public class Edge extends Group {
    private Line line;
    private Node firstNode;
    private Node secondNode;

    public Edge() {
    }
    
//    private void makeLine() {
//        this.line.setStroke(Color.RED);
        // edge will auto repaint whenever a firstNode move
//        this.line.startXProperty().bind(Bindings.createDoubleBinding(() -> {
//            Bounds b = this.firstNode.getBoundsInParent();
//            Bounds b1 = this.secondNode.getBoundsInParent();
//            double x = b.getMinX() + b.getWidth() / 2;
//            double y = b.getMinY() + b.getHeight() / 2;
//            double x1 = b1.getMinX() + b1.getWidth() / 2;
//            double y1 = b1.getMinY() + b1.getHeight() / 2;
//            double radius = b.getWidth() / 2;
//            Vector2D point1 = new Vector2D(x, y);
//            Vector2D point2 = new Vector2D(x1, y1);
//            Vector2D vector = point2.sub(point1);
//            System.out.println("x: " + Math2DHelper.translate(point1, vector, radius).getX());
//            return Math2DHelper.translate(point1, vector, radius).getX();
//        }, this.firstNode.boundsInParentProperty(), this.secondNode.boundsInParentProperty()));
//        this.line.startYProperty().bind(Bindings.createDoubleBinding(() -> {
//            Bounds b = this.firstNode.getBoundsInParent();
//            Bounds b1 = this.secondNode.getBoundsInParent();
//            double x = b.getMinX() + b.getWidth() / 2;
//            double y = b.getMinY() + b.getHeight() / 2;
//            double x1 = b1.getMinX() + b1.getWidth() / 2;
//            double y1 = b1.getMinY() + b1.getHeight() / 2;
//            double radius = b.getWidth() / 2;
//            Vector2D point1 = new Vector2D(x, y);
//            Vector2D point2 = new Vector2D(x1, y1);
//            Vector2D vector = point2.sub(point1);
//            return Math2DHelper.translate(point1, vector, radius).getY();
//        }, this.firstNode.boundsInParentProperty(), this.secondNode.boundsInParentProperty()));
//        this.line.endXProperty().bind(Bindings.createDoubleBinding(() -> {
//            Bounds b = this.firstNode.getBoundsInParent();
//            Bounds b1 = this.secondNode.getBoundsInParent();
//            double x = b.getMinX() + b.getWidth() / 2;
//            double y = b.getMinY() + b.getHeight() / 2;
//            double x1 = b1.getMinX() + b1.getWidth() / 2;
//            double y1 = b1.getMinY() + b1.getHeight() / 2;
//            double radius = b1.getWidth() / 2;
//            Vector2D point1 = new Vector2D(x, y);
//            Vector2D point2 = new Vector2D(x1, y1);
//            Vector2D vector = point1.sub(point2);
//            System.out.println("x1: " + Math2DHelper.translate(point2, vector, radius).getX());
//            return Math2DHelper.translate(point2, vector, radius).getX();
//        }, this.firstNode.boundsInParentProperty(), this.secondNode.boundsInParentProperty()));
//        this.line.endYProperty().bind(Bindings.createDoubleBinding(() -> {
//            Bounds b = this.firstNode.getBoundsInParent();
//            Bounds b1 = this.secondNode.getBoundsInParent();
//            double x = b.getMinX() + b.getWidth() / 2;
//            double y = b.getMinY() + b.getHeight() / 2;
//            double x1 = b1.getMinX() + b1.getWidth() / 2;
//            double y1 = b1.getMinY() + b1.getHeight() / 2;
//            double radius = b1.getWidth() / 2;
//            Vector2D point1 = new Vector2D(x, y);
//            Vector2D point2 = new Vector2D(x1, y1);
//            Vector2D vector = point1.sub(point2);
//            return Math2DHelper.translate(point2, vector, radius).getY();
//        }, this.firstNode.boundsInParentProperty(), this.secondNode.boundsInParentProperty()));
//    }
    
    public Edge(Node firstNode, Node secondNode, Line line) {
        super(line);
        this.line = line;
        this.firstNode = firstNode;
        this.secondNode = secondNode;
//        makeLine();
    }
//    public Edge(Node firstNode, Node secondNode, Node... nodes) {
//        super(nodes);
//    }
    
    public Edge(Node firstNode, Node secondNode) {
        this(firstNode, secondNode, new Line());
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(Node secondNode) {
        this.secondNode = secondNode;
    }
    
}
