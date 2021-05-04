
package ch.hslu.ad.sw10.FindFile;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class FindFile {

    private static final Logger LOG = LogManager.getLogger(FindFile.class);

    /**
     * Sucht ein File in einem Verzeichnis. 
     *
     * @param name Name des Files.
     * @param dir Verzeichnis.
     */
    public static void findFile(final String name, final File dir) {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    System.out.println("Starting in SubDir: " + file.getAbsolutePath());
                    findFile(name, file);
                } else if (name.equalsIgnoreCase(file.getName())) {
                    LOG.info(file.getParentFile());
                    return;
                }
            }
        }
    }
}
