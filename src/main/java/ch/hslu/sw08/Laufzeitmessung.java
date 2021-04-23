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

    private static final Logger log = LogManager.getLogger(Laufzeitmessung.class);
    private int SIZE;
    private int[] a;

    public Laufzeitmessung(final int size) {
        this.SIZE = size;

        log.info("Generating Random Sequence");
        RandomArrayGenerator rnd = new RandomArrayGenerator();

        this.a = rnd.generateUniqueRandomArray(SIZE);

    }

    public void messung(final Sortieren sortierer) {
        int[] a = this.a.clone();
        log.info("Starting {} ...", (sortierer.getClass().getSimpleName()));
        log.info(Arrays.toString(a).substring(0, 20));

        long start = System.currentTimeMillis();
        sortierer.sort(a);
        long end = System.currentTimeMillis();

        log.info(Arrays.toString(a).substring(0, 20));
        System.out.format("Finished sorting. Total time: %d ms", end - start);
        System.out.println();
    }

    public static void main(String[] args) {
//        Laufzeitmessung m = new Laufzeitmessung(100000);
//
//        m.messung(new InsertionSort());
//        m.messung(new SelectionSort());
//        m.messung(new BubbleSort());

        Laufzeitmessung m2 = new Laufzeitmessung(200000);

        m2.messung(new InsertionSort());
        m2.messung(new SelectionSort());
        m2.messung(new BubbleSort());

    }

}
