package ch.hslu.ad.sw05;

import java.util.ArrayList;

/**
 *
 * @author cyrill
 */
public class demoCircle {

    private ArrayList<Thread> thread = new ArrayList<>();

    public void generateBalls(int amount) {
        for (int i = 0; i < amount; i++) {
            String description = String.valueOf(i);
            thread.add(new Thread(new ballTask(), description));
        }
        thread.stream().forEach(p -> p.start());

    }

    public static void main(String[] args) {
        demoCircle demo = new demoCircle();

        demo.generateBalls(10);

    }
}
