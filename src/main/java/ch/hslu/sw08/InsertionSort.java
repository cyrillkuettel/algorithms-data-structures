package ch.hslu.sw08;

import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class InsertionSort {

    private int[] a = {4, 2, 6, 9, 3, 7, 1};

    public InsertionSort() {
        RandomArrayGenerator rnd = new RandomArrayGenerator();
        
        a = rnd.generateUniqueRandomArray(100);
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));

    }

  public static void insertionSort(int array[]) {
    for (int j = 1; j < array.length; j++) {
        int current = array[j];
        int i = j-1;
        while ((i > -1) && (array[i] > current)) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = current;
    }
}

    public static void main(String[] args) {
        new InsertionSort();

    }
}
