package ch.hslu.ad.sw10.FindFile;


import java.io.File;
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
        final String search = "AnsiEscape.java";
        final File rootDir = new File(System.getProperty("user.home"));
        
//        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);
//        FindFile.findFile(search, rootDir);
//        LOG.info("Found in {} msec.", '?');
        
        
        
        
        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        
        long start = System.currentTimeMillis();
        final FindFileTask root = new FindFileTask(search, rootDir);
        long end = System.currentTimeMillis();
        
        root.invoke();
        root.join().ifPresent(System.out::println);
      
        
        LOG.info("Found in {} msec.", end - start);
    }
}
