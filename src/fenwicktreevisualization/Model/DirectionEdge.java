/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization.Model;

import javafx.scene.shape.Polygon;


/**
 *
 * @author ahcl
 */

public class DirectionEdge extends Edge {
    private Polygon arrow;
//    final double ANGLE = 30;
//    final double HEAD_LENGHT = 10;
    public DirectionEdge() {
        
    }

    public DirectionEdge(Node firstNode, Node secondNode) {
//        this(new Polygon(
//            0f, 0f,
//            0f, 0f,
//            0f, 0f
//        ), node, node1);
        this(new Polygon(), firstNode, secondNode);
    }
    
//    private void makeArrow () {
//        double t = 100f;
//        ObservableList<Double> points = this.arrow.getPoints();
//        for(int i=0;i<this.arrow.getPoints().size(); i++) {
//            int index = i;
//            DoubleProperty property = new SimpleDoubleProperty(points.get(i));
//            property.bind(Bindings.createDoubleBinding(() -> {
//                double x = this.getLine().getStartX();
//                double y = this.getLine().getStartY();
//                double x1 = this.getLine().getEndX();
//                double y1 = this.getLine().getEndY();
//                Vector2D A = new Vector2D(x, y);
//                Vector2D B = new Vector2D(x1, y1);
//                Vector2D BA = A.sub(B);
//                double d = HEAD_LENGHT * Math.cos(ANGLE / 180 * Math.PI);
//                Vector2D O = Math2DHelper.translate(B, BA, d);
//                double d1 = HEAD_LENGHT * Math.sin(ANGLE / 180 * Math.PI);
//                Vector2D OC = BA.getPerpendicularVector();
//                Vector2D P1 = Math2DHelper.translate(O, OC, d1);
//                Vector2D CO = OC.getNegativeVector();
//                Vector2D P2 = Math2DHelper.translate(O, CO, d1);
//                double [] triangle = {B.getX(), B.getY(), P1.getX(), P1.getY(), P2.getX(), P2.getY()};
//                System.out.println(triangle[index]);
//                return triangle[index];
//            }, this.getLine().startXProperty(), this.getLine().startYProperty(), this.getLine().endXProperty(), this.getLine().endYProperty()));
//            property.addListener(new ChangeListener<Number>() {
//                @Override
//                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                    points.set(index, (double) newValue);
//                }
//            });
//        }
//
//    }
    public DirectionEdge(Polygon arrow, Node node, Node node1) {
        super(node, node1);
        this.arrow = arrow;
        this.getChildren().add(arrow);
//        makeArrow();
        
    }
    
}
