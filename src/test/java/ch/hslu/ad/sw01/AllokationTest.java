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



    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.NONFINAL_FIELDS).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }

}
