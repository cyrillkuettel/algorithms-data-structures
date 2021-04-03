package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
public class demoCircle {

    public static void main(String[] args) {
        final int NUMBER_OF_BALLS = 40;

        final ballTask[] tasks = new ballTask[NUMBER_OF_BALLS];
        final java.lang.Thread[] threads = new java.lang.Thread[NUMBER_OF_BALLS];

        for (int i = 0; i < NUMBER_OF_BALLS; i++) {

            tasks[i] = new ballTask();
            String description = "Balll_" + i;

            Thread thread = new Thread(tasks[i], description);
            thread.start();
        }

    }
}
