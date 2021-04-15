package ch.hslu.sw08;

import static ch.hslu.sw08.InsertionSort.insertionSort;
import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class SelectionSort { // "Direktes Auswählen"

    private int[] a = {4, 2, 6, 9, 3, 7, 1};

    public SelectionSort() {
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        new SelectionSort();
    }

    void direktesAuswählen(int[] arr) {
        int currentMinimum;

        /// unsorted Partition, and Sorted Partition. 
        for (int i = 0; i < arr.length; i++) {
            currentMinimum = i;
            /* assume the min is the first element */

            for (int j = i + 1; j < arr.length; j++) {  // progress the lenght of the array, looking for smaller number
                if (a[j] < a[currentMinimum]) {
                    currentMinimum = j;
                    /* found new minimum; remember its index */
                }
            }
            
            if (currentMinimum != i) {
                swap(a, i, currentMinimum);
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
