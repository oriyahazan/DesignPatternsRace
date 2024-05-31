/**
 * Oriya Hazan. id:211987102
 * A class representing a "point".
 */

package utilities;

public class Point {
    private static final int MAX_X=1000000;
    private static final int MIN_X=0;
    private static final int MAX_Y=800;
    private static final int MIN_Y=0;
    private double x;
    private double y;

    /**
     * constructor
     * @param x-x
     * @param y-y
     */
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(Point p){
        this.x=p.getX();
        this.y=p.getY();
    }

    /**
     * getters and setters
     */
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public boolean setX(double newX) {
        if(newX>=0) {
            this.x = newX;
            return true;
        }
        return false;
    }
    public boolean setY(double newY){
        if(newY>=0){
            this.y=newY;
            return true;
        }
        return false;
    }

    /**
     * To string function
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
