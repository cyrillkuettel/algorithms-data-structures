package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class Circle2 extends Shape { // Shape arraay can then hold Circle2 objects

    private int radius = 80;
    private Color color;
    

    
    
    public void draw(Graphics g, int _X, int _Y) {

        System.out.println("Drawing circle");
        
        this.x = _X;
        this.y = _Y;
        g.setColor(new Color(100, 180, 0));

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));

        g.drawOval(this.x, this.y, radius, radius);

    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
