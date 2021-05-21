package ch.hslu.ad.sw12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author cyrill
 */
public class QuickSearchTest {

    private Map<Data, Integer> samples;

    @Before
    public void initSearches() {
        samples = new HashMap<>();
        samples.put(new Data("ananas", "ananas"), 0);
        samples.put(new Data("anananas", "ananas"), 2);
        samples.put(new Data("dasisteinTest", "Test"), 9);
    }

    @Test
    public void testQuickSearch() {
        // Search s = new Search();

        for (Data searchObject : samples.keySet()) {
            int expected = samples.get(searchObject);

            int actual = quickSearch(searchObject.text,
                searchObject.pattern);
            Assert.assertEquals(expected, actual);
        }
    }

    public static int quickSearch(String a, String p) {
        final int m = p.length();
        final int n = a.length();
        int range = 65536;  // UTF-

        final int[] shift = new int[range];

        Arrays.fill(shift, m + 1);

        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
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

}

class Data {

    Data(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }
    String text;
    String pattern;
}
