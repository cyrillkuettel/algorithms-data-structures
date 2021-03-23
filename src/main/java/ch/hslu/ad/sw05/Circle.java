package ch.hslu.ad.sw05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
@SuppressWarnings("serial")
public class Circle extends JPanel {

    private static final Logger log = LogManager.getLogger(JDrawCircle.class);
    
    // TODO: variable radius. 
    private int radius = 5;
    private MouseEvent event;
    private Color color;

    private float y;
    private float x;
    
    public Circle(MouseEvent in) {
        
        this.event = in;
        this.color = color;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 100, 100);

        g.drawOval(event.getX(), event.getY(), 100, 100);
        g.fillOval(event.getX(), event.getY(), 100, 100);
    }
    

}
