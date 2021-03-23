package ch.hslu.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class Thread {

    private static final Logger log = LogManager.getLogger(JDrawCircle.class);

    public static void main(String[] args) {

        final int nr = Runtime.getRuntime().availableProcessors();
        log.info("available processors: " + nr);
         

    }
}
