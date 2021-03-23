package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.Timer;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ShapesTemplate extends JPanel { // implements Mouse Listener

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
        // x und y immer wieder anpassen hier: 
        int px = 100;
        int py = 100;

        for (Shape s : shapes) {
            s.draw(g, px, py);
            px += 60;

        }

    }
}
