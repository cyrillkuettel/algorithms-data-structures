package ch.hslu.ad.sw12;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author cyrill
 */
public class SuchautomatTest {

    public SuchautomatTest() {
    }

    @Test
    public void testStateSearch() {
        String testString = "AASDANANASASDFHASOIF";
        assertThat(Suchautomat.stateSearch(testString)).isEqualTo(4);
    }
    
    
    @Test
    public void testStateSearch2() {
        String testString = "ANANAAS";
        assertThat(Suchautomat.stateSearch(testString)).isEqualTo(-1);
    }


}
