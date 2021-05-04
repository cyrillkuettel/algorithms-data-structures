package ch.hslu.ad.sw10;



import ch.hslu.ad.sw10.sum.SumTask;
import ch.hslu.ad.sw10.init.RandomInitTask;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(DemoMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 100_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        
        
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        
        
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum  : {}", result);
        final MergesortTask sortTask = new MergesortTask(array);
        pool.invoke(sortTask);
        
        LOG.info("Conc. Mergesort : {} sec.", '?');
        
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Merge Checksum  : {}", result);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum  : {}", result);
        MergesortRecursive.mergeSort(array);
        LOG.info("MergesortRec.   : {} sec.", '?');
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum   : {}", result);
    }
}