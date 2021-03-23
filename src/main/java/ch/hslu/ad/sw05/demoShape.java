package ch.hslu.ad.sw05;

import ch.hslu.ad.sw04.HashTable;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import javax.swing.UIManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class demoShape {

    private static final Logger log = LogManager.getFormatterLogger(demoShape.class);

    public demoShape() {
        final int CircleCount = 10;
        int count = 0;
        Shape[] shapes = new Circle[CircleCount];
        while (count < CircleCount) {
            shapes[count] = new Circle(); // color and position get initialized randomly by default
            count++;
        }
        ShapesTemplate st = new ShapesTemplate(shapes);

    }

    public static void main(String[] args) {

        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

        } catch (Exception ignored) {
            log.warn(ignored);
        }
        new demoShape();

    }
}
