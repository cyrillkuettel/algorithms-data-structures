package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

//TODO:
// set timer for (this)

@SuppressWarnings("serial")
public class ShapesTemplate extends JPanel {

    private int width = 600;
    private int height = 400;

    private Shape[] shapes;

    public ShapesTemplate(Shape[] shapes) {
        this.shapes = shapes;
        if (shapes == null || shapes.length < 1) {
            this.shapes = new Shape[0];
        }
        setupTheFrame();

        repaint();
    }

    void setupTheFrame() {

        JFrame frame = new JFrame("Circle");
        frame.setLocation(750, 150);
        
        frame.setMinimumSize(new Dimension(width, height));
        
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    // automatically runs:
    @Override
    protected void paintComponent(Graphics g) {
        // draw all in a loop

        for (Shape s : shapes) {
            s.draw(g, 100, 110);

            //g.fillRect(defender.getX(), defender.getY(), 64, 64);
        }

    }
}
