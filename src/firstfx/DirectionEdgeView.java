/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;


/**
 *
 * @author ahcl
 */
public class DirectionEdgeView extends EdgeView{
    private Polygon arrow;
    final double ANGLE = 30;
    final double HEAD_LENGHT = 10;
    public DirectionEdgeView () {
        
    }

    public DirectionEdgeView(NodeView node, NodeView node1) {
        this(new Polygon(
            0f, 0f,
            0f, 0f,
            0f, 0f
        ), node, node1);
    }
    
    private void makeArrow () {
        double t = 100f;
        ObservableList<Double> points = this.arrow.getPoints();
        for(int i=0;i<this.arrow.getPoints().size(); i++) {
            int index = i;
            DoubleProperty xProperty = new SimpleDoubleProperty(points.get(i));
            xProperty.bind(Bindings.createDoubleBinding(() -> {
                double x = this.getLine().getStartX();
                double y = this.getLine().getStartY();
                double x1 = this.getLine().getEndX();
                double y1 = this.getLine().getEndY();
                Vector2D A = new Vector2D(x, y);
                Vector2D B = new Vector2D(x1, y1);
                Vector2D BA = A.sub(B);
                double d = HEAD_LENGHT * Math.cos(ANGLE / 180 * Math.PI);
                Vector2D O = Math2DHelper.translate(B, BA, d);
                double d1 = HEAD_LENGHT * Math.sin(ANGLE / 180 * Math.PI);
                Vector2D OC = BA.getPerpendicularVector();
                Vector2D P1 = Math2DHelper.translate(O, OC, d1);
                Vector2D CO = OC.getNegativeVector();
                Vector2D P2 = Math2DHelper.translate(O, CO, d1);
                double [] triangle = {B.getX(), B.getY(), P1.getX(), P1.getY(), P2.getX(), P2.getY()};
                System.out.println(triangle[index]);
                return triangle[index];
            }, this.getLine().startXProperty(), this.getLine().startYProperty(), this.getLine().endXProperty(), this.getLine().endYProperty()));
            xProperty.addListener((ov, oldX, x) -> {
                points.set(index, (double) x);
            });
        }

    }
    public DirectionEdgeView (Polygon arrow, NodeView node, NodeView node1) {
        super(node, node1);
        this.arrow = arrow;
        this.getChildren().add(arrow);
        makeArrow();
        
    }
    
}
