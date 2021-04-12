package ch.hslu.ad.sw07.SpeedTestCount;

import ch.hslu.ad.sw07.Primes.PrimeCheckSequential;
import ch.hslu.ad.sw07.Primes.primeFinderCallable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
/*
 TODO: 
   -  N iTERATIONS, then take the average.
   -use   java.time.Duration; and  java.time.Instant   instead of System.currentTimes

  

 */
public final class speedTestSimple {

    private static final Logger LOG = LogManager.getLogger(speedTestSimple.class);
    private int ITERATIONS = 1000000;

    public speedTestSimple() {
        testAnyCounter(new AtomicCounter());
        testAnyCounter(new SynchronizedCounter());

        ITERATIONS *= 10;

        testAnyCounter(new AtomicCounter());
        testAnyCounter(new SynchronizedCounter());

    }

    public void testAnyCounter(Counter counter) {
        long start = System.currentTimeMillis();

        final ExecutorService executor = Executors.newCachedThreadPool();
        final Callable<Integer> callable = new callableTask(counter, ITERATIONS);
        Future<Integer> result = executor.submit(callable);

        while (!result.isDone()) {
            try {
                wait(); // suspend the current thread
            } catch (Exception e) {
                // really don't care about an exception 
            }
        }

        long end = System.currentTimeMillis();
        executor.shutdown();
        System.out.format(counter.getClass().getSimpleName() + " fertig, Laufzeit: %dms mit %d iterations. \n", (end - start), ITERATIONS);

    }

    public static void main(String[] args) {
        new speedTestSimple();
    }

}
