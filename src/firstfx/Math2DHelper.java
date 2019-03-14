/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

/**
 *
 * @author ahcl
 */
class Vector2D {
    private double x, y;
    public Vector2D (double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2D sub (Vector2D vector) {
        return new Vector2D(this.x - vector.getX(), this.y - vector.getY());
    }
    
    public Vector2D add (Vector2D vector) {
        return new Vector2D(this.x + vector.getX(), this.y + vector.getY());
    }
    
    public Vector2D mul (double d) {
        return new Vector2D(this.x * d, this.y * d);
    }
    
    public double getMagnitude () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public Vector2D getPerpendicularVector () {
        return new Vector2D(-this.y, this.x);
    }
    
    public Vector2D getNegativeVector () {
        return new Vector2D(-this.x, -this.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{ x: " + this.x + ", y: " + this.y + "}";
    }
    

}
public class Math2DHelper {
    public static double distance(Vector2D point1, Vector2D point2) {
        return (point1.sub(point2)).getMagnitude();
    }
    
    public static Vector2D translate (Vector2D point, Vector2D vector, double distance) {
        if (vector.getMagnitude() <= 0) return point;
        return point.add(vector.mul(distance / vector.getMagnitude()));
    }
}
