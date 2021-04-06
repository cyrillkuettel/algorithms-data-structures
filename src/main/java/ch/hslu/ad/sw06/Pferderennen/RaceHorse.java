
package ch.hslu.ad.sw06.Pferderennen;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein Rennpferd, das durch ein Startsignal losläuft. Nach einer zufälligen Zeit kommt es im Ziel
 * an.
 */
public final class RaceHorse implements Runnable {

    private static final Logger LOG = LogManager.getLogger(RaceHorse.class);
    private final Synch startSignal;
    private volatile Thread runThread;
    private final Random random;

    /**
     * Erzeugt ein Rennpferd, das in die Starterbox eintritt.
     * @param startSignal Starterbox.
     */
    public RaceHorse(Synch startSignal) {
        this.startSignal = startSignal; // reference to a implementation of the interface (in this case: Latch)
        this.random = new Random();
    }

    @Override
    public void run() {
        runThread = Thread.currentThread();
        LOG.info("Rennpferd " + runThread.getName() + " geht in die Box.");
        try {
            startSignal.acquire();
            LOG.info("Rennpferd " + runThread.getName() + " laeuft los...");
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ex) {
            LOG.debug(ex);
        }
        LOG.info("Rennpferd " + runThread.getName() + " ist im Ziel.");
    }
}
