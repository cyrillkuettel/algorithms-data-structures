package ch.hslu.ad.sw03;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyrill
 */
public class BinärbaumTest {

    public BinärbaumTest() {
    }

    /**
     * Test of istLeer method, of class Binärbaum.
     */
//    void testTree() {
//        Binärbaum<String> b = new Binärbaum<>();
//        b.einfügen("a");
//        b.einfügen("b");
//    }
    @Test
    void testStringComparator() {

        String test1 = "a";
        String test2 = "b";
        int expectedValue = -1; //  " b minus 1 ist a"
        Assertions.assertThat(test1.compareTo(test2)).isEqualTo(expectedValue);
    }

    @Test
    void testStringComparator2() {

        String test1 = "a";
        String test2 = "b";
        int expectedValue = -24;

        Assertions.assertThat(test1.compareTo(test2)).isEqualTo(expectedValue);
    }

    @Test
    void testIfLeer() {
        Binärbaum<String> b = new Binärbaum<>();

        assertTrue(b.istLeer());
    }

}
