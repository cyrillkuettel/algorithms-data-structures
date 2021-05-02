package ch.hslu.ad.sw09;

import ch.hslu.ad.sw08.Sortieren;

/**
 *
 * @author cyrill
 */
public class QuickSort implements Sortieren {

    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(final int[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        int t = a[right];
        boolean allChecked = false;

        do {
            while (a[up] < t) {
                up++;
            }
            while ((a[down] > t) && (down > up)) {
                down--;
            }
            if (down > up) {
                swap(a, up, down);
                up++;
                down--;

            } else {
                allChecked = true;
            }
        } while (!allChecked);
        swap(a, up, right);
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
