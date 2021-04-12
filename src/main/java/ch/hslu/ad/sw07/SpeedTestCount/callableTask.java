package ch.hslu.ad.sw07.SpeedTestCount;

import ch.hslu.ad.sw07.Primes.primeFinderCallable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author cyrill
 */
public class callableTask implements Callable<Integer> {

    private Counter counter;
    private int NUMBER_OF_ITERATIONS;

    public callableTask(final Counter c, int NUMBER_OF_ITERATIONS) {
        counter = c;
        this.NUMBER_OF_ITERATIONS = NUMBER_OF_ITERATIONS;

    }


  

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            counter.increment();
        }
        
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            counter.decrement();
        }
        return counter.get();
    }
}
