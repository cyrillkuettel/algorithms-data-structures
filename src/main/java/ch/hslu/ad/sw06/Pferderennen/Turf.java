
package ch.hslu.ad.sw06.Pferderennen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) {
        final Synch starterBox = new Latch();
        Thread thread;
        for (int i = 1; i < 6; i++) {
            thread = new Thread(new RaceHorse(starterBox), "Horse " + i);
            thread.start();
        }
        LOG.info("Start...");
        starterBox.release();
    }
}
