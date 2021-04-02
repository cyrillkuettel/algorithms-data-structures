package ch.hslu.ad.Circle;

/**
 *
 * @author cyrill
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

class Circle extends Shape { // Shape array can then hold Circle2 objects

    private int radius;
    private Color color;
    private Color[] colors = {Color.BLUE, Color.RED, Color.BLACK, Color.YELLOW, Color.GREEN, Color.MAGENTA};

    public Circle() {
        System.out.println("Cicle2 constructor!");

        int randomColor = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        Color myColor = colors[randomColor];
        this.color = myColor;

        int randomRadius = ThreadLocalRandom.current().nextInt(30, 70 + 1); // nextInt is normally exclusive of top value, so add 1 to make inclusive
        this.radius = randomRadius;

    }

    public void draw(Graphics g, int _X, int _Y) {

        System.out.println("Drawing circle2");

        this.x = _X;
        this.y = _Y; // always update current Y value in ShapesTemplate
        g.setColor(color);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));

        g.drawOval(this.x, this.y, this.radius, this.radius);
        g.fillOval(this.x, this.y, this.radius, this.radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
