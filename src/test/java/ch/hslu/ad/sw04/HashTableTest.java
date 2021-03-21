package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cyrill
 */
public class HashTableTest {

    public HashTableTest() {
    }

    @Test
    public void testPut() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);
        table.put(1, allocation);
        Entry entry = table.get(1);

        assertEquals(allocation, entry.getValue());

    }

    @Test
    public void checkCollision() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);

        table.put(0, allocation);
        table.put(1, allocation);
        table.put(2, allocation);
        
        
        
    }

}
