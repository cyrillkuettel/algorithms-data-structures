package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
public final class demoCircle {

    public static void main(String[] args) {
        final int NUMS = 2;

        final BallTask[] tasks = new BallTask[NUMS];
        final Thread[] threads = new Thread[NUMS];

//        for (int i = 0; i < NUMS; i++) {
//
//            tasks[i] =  new BallTask();
//            String description = "Balll_" + i;
//            
//            final Thread thread = new Thread(tasks[i] , description);
//            thread.start();
//        }
        final BallTask task = new BallTask();
        final Thread thread = new Thread(task, "Thread");
        thread.start();
    }
}
