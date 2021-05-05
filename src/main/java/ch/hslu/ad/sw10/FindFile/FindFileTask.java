package ch.hslu.ad.sw10.FindFile;

import java.io.File;
import java.util.Optional;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage zu CountedCompleter für eine Dateisuche.
 */
@SuppressWarnings("serial")
public final class FindFileTask extends CountedCompleter<Optional<File>> {

    private static final Logger LOG = LogManager.getLogger(FindFileTask.class);

    private final String regex;
    private final File dir;
    private final AtomicReference<File> result;

    /**
     * Erzeugt eine File-Such-Aufgabe.
     *
     * @param regex Ausdruck der den Filenamen enthält.
     * @param dir Verzeichnis in dem das File gesucht wird.
     */
    public FindFileTask(String regex, File dir) {
        this(null, regex, dir, new AtomicReference<>(null));
    }

    private FindFileTask(final CountedCompleter<?> parent, final String regex, final File dir,
        final AtomicReference<File> result) {
        // der 1. Parameter parent ist die Referenz auf den Erzeuger Task
        super(parent);
        this.dir = dir;
        this.regex = regex;
        this.result = result;

    }

    @Override
    public void compute() {
        final File[] entries = dir.listFiles();

        if (entries != null) {
            for (File file : entries) {
                if (result.get() != null) {
                    break; // found Match. no need to go further
                }

                if (file.isDirectory()) {
                    addToPendingCount(1); // ein neuer Task wird abgezeigt. Dies wird  dem Framework hier mitgeteilt. 
                    FindFileTask task = new FindFileTask(this, this.regex, file, result);
                    task.fork();

                } else if (regex.equalsIgnoreCase(file.getName())) {
                    LOG.info(file.getParentFile());
                    quietlyCompleteRoot();
                    break;
                }
            }
        }
        tryComplete();
    }

    @Override
    public Optional<File> getRawResult() {
        File res = result.get();
        
        if (res == null) {
            return Optional.empty();
        } else {
            return Optional.of(res);
        }
    }
}
