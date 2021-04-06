package ch.hslu.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class AdditionTaskDemo {

    private static final Logger log = LogManager.getLogger(ballTask.class);

    public static void main(String[] args) {
        AdditionTask task1 = new AdditionTask(100);
        AdditionTask task2 = new AdditionTask(1000);

        Thread thread1 = new Thread(task1, "Task 100");
        Thread thread2 = new Thread(task2, "Task 1000");

        thread1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.debug("Thread.sleep Unterbrochen");
        }

        log.debug("Stopping thread: " + thread1);
        task1.terminateManually();
        try {
            thread1.join();
            log.debug("Thread successfully stopped: " + thread1);
        } catch (InterruptedException e) {
            log.debug("Thread Interrupted because Thread.join failed");
        }

    }
}
