package ch.hslu.ad.sw07.Primes;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class primeFinderCallable implements Callable<BigInteger> {

    private static final Logger LOG = LogManager.getLogger(primeFinderCallable.class);
    private final int zähler; // Durchnumerierung der Callable

    public primeFinderCallable(final int i) {
        this.zähler = i+1; 
    }
    
    
    
    @Override
    public BigInteger call() throws Exception {
        int n = 0;
        BigInteger bi;
        while (n == 0) {
            bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info(zähler + ": " + bi.toString().substring(0, 20) + "...");
                n++;
                return bi;
            }
        }
       return BigInteger.ZERO; // will never happen
    }

}
