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

        try {
            while (n < rangeEnd && !runThread.isInterrupted()) {
                sum += n;
                n++;
                Thread.currentThread().sleep(20);
            }
            isStopped = !hasFinishedCorrectly(n, rangeEnd);

            if (!isStopped) {
                LOG.info(runThread.getName() + "finished:  n = " + n + "  SUM = " + sum);
            } else {
                LOG.info(runThread.getName() + ": interrupted.");
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
        }

    }

    public boolean hasFinishedCorrectly(final int n, final int rangeEnd) {
        if (n == rangeEnd) {
            return true;
        }
        return false;
    }

    public void terminateManually() {
        this.isStopped = true;
    }

}
