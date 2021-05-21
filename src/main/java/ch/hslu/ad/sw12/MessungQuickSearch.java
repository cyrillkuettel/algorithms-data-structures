package ch.hslu.ad.sw12;

import ch.hslu.ad.sw10.ParallelQuicksort.DemoQuicksort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.log;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class MessungQuickSearch {

    private static final Logger log = LogManager.getLogger(DemoQuicksort.class);

    private static final String pattern = "Language";
    private static final String url = "https://www.gutenberg.org/files/2701/2701-0.txt";

    public static void main(String[] args) throws Exception {
        URL source = new URL(url);
        
        
        StringJoiner text = new StringJoiner(" "); // StringJoiner for Stream() input
        
        try ( BufferedReader in = new BufferedReader(
                                                            // range In Quicksearch --> auf unicode! 
            new InputStreamReader(source.openStream(), StandardCharsets.UTF_8))) { 
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                text.add(inputLine);
            }
        } catch (Exception e) {
            log.error("Error:", e);
        }
        System.out.println(text.toString().substring(0, 1000));
        long start = System.currentTimeMillis();
        
        int resultIndex = Search.quickSearch(pattern, text.toString());
        // log.info(resultIndex);
        long stop = System.currentTimeMillis();
        
       System.out.format("Found at Index %d. Total time elapsed: %d ms ", resultIndex, stop - start );

    }

}
