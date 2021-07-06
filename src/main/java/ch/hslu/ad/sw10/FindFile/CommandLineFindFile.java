package ch.hslu.ad.sw10.FindFile;

import java.io.File;
import java.util.concurrent.TimeUnit;


/**
 * Codevorlage für eine Dateisuche.
 */
public final class CommandLineFindFile {

    /**
     * Privater Konstruktor.
     */
    private CommandLineFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("please provide a search query!");
        }  else {
            final String search = args[0];
            final File rootDir = new File(System.getProperty("user.home"));
            // System.out.printf("Find '{}' concurrent in '{}'", search, rootDir);

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
}
