package ch.hslu.sw08;

import static ch.hslu.sw08.InsertionSort.insertionSort;
import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class BubbleSort {

    private int[] a = {4, 2, 6, 9, 3, 7, 1};

    public BubbleSort() {
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        new BubbleSort();
    }
}
