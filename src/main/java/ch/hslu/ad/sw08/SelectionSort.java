package ch.hslu.ad.sw08;

import java.util.Arrays;


/**
 *
 * @author cyrill
 */
public class SelectionSort implements Sortieren{ // "Direktes Auswählen"

    @Override
    public void sort(int[] arr) {
        int currentMinimum;

        /// unsorted Partition, and Sorted Partition. 
        for (int i = 0; i < arr.length; i++) {
            currentMinimum = i;
            /* assume the min is the first element */

            for (int j = i + 1; j < arr.length; j++) {  // progress the lenght of the array, looking for smaller number
                if (arr[j] < arr[currentMinimum]) {
                    currentMinimum = j;
                    /* found new minimum; remember its index */
                }
            }
            
            if (currentMinimum != i) {
                swap(arr, i, currentMinimum);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
