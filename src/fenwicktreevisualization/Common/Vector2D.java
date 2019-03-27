package fenwicktreevisualization.Common;

public class Vector2D {
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
