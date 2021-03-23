package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public final class DrawCircle extends JFrame implements MouseListener {

    private static final Logger log = LogManager.getLogger(DrawCircle.class);

    public DrawCircle() {
        addMouseListener(this);
        setTitle("Drawing a Circle");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception ignored) {
            log.warn(ignored);
        }
        new DrawCircle();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);
        g.drawOval(e.getX(), e.getY(), 100, 100);
        g.fillOval(e.getX(), e.getY(), 100, 100);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent0) {
        // could generate the circles here aswell. Just while loop + delay. 
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent0) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent0) {
    }
}
