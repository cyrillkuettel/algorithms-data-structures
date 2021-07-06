package ch.hslu.ad.sw10.FindFile;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger(DemoFindFile.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        final String search = "File.txt";
        final File rootDir = new File(System.getProperty("user.home"));
//        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);
//        long start = System.currentTimeMillis();
//        FindFile.findFile(search, rootDir);
//        long end = System.currentTimeMillis();
//        LOG.info("Found in {} msec.", end - start);





        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        long startTime = System.nanoTime();
        final FindFileTask root = new FindFileTask(search, rootDir);
        long endTime = System.nanoTime();
        long elapsedTimeNano = endTime - startTime;
        
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(elapsedTimeNano); // most likely 0 ms 
        
        root.invoke();
        root.join().ifPresent(System.out::println);

       // LOG.info("Found in {} nano seconds.", elapsedTimeNano);
    }
}
