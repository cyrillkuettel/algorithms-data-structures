package ch.hslu.sw08;

import ch.hslu.ad.Circle.JDrawCircle;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class Laufzeitmessung {

    private static final Logger log = LogManager.getLogger(JDrawCircle.class);
    private int SIZE = 100000;

    public Laufzeitmessung(final Sortieren sortierer, final int size) {
        this.SIZE = size;
        RandomArrayGenerator rnd = new RandomArrayGenerator();
        int[] a = rnd.generateUniqueRandomArray(SIZE);
        log.info("Starting Sort ...");
        log.info(Arrays.toString(a).substring(0, 30));
        
        long start = System.currentTimeMillis();
        sortierer.sort(a);
        long end = System.currentTimeMillis();
        
        log.info(Arrays.toString(a).substring(0, 30));
        System.out.format("Finished sorting. Total time: %d ms", end - start);
        System.out.println();
    }

    public static void main(String[] args) {
        
        new Laufzeitmessung(new InsertionSort(), 100000);
        new Laufzeitmessung(new SelectionSort(), 100000);
        new Laufzeitmessung(new BubbleSort(), 100000);
        
    }

}
