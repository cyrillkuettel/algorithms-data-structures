package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
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
    public void testPut() {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);
        table.put(1, allocation);
        Entry entry = table.get(1);

        assertEquals(allocation, entry.getValue());

    }

    @Test
    public void checkCollision() {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);
    }

}
