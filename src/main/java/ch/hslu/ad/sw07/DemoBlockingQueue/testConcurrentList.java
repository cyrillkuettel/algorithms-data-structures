
package ch.hslu.ad.sw07.DemoBlockingQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class testConcurrentList {

    private static final Logger LOG = LogManager.getLogger(testConcurrentList.class);

    /**
     * Privater Konstruktor.
     */
    private testConcurrentList() {
    }

   
    public static void main(final String args[]) throws InterruptedException, ExecutionException {

        List<Integer> list = new LinkedList<>();

        list = Collections.synchronizedList(list);

        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futures.add(executor.submit(new Producer(list, 1000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get(); // returns the sum from producer
            totProd += sum;
            // LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(list)).get();
        LOG.info("cons tot = " + totCons);
 
        executor.shutdown();
    }
    

}
