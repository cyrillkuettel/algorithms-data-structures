package ch.hslu.ad.sw06.BoundedBuffer;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class demoBuffer {

    private static final int CONSUMERS = 2;
    private static final int PRODUCERS = 5;
    private static final int QUEUE_SIZE = 50;
    private static final Random random = new Random();
    private static final int max = 5;
    
    
    private static final Logger LOG = LogManager.getLogger(demoBuffer.class);

    public static void main(String[] args) throws InterruptedException {

        final ThreadGroup producerGroup = new ThreadGroup("Producer-Threads");
        final Producer[] producers = new Producer[PRODUCERS];

        final Consumer[] consumers = new Consumer[CONSUMERS];
        final ThreadGroup consGroup = new ThreadGroup("Consumer-Threads");

        final BoundedBuffer<Integer> queue = new BoundedBuffer<>(QUEUE_SIZE);
        
        
        for (int i = 0; i < PRODUCERS; i++) {
            producers[i] = new Producer(queue, max);
            new Thread(producerGroup, producers[i]).start();
        }
        
        
    

    }

}
