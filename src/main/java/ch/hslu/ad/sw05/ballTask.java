package ch.hslu.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class ballTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ballTask.class);

    public ballTask() {
    }

    @Override
    public void run() {
        Ball b = new Ball();
        b.startRandomBall();

        Thread self = Thread.currentThread();
        LOG.info(" finished " + self.getName());
    }

}
