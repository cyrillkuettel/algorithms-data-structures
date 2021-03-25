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

//       if Storage Array full, put() returns false
    @Test
    public void testNotEnoughStorage() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);

        table.put(0, allocation);
        table.put(1, allocation);

        assertFalse(table.put(2, allocation));

    }

    /* if the Table experiences an Overfloww,
        The stored items should not be affected, 
     */
    @Test
    public void testIntegrityOfStorage() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);

        table.put(0, allocation);
        table.put(1, allocation);
        Entry[] storageBefore = table.getarr();
        table.put(2, allocation);
        Entry[] storageAfter = table.getarr();

        // Objects should stay the same after operation.
        assertEquals(storageBefore, storageAfter);

    }

    @Test
    public void testToString() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);

        table.put(0, allocation);
        table.put(1, allocation);

        assertThat(table.toString()).startsWith("Storage of Entries : ").contains("Entry{" + "key=");

    }

    @Test
    public void testToString2() throws Exception {
        HashTable table = new HashTable();
        System.out.println(table.toString());
        assertThat(table.toString()).isNotNull();

    }

}
