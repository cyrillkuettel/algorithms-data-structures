package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
public class demoCircle {

    static Thread thread;

    public static void main(String[] args) {
        final int NUMBER_OF_BALLS = 1;

        final ballTask[] tasks = new ballTask[NUMBER_OF_BALLS];
        final java.lang.Thread[] threads = new java.lang.Thread[NUMBER_OF_BALLS];

        
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            tasks[i] = new ballTask();
        }

        for (int j = 0; j < NUMBER_OF_BALLS; j++) {
            String description = "Balll_numero" + j;
            thread = new Thread(tasks[j], description);
            thread.start();
        }

    }
}
