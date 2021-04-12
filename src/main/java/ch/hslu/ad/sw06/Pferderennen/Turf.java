package ch.hslu.ad.sw06.Pferderennen;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
    /*
       fair:  // mehr fairness mit CountDownLatch 
    ( This allows all threads to have a fair chance of starting at about the same time.")
 
         nicht fair, weil es nur ein latch hat. Alle Pferde müssen da durch.
         synchronious queue ist ziemlich fair, aber immer noch nicht 100%
    */
    // latch ist optimal -> Mep
    // diese aufgabe könnte in einer Form an der MEP kommen. 
    
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);
    private static final int NUMBER_OF_HORSES = 3;

    private Turf() {
    }
    
    public static void main(final String[] args) throws InterruptedException {
        final Synch startLatch = new Latch();

        Thread[] horses = new Thread[NUMBER_OF_HORSES];
        for (int i = 0; i < NUMBER_OF_HORSES; i++) {
            horses[i] = new Thread(new RaceHorse(startLatch), "Horse " + i);
            horses[i].start();
        }
        LOG.info("Start...");

        TimeUnit.MILLISECONDS.sleep(10);
        for (int i = NUMBER_OF_HORSES; i >= 0; i--) {
            LOG.info(i + " ist am Laufen");
            TimeUnit.MILLISECONDS.sleep(30);
        }
        LOG.info("Start...");

        startLatch.release(); // loslassen

        TimeUnit.SECONDS.sleep(1);
        for (Thread thread : horses) {
            thread.interrupt();
        }

    }
}
