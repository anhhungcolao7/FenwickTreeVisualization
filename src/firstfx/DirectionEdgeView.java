/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import javafx.scene.shape.Polygon;


/**
 *
 * @author ahcl
 */
public class DirectionEdgeView extends EdgeView{
    private Polygon arrow;
    public DirectionEdgeView() {
    }

    public DirectionEdgeView(NodeView node, NodeView node1) {
        this(new Polygon(), node, node1);
    }
    public DirectionEdgeView(Polygon arrow, NodeView node, NodeView node1) {
        super(node, node1);
    }
    
}
