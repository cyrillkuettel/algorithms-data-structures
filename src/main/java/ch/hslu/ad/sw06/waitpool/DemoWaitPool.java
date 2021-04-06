package ch.hslu.ad.sw06.waitpool;

/**
 *
 * @author cyrill
 */
/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {

    private static final Object LOCK = new Object();

    /**
     * Privater Konstruktor.
     */
    private DemoWaitPool() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String args[]) throws InterruptedException {
        final MyTask waiter = new MyTask(LOCK);
        new Thread(waiter).start();
        Thread.sleep(1000);
        
        synchronized(LOCK) {
            LOCK.notify();
        }

    }
}
