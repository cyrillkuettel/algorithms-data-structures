package ch.hslu.ad.sw12;

import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class Search {

    public Search() {
        
    }

    
    public static int quickSearch(String a, String p) {
        final int m = p.length();
        final int n = a.length();
        int range = 65536;  // UTF-8
     
        int[] shift = new int[range];

        Arrays.fill(shift, m + 1);

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
        System.out.println(quickSearch("Bananenkuchen", "kuch"));
//        System.out.println(quickSearch("gaga", "adfasfdfsdf"));
    }
}
