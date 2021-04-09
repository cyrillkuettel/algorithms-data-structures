package ch.hslu.ad.sw06.waitpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfacher Task für die Demonstration eines Wait-Pools.
 */
public final class MyTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(MyTask.class);
    private final Object lock;

    /**
     * Erzeugen einen Task.
     *
     * @param lock für die Synchronisation
     */
    public MyTask(final Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        LOG.info("Thread gestartet, warten...");

        synchronized (lock) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    lock.wait();
                    LOG.info("...aufgewacht");
                } catch (InterruptedException ex) {
                    /* handling... */
                    LOG.error("Interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }

    }
}

/*

The rule is that the same thread that calls wait (or notify) on an object must also hold the monitor lock on the object. 
 */
