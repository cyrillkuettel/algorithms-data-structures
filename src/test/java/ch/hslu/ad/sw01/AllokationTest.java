package ch.hslu.ad.sw01;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cyrill
 */
public class AllokationTest {

    public AllokationTest() {
    }

    /**
     * Test of compareTo method, of class Allokation.
     */
    @Test
    public void testCompareTo() {
//        System.out.println("compareTo");
//        Allocation other = new Allocation();
//        Allocation instance = new Allocation();
//        int expResult = 0;
//        int result = instance.compareTo(other);
//        assertThat(other).isEqualTo(instance);
//        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testHashCode() {

    }

    @Test
    public void testEquals() {

    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }

}
