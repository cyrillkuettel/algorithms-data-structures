package ch.hslu.ad.sw12;

import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class KMP {

    private static int[] initNext(final String p) {
        final int m = p.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        do {
            if ((j == -1) || (p.charAt(i) == p.charAt(j))) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }

    public static int kmpSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        int i = 0;
        int j = 0; // 

        int[] next = initNext(p);

        do {
            if ((j == -1) || (a.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else {
                j = next[j]; // --> next state
            }
        } while ((j < m) && (i < n));
        if (j == m) {
            return (i - m);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String searchFor = "EISBEIN";

        System.out.println(Arrays.toString(initNext(searchFor)));

        searchFor = "ANANAS";

        System.out.println(Arrays.toString(initNext(searchFor)));

    }
}
