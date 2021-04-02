package ch.hslu.ad.Circle;

/**
 *
 * @author cyrill
 */
import java.awt.Graphics;

public class Shape {

     int x;
     int y;

    public void draw(Graphics g, int _X, int _Y) {
        x = _X;
        y = _Y;

        System.out.println("Drawing shape");
        throw new IllegalStateException("I don't know how to draw this shape.");

    }

//    public Shape(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
    
}
