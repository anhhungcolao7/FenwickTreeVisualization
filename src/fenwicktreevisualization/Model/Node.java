/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization.Model;

import fenwicktreevisualization.Common.Constant;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author ahcl
 */
public class Node extends StackPane {
    public static final double radius = 20;
    private Circle circle;
    private Text text;
    private int index;
    public Node() {
        this(new Circle(Constant.NODE_RADIUS), new Text());
    }

    public Node(int index) {
        this(new Circle(Constant.NODE_RADIUS), new Text());
        this.index = index;
    }

    public Node(Circle circle, Text text) {
        super(circle, text);
        this.circle = circle;
        this.text = text;
    }

    public static double getRadius() {
        return radius;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setColor(Color color) {
        this.circle.setStroke(color);
        this.text.setStroke(color);
    }
}
