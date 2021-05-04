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
        final String search = "test.properties";
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info("Start searching '{}' recurive in '{}'", search, rootDir);
        FindFile.findFile(search, rootDir);
        LOG.info("Found in {} msec.", '?');
        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        final FindFileTask root = new FindFileTask(search, rootDir);
        LOG.info(root.invoke());
        LOG.info("Found in {} msec.", '?');
    }
}
