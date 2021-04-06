package ch.hslu.ad.sw05;

/**
 *
 * @author cyrill
 */
public class AdditionTaskDemo {
 
    public static void main(String[] args) {
        AdditionTask task = new AdditionTask(10000);
        Thread t = new Thread(task, "Task 10k");
        t.start();
    }
}
