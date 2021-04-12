package ch.hslu.ad.sw07;

import java.math.BigInteger;
import java.util.ArrayList;
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
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(PrimeCheck.class);
    private static final int NUMBER_OF_PRIMES = 100;

    public PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
 
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PRIMES);
        List<Future<BigInteger>> futures = new ArrayList<>();
        List<BigInteger> computedResults = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PRIMES; i++) {
            final Callable<BigInteger> callable = new primeFinderCallable(i);
            final Future<BigInteger> result = executor.submit(callable);
            futures.add(result);
        }
        
        for (Future<BigInteger> future : futures) {
             try {
                computedResults.add(future.get());
            } catch (InterruptedException | ExecutionException ex) {
                LOG.debug(ex);
            }
        }
        executor.shutdown();
        
    }
}
