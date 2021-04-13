package ch.hslu.ad.sw07.SpeedTestCount;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.DoubleStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class speedTest {

    private static final Logger LOG = LogManager.getLogger(speedTest.class);

    private int TAKES = 10; // number of takes, then takes average from all
    private int ITERATIONS = 1000000;

    public speedTest() {
        testAnyCounter(new AtomicCounter());
        testAnyCounter(new SynchronizedCounter());

        ITERATIONS *= 10;

        testAnyCounter(new AtomicCounter());
        testAnyCounter(new SynchronizedCounter());
    }

    public void testAnyCounter(Counter counter) {
        Duration durations[] = new Duration[TAKES];
        for (int i = 0; i < TAKES; i++) {
            durations[i] = measureTimeToCompletion(counter);
        }

        try {
            double averageRuntime = calculateAverageRuntimeInMillis(durations);
            System.out.format(counter.getClass().getSimpleName() + " fertig, Laufzeit: %fms mit %d iterations.", averageRuntime, ITERATIONS);
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            LOG.warn("Average Runtime One-Liner failed", e);
        }

    }

    public Duration measureTimeToCompletion(Counter counter) {

        Instant start = Instant.now();

        final ExecutorService executor = Executors.newCachedThreadPool();
        final Callable<Integer> callable = new callableTask(counter, ITERATIONS);
        Future<Integer> result = executor.submit(callable);

        while (!result.isDone()) {
            try {
                wait(); // suspend the current thread
            } catch (Exception e) {
                // I really don't care 
            }
        }

        Instant end = Instant.now();
        Duration difference = Duration.between(start, end);
        executor.shutdown();
        return difference;
    }

    public void waitALot(Future<Integer> result) {
        
        while (!result.isDone()) {
            try {
                wait(); // suspend the current thread
            } catch (Exception e) {
                // I really don't care 
            }
        }
    }

    public double calculateAverageRuntimeInMillis(Duration inp[]) {
        // For Each duration object:
        //      Get the measured time as double
        //      convert from nano to milli
        // return average form each object
        return Arrays.stream(inp).map(duration -> duration.toNanos() / (double) 1000000).mapToDouble(Double::doubleValue).average().getAsDouble();

    }

    public static void main(String[] args) {
        new speedTest();
    }

}
