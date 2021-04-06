package ch.hslu.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    private volatile Thread runThread;
    private int rangeEnd;
    private boolean isStopped = false;

    public AdditionTask(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        runThread = Thread.currentThread();
        long sum = 0;
        int n = 0;
        while (n < rangeEnd && !runThread.isInterrupted()) {
            sum += n;
            n++;
        }
        isStopped = hasFinishedCorrectly(n, rangeEnd);
//        try {
//            Thread.sleep(10); // Delay
//        } catch (InterruptedException ex) {
//            runThread.interrupt();
//        }
        if (!isStopped) {
            LOG.info(runThread.getName() + "finished:  n = " + n + "  SUM = " + sum);
        } else {
            LOG.info(runThread.getName() + ": interrupted.");
        }
    }

    public boolean hasFinishedCorrectly(final int n, final int rangeEnd) {
        if (n == rangeEnd) {
            return true;
        }
        return false;
    }

    public void stop() {
        this.isStopped = true;
    }

}
