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

 