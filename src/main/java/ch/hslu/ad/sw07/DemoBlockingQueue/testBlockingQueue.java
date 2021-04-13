package ch.hslu.ad.sw07.DemoBlockingQueue;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */

/*


// It is not possible to insert null into a BlockingQueue.


 */
public final class testBlockingQueue {

    private static final Logger LOG = LogManager.getLogger(testBlockingQueue.class);
    private static final int PASSES = 100;
    private static final int NUMBER_OF_TASKS = 3;
    private static final int maxRange = 1000;

    public testBlockingQueue() throws InterruptedException, ExecutionException {
        start();
    }

    public void start() throws InterruptedException, ExecutionException {
        Duration[] durations = new Duration[PASSES];
        for (int i = 0; i < PASSES; i++) {
            durations[i] = measureTimeToCompletion();
        }

        try {
            double averageRuntime = calculateAverageRuntimeInMillis(durations);
            System.out.println();
            System.out.format("testBlockingQueue Messung fertig, Durchschnittliche Laufzeit: %fms mit %d Tasks und  %d PASSES.", averageRuntime, NUMBER_OF_TASKS, PASSES);
        } catch (Exception e) {
            LOG.warn("Messung failed. Something failed in Average Runtime One-Liner", e);
        }
    }

    public Duration measureTimeToCompletion() throws InterruptedException, ExecutionException {
        final Instant start = Instant.now();

        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(maxRange * NUMBER_OF_TASKS);

        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            futures.add(executor.submit(new Producer(queue, maxRange)));
        }

        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(queue)).get();
        LOG.info("cons tot = " + totCons);

        final Instant end = Instant.now();

        executor.shutdown();
        return Duration.between(start, end);
    }

    public double calculateAverageRuntimeInMillis(Duration inp[]) {
        return Arrays.stream(inp).map(duration -> duration.toNanos() / (double) 1000000).mapToDouble(Double::doubleValue).average().getAsDouble();

    }

    public synchronized void waitForTheFuture(List<Future<Long>> futures) {
        for (Future<Long> result : futures) {
            while (!result.isDone()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new testBlockingQueue();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(testBlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            java.util.logging.Logger.getLogger(testBlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
