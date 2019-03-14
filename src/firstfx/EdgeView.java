/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import javafx.beans.binding.Bindings;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author ahcl
 */
public class EdgeView extends Group {
    private Line line;
    private NodeView node;
    private NodeView node1;

    public EdgeView() {
    }
    
    private void makeLine() {
        this.line.setStroke(Color.RED);
        // edge will auto repaint whenever a node move
        this.line.startXProperty().bind(Bindings.createDoubleBinding(() -> {
            Bounds b = this.node.getBoundsInParent();
            Bounds b1 = this.node1.getBoundsInParent();
            double x = b.getMinX() + b.getWidth() / 2;
            double y = b.getMinY() + b.getHeight() / 2;
            double x1 = b1.getMinX() + b1.getWidth() / 2;
            double y1 = b1.getMinY() + b1.getHeight() / 2;
            double radius = b.getWidth() / 2;
            Vector2D point1 = new Vector2D(x, y);
            Vector2D point2 = new Vector2D(x1, y1);
            Vector2D vector = point2.sub(point1);
            System.out.println("x: " + Math2DHelper.translate(point1, vector, radius).getX());
            return Math2DHelper.translate(point1, vector, radius).getX();
        }, this.node.boundsInParentProperty(), this.node1.boundsInParentProperty()));
        this.line.startYProperty().bind(Bindings.createDoubleBinding(() -> {
            Bounds b = this.node.getBoundsInParent();
            Bounds b1 = this.node1.getBoundsInParent();
            double x = b.getMinX() + b.getWidth() / 2;
            double y = b.getMinY() + b.getHeight() / 2;
            double x1 = b1.getMinX() + b1.getWidth() / 2;
            double y1 = b1.getMinY() + b1.getHeight() / 2;
            double radius = b.getWidth() / 2;
            Vector2D point1 = new Vector2D(x, y);
            Vector2D point2 = new Vector2D(x1, y1);
            Vector2D vector = point2.sub(point1);
            return Math2DHelper.translate(point1, vector, radius).getY();
        }, this.node.boundsInParentProperty(), this.node1.boundsInParentProperty()));
        this.line.endXProperty().bind(Bindings.createDoubleBinding(() -> {
            Bounds b = this.node.getBoundsInParent();
            Bounds b1 = this.node1.getBoundsInParent();
            double x = b.getMinX() + b.getWidth() / 2;
            double y = b.getMinY() + b.getHeight() / 2;
            double x1 = b1.getMinX() + b1.getWidth() / 2;
            double y1 = b1.getMinY() + b1.getHeight() / 2;
            double radius = b1.getWidth() / 2;
            Vector2D point1 = new Vector2D(x, y);
            Vector2D point2 = new Vector2D(x1, y1);
            Vector2D vector = point1.sub(point2);
            System.out.println("x1: " + Math2DHelper.translate(point2, vector, radius).getX());
            return Math2DHelper.translate(point2, vector, radius).getX();
        }, this.node.boundsInParentProperty(), this.node1.boundsInParentProperty()));
        this.line.endYProperty().bind(Bindings.createDoubleBinding(() -> {
            Bounds b = this.node.getBoundsInParent();
            Bounds b1 = this.node1.getBoundsInParent();
            double x = b.getMinX() + b.getWidth() / 2;
            double y = b.getMinY() + b.getHeight() / 2;
            double x1 = b1.getMinX() + b1.getWidth() / 2;
            double y1 = b1.getMinY() + b1.getHeight() / 2;
            double radius = b1.getWidth() / 2;
            Vector2D point1 = new Vector2D(x, y);
            Vector2D point2 = new Vector2D(x1, y1);
            Vector2D vector = point1.sub(point2);
            return Math2DHelper.translate(point2, vector, radius).getY();
        }, this.node.boundsInParentProperty(), this.node1.boundsInParentProperty()));
    }
    
    public EdgeView(NodeView node, NodeView node1, Line line) {
        super(line);
        this.line = line;
        this.node = node;
        this.node1 = node1;
        makeLine();
    }
    public EdgeView(NodeView node, NodeView node1, Node... nodes) {
        super(nodes);
    }
    
    public EdgeView(NodeView node, NodeView node1) {
        this(node, node1, new Line());
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public NodeView getNode() {
        return node;
    }

    public void setNode(NodeView node) {
        this.node = node;
    }

    public NodeView getNode1() {
        return node1;
    }

    public void setNode1(NodeView node1) {
        this.node1 = node1;
    }
    
}
