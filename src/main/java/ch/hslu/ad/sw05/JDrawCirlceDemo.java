package ch.hslu.ad.sw05;

import javax.swing.UIManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class JDrawCirlceDemo {

    private static final Logger log = LogManager.getLogger(JDrawCircle.class);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            /*
                                      com.sun.java.swing.plaf.gtk.GTKLookAndFeel
                                      com.sun.java.swing.plaf.motif.MotifLookAndFeel
                                      com.sun.java.swing.plaf.windows.WindowsLookAndFeel
             */

        } catch (Exception ignored) {
            log.warn(ignored);
        }
        new JDrawCircle();

    }
}
