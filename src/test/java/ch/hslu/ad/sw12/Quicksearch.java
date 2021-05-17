package ch.hslu.ad.sw12;

import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class Quicksearch {

    public static int quickSearch(String a, String p) {
        final int m = p.length();
        final int n = a.length();
        final int[] shift = new int[256];

        Arrays.fill(shift, m + 1);
        
        for (int i = 0; i < 256; i++) {
            shift[i] = m+1;
        }

        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        int i = 0; // index of String while searching
        int j = 0; // index of pattern p

        do {
            if (a.charAt(i + j) == p.charAt(j)) {
                j++; // match, so check the next char in pattern
            } else {
                if ((i + m) < n) { // a.charAt(i+m) is not outside a
                    i += shift[a.charAt(i + m)];
                    j = 0;
                } else {
                    break; // mismatch && no shift possible
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(quickSearch("Bananenkuchen", "kuch"));

    }
}
