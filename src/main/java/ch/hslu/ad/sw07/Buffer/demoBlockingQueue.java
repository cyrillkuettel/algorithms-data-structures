package ch.hslu.ad.sw07.Buffer;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class demoBlockingQueue {

    private static final Logger LOG = LogManager.getLogger(demoBlockingQueue.class);

    static void main(String args[]) throws InterruptedException, ExecutionException {
        List<Integer> list = new LinkedList<>();
//        list = Collections.synchronizedList(list);
        
//        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>();

        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//            futures.add(executor.submit(new Producer(blockingQueue, 1000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();

        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("producer sum = " + sum);
        }
        LOG.info("producer total = " + totProd);
        long totCons = executor.submit(new Consumer(list)).get();
        LOG.info("consumer total = " + totCons);
        executor.shutdown();
    }
}
