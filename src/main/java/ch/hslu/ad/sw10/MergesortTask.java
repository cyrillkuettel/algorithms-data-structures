
package ch.hslu.ad.sw10;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Codebeispiel zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class MergesortTask extends RecursiveAction {

    private static final int THRESHOLD = 50;
    private final int[] array; // hilfsarray
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public MergesortTask(final int[] array) {
        this(array, 0, array.length);
    }

    private MergesortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if (max - min < THRESHOLD) {
            Arrays.sort(array, min, max);
        } else {
            final int mid = min + (max - min) / 2;
            invokeAll(new MergesortTask(array, min, mid), new MergesortTask(array, mid, max));
            merge(min, mid, max);
        }
    }

    private void merge(final int min, int mid, int max) {
        // vordere Hälfte von array in Hilfsarray buf kopieren
        int[] buf = Arrays.copyOfRange(array, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            // jeweils das nächstgrösste Element zurückkopieren
            // bei k == max, Rest von buf zurückkopieren, falls vorhanden
            if (k == max || buf[i] < array[k]) {
                array[j] = buf[i];
                i++;
            } else {
                array[j] = array[k];
                k++;
            }
            j++;
        }
    }
}
