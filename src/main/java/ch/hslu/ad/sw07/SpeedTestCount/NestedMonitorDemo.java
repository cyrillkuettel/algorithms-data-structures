package ch.hslu.ad.sw07.SpeedTestCount;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author cyrill
 */
public class NestedMonitorDemo {

    private static final Object outer = new Object();
    private static final Object inner = new Object();

    public static void main(String[] args) throws InterruptedException {
        testQueue();
    }

    public static void OneLiner() {
        // In place instantiation
        new Thread(new Runnable() { // cant write to thread variable .. .
            // It's a constructor. Constructors don't have a return type;
            @Override
            public void run() {
                System.out.println("2");
            }
        }).run();

    }

    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (outer) {
                    System.out.println("get outer");
                    synchronized (inner) {
                        System.out.println("get inner");
                    }
                }
            }
        }).start();
    }

    public static void testQueue() {
        BlockingQueue<Integer> qu = new LinkedBlockingQueue<>();
        int a = qu.poll();
    }

    public static void testExecutor() {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final ExecutorService executor23 = Executors.newScheduledThreadPool(0);
        
        executor.execute(() -> System.out.println(1 / 0));
        /*
        newCachedThreadPool
        newScheduledThreadPool
        newFixedThreadPool
        
        newSingleThreadExecutor
        */
    }
}
