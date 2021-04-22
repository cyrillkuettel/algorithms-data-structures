package ch.hslu.sw08;

import java.util.Arrays;


/**
 *
 * @author cyrill
 */
public class SelectionSort implements Sortieren{ // "Direktes Auswählen"

    private int[] a = {4, 2, 6, 9, 3, 7, 1};

    public SelectionSort() {
    }

    public static void main(String[] args) {
        new SelectionSort();
    }

    @Override
    public void sort(int[] arr) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
