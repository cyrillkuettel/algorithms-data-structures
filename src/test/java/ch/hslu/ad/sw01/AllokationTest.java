package ch.hslu.ad.sw01;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author cyrill
 */


//https://assertj.github.io/doc/

public class AllokationTest {

    public AllokationTest() {
    }

    @Test 

    public void testEquals() {
        Allocation a1 = new Allocation(2);
        Allocation a2 = new Allocation(2); // are they

        assertThat(a1).isEqualByComparingTo(a2);
    }

    @Test
    public void testCompareTo() {
        Allocation a1 = new Allocation(1);
        Allocation a2 = new Allocation(2);

        assertThat(-1).isEqualTo(a1.compareTo(a2));
    }

    @Test
    public void testCompareToForEqualAllocation() {
        Allocation a1 = new Allocation(2);
        Allocation a2 = new Allocation(2);
        
        
        // WICHTIG: usingDefaultComparator   MUSS IN DER MITTE STEHEN. 
        
        assertThat(a1).usingDefaultComparator().isEqualByComparingTo(a2);  
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }

}
