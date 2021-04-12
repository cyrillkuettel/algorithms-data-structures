package ch.hslu.ad.sw07;

import java.math.BigInteger;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheckSequential {

    private static final Logger LOG = LogManager.getLogger(PrimeCheckSequential.class);
    private static final int NUMBER_OF_PRIMES = 100;

    /**
     * Privater Konstruktor.
     */
    public PrimeCheckSequential() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int n = 1;
        while (n <= NUMBER_OF_PRIMES) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info(n + ": " + bi.toString().substring(0, 20) + "...");
                n++;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println();
        System.out.format("Laufzeit: %d ms", stop - start);
    }
}
