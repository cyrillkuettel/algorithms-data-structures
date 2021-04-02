package ch.hslu.ad.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public final class JDrawCircle extends JFrame implements MouseListener {

    private static final Logger log = LogManager.getLogger(JDrawCircle.class);

    /*
    BUG disappear on window.size.refresh()
    The paintComponent method on any subclass of Component is called after the parent frame is resized. 
    So you can use that to prevent resizeing.
     */
    // constructor
    public JDrawCircle() {
        addMouseListener(this);
        setTitle("Circles BABy");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // here the cirlce should be drawn
        log.info("mouse click");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent0) {  // could generate the circles here aswell. Just while loop + delay. 
        log.info("mouse Pres)");
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
