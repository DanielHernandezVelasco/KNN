package Point;

import java.awt.Color;

/**
 *
 * @author cachubis
 */
public class Point {
    private int x;
    private int y;
    private Color c;
    private int distance;
    
    public Point(){
    }
    
    public Point(int x, int y,Color c){
        this.x=x;
        this.y=y;
        this.c=c;
    }
    
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
    
    
}
