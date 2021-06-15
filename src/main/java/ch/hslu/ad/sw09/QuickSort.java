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
                up++; // Suche grösseres Element von Links an 
            }
            while ((a[down] > t) && (down > up)) { // hier braucht es kein Gleichheitszeichen
                down--; // Suche kleineres Element von rechts an 
            }
            if (down > up) {
                swap(a, up, down);
                up++;
                down--;
                  // Elemente werden von rechts nach links vertauscht und umgekehrt
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        swap(a, up, right);
        /*
        Der Witz ist: die Auftrennung wird optimiert. Dadurch gibt es weniger Rekursionsaufrufe
        */
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right); // rechte Hälfte, ohne Trennelement
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
