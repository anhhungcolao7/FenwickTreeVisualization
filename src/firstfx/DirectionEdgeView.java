/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

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
        this(new Polygon(), node, node1);
    }
    
    private void makeArrow () {
        
        double x = this.getLine().getStartX();
        double y = this.getLine().getStartY();
        double x1 = this.getLine().getEndX();
        double y1 = this.getLine().getEndY();
        Vector2D A = new Vector2D(x, y);
        Vector2D B = new Vector2D(x1, y1);
        this.getChildren().add(new Line(x,y,x1,y1));
        Vector2D BA = A.sub(B);
        System.out.println(BA);
        double d = HEAD_LENGHT * Math.cos(ANGLE / 180 * Math.PI);
        Vector2D O = Math2DHelper.translate(B, BA, d);
        double d1 = HEAD_LENGHT * Math.sin(ANGLE / 180 * Math.PI);
        Vector2D OC = BA.getPerpendicularVector();
        System.out.println(OC);
        Vector2D P1 = Math2DHelper.translate(O, OC, d1);
        Vector2D CO = OC.getNegativeVector();
        System.out.println(CO);
        Vector2D P2 = Math2DHelper.translate(O, CO, d1);
        this.arrow.getPoints().addAll(B.getX(), B.getY());
        this.arrow.getPoints().addAll(P1.getX(), P1.getY());
        this.arrow.getPoints().addAll(P2.getX(), P2.getY());

    }
    public DirectionEdgeView (Polygon arrow, NodeView node, NodeView node1) {
        super(node, node1);
        this.arrow = arrow;
        this.getChildren().add(arrow);
        makeArrow();
        
    }
    
}
