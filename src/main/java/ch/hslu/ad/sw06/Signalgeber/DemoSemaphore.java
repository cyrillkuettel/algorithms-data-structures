package ch.hslu.ad.sw06.Signalgeber;


   
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration eines Semaphors.
 */
public final class DemoSemaphore {

    private static final Logger LOG = LogManager.getLogger(DemoSemaphore.class);

    /**
     * Privater Konstruktor.
     */
    private DemoSemaphore() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String[] args) throws InterruptedException {
        demo1();

        demo2();

        demo3();

        demo4();

    }

    private static void demo1() {
        try {
            LOG.info("T1: new sema 4/3");
           Semaphore sema =  new Semaphore(4, 3);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    private static void demo2() {

        try {
            LOG.info("T2: release 3/3 sema");
            Semaphore sema = new Semaphore(3, 3);
            new Thread(() -> {
                try {
                    LOG.debug("T2: {} pending acq", sema.pendingAcquiries());
                    sema.release();
                    LOG.debug("T2: released");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
            new Thread(() -> {
                try {
                    synchronized (sema) {
                        sema.wait(1000);
                    }
                    LOG.debug("T2: {} pending releases", sema.pendingReleases());
                    sema.acquire();
                    LOG.debug("T2: acquired");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    private static void demo3() {
        try {
            LOG.info("T3: release 4 of 0/3 sema");
            Semaphore sema = new Semaphore(0, 3);
            new Thread(() -> {
                try {
                    sema.release(4);
                    LOG.debug("T3: Released");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
            new Thread(() -> {
                try {
                    sema.acquire(1);
                    LOG.debug("T3: acquired");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    private static void demo4() {
        try {
            LOG.info("T4: aquire 4 of 3/3 sema");
            Semaphore sema = new Semaphore(3, 3);
            new Thread(() -> {
                try {
                    sema.acquire(4);
                    LOG.debug("T4: acquired");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
            new Thread(() -> {
                try {
                    sema.release(1);
                    LOG.debug("T4: released");
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                }
            }).start();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

}

 final class Semaphore {

    private int count; 
    private int numberOfAcquiries;
    private int releasesCount;
    private final int semaphoreLimit;

    /**
     * Erzeugt ein Semaphore mit 0 Passiersignalen.
     */
    public Semaphore() {
        this(0);
    }

    /**
     * Erzeugt ein Semaphore mit einem Initalwert für den Semaphorenzähler.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @throws IllegalArgumentException wenn der Initalwert negativ ist.
     */
    public Semaphore(final int permits) throws IllegalArgumentException {
        this(permits, Integer.MAX_VALUE); // wenn nichts angegeben wird, könnnen beliebig viele aquiries gemacht werden.
    }

    /**
     * Erzeugt ein nach oben begrenztes Semaphore.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit   maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        if (permits > limit) {
            throw new IllegalArgumentException("permits > limit");
        }
        count = permits;
        semaphoreLimit = limit;
        numberOfAcquiries = 0;
        releasesCount = 0;
    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten Bereich,
     * wobei mitgezählt wird, der wievielte Eintritt es ist. Falls der Zähler null
     * ist wird der Aufrufer blockiert.
     *
     * @throws java.lang.InterruptedException falls das Warten unterbrochen wird.
     */
    public synchronized void acquire() throws InterruptedException {
        while (count == 0) {
            numberOfAcquiries++;
            this.wait();
            numberOfAcquiries--;
        }
        count--;

        if (releasesCount > 0) {
            this.notifyAll();
        }
    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten Bereich,
     * wobei mitgezählt wird, der wievielte Eintritt es ist.Falls der Zähler null
     * ist wird der Aufrufer blockiert.
     *
     * @param permits Anzahl Passiersignale zum Eintritt.
     * @throws java.lang.InterruptedException falls das Warten unterbrochen wird.
     */
    public synchronized void acquire(final int permits) throws InterruptedException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }

        for (int i = permits; i >= 0; i--) {
            acquire();
        }
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten Bereiches,
     * wobei ebenfalls mitgezählt wird, wie oft der Bereich verlassen wird.
     */
    public synchronized void release() throws InterruptedException {
        // exception throwen, wenn count+1 > limit
        while (count >= semaphoreLimit) {
            releasesCount++;
            this.wait();
            releasesCount--;
        }
        count++;
        if (numberOfAcquiries > 0) {
            this.notifyAll();
        }
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten Bereiches,
     * wobei mitgezählt wird, wie oft der Bereich verlassen wird.
     *
     * @param permits Anzahl Passiersignale zur Freigabe.
     */
    public synchronized void release(final int permits) throws InterruptedException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }

        for (int i = permits; i >= 0; i--) {
            release();
        }
    }

    public synchronized int pendingAcquiries() {
        return numberOfAcquiries;
    }

    public synchronized int pendingReleases() {
        return releasesCount;
    }
}
