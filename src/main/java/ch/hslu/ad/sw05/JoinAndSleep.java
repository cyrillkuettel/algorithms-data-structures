package ch.hslu.ad.sw05;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class JoinAndSleep {

    private static final Logger log = LogManager.getLogger(ballTask.class);

    public static void main(String[] args) {

        Thread t3 = new Thread(() -> {
            log.info("T3 Started!");

            try {
                log.info("t1 sleeping!");
                TimeUnit.SECONDS.sleep(4);

            } catch (Exception e) {
                log.info("T3 Interrruped");
                return;
            }
        }, "T3");

        Thread t2 = new Thread(() -> {
            log.info("T2 Started!");
            // Thread 2 soll auf Thread 3 warten. 
            try {
                t3.join();
                log.info("t2 sleeping!");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                log.info("T2 Interrruped");
                return;
            }
        }, "T2");

        Thread t1 = new Thread(() -> {
            log.info("T1 Started!");
            try {
                t2.join();
                log.info("t1 sleeping!");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                log.info("T1 Interrruped");
                return;
            }
        }, "T1");
        
        t1.start();
        t2.start();
        t3.start();
    }

}
