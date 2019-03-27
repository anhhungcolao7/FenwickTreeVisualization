/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization.Common;

/**
 *
 * @author ahcl
 */

public class Math2DHelper {
    public static double distance(Vector2D point1, Vector2D point2) {
        return (point1.sub(point2)).getMagnitude();
    }

    public static Vector2D translate (Vector2D point, Vector2D vector, double distance) {
        if (vector.getMagnitude() <= 0) return point;
        return point.add(vector.mul(distance / vector.getMagnitude()));
    }
}
