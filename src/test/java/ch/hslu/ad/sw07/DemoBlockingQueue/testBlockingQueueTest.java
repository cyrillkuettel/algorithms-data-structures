package ch.hslu.ad.sw07.DemoBlockingQueue;

import java.time.Duration;
import ch.hslu.ad.sw07.DemoBlockingQueue.testAverageCalc;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author cyrill
 */
public class testBlockingQueueTest {

    public testBlockingQueueTest() {
    }



    @Test
    public void testCalculateAverageRuntimeInMillis() {

        final long value1 = 30;
        final long value2 = 50;
        Duration duration1 = Duration.ofMillis(value1);
        Duration duration2 = Duration.ofMillis(value2);
        
//        double b = 4.345345312;
//        double c = 4.345345312;
//        

        Duration[] durations = new Duration[2];
        durations[0] = duration1;
        durations[1] = duration2;

        Duration expectedDuration = Duration.ofMillis((value1 + value2) / 2);
        long expectedLong = expectedDuration.toMillis();
        double expectedDouble = (double) expectedLong; 


        testAverageCalc test = new testAverageCalc();
        test.calculateAverageRuntimeInMillis(durations);
        assertThat(test.calculateAverageRuntimeInMillis(durations)).isEqualTo(expectedDouble);

    }

}
