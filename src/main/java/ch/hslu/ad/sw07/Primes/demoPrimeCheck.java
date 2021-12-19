package ch.hslu.ad.sw07.Primes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
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
/**
 * 100 grosse Primzahlen produzieren.
 */
public final class demoPrimeCheck {

    private static final Logger LOG = LogManager.getLogger(demoPrimeCheck.class);
    private static final int NUMBER_OF_PRIMES = 100;

    public demoPrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PRIMES);
        final List<Future<BigInteger>> futures = new ArrayList<>();
        final List<BigInteger> computedResults = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PRIMES; i++) {
            final Callable<BigInteger> callable = new primeFinderCallable(i);
            final Future<BigInteger> result = executor.submit(callable);
            futures.add(result);
        }

//        Iterator<Future<BigInteger>> it = futures.iterator();
        for (Future<BigInteger> future : futures) {
            try {
                computedResults.add(future.get());
            } catch (InterruptedException | ExecutionException ex) {
                LOG.debug(ex);
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println();
        System.out.format("Laufzeit: %d ms", stop - start + '\n');
        
        
        if (isComplete(futures)) { // is this check necessary ??
            executor.shutdown();
        }

       // computedResults.parallelStream().forEachOrdered(System.out::println); // print the final result ( if you
        // want) ;

    }

    public static boolean isComplete(List<Future<BigInteger>> futures) {
        for (Future<BigInteger> future : futures) {
            if (!future.isDone()) {
                return false;
            }
        }

        return true;
    }
}
