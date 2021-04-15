package ch.hslu.sw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cyrill
 */
public class RandomArrayGenerator {

    private final int MIN = 0;
    private final int MAX = 100;

    public RandomArrayGenerator() {

    }

    public int[] generateArray(final int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            a[i] = randomNum;

        }
        return a;
    }

    public int[] generateUniqueRandomArray(final int size) {
       
         
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] array = list.stream().mapToInt(i->i).toArray();
            
        return array;
    }

    public static void main(String[] args) {
        RandomArrayGenerator r = new RandomArrayGenerator();
        System.out.println(Arrays.toString(r.generateUniqueRandomArray(100)));
    }

}
