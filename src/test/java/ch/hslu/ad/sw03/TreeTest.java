package ch.hslu.ad.sw03;

import ch.hslu.ad.sw01.Allocation;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author cyrill
 */
public class TreeTest {

     
    @Test
    public void testSomething() {
        int a = 100;
        int b = 100;
        assertEquals(a, b);
    }
        @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }

    
   

}
