package ch.hslu.ad.sw07.DemoBlockingQueue;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class testAverageCalc {
// Nur eine Klasse zum die Methode simpel zu testen

    public static double calculateAverageRuntimeInMillis(Duration inp[]) {
        return Arrays.stream(inp).map(duration -> duration.toNanos() / (double) 1000000).mapToDouble(Double::doubleValue).average().getAsDouble();
    }
}
