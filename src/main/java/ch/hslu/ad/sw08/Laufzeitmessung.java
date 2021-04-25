package ch.hslu.ad.sw08;

import ch.hslu.ad.sw09.QuickSort;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class Laufzeitmessung {

    private static final Logger log = LogManager.getLogger(Laufzeitmessung.class);
    private int SIZE;
    private int[] a;

    public Laufzeitmessung(final int size) {
        this.SIZE = size;

        log.info("Generating Random Sequence");
        RandomArrayGenerator rnd = new RandomArrayGenerator();

        this.a = rnd.generateArray(SIZE);

    }

    public void messen(final Sortieren sortierer) {
        int[] a = this.a.clone();
        log.info("Starting {} ...", sortierer.getClass().getSimpleName());
        log.info(Arrays.toString(a).substring(0, 20));

        long start = System.currentTimeMillis();
        sortierer.sort(a);
        long end = System.currentTimeMillis();

        log.info(Arrays.toString(a).substring(0, 20));
        System.out.format("Finished sorting %d elements. Total time: %d ms", SIZE, end - start);
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        Laufzeitmessung m = new Laufzeitmessung(60_000_000);

        m.messen(new QuickSort());

    }

}
