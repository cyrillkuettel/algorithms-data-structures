package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import static org.assertj.core.api.Assertions.assertThat;
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
    public void testGetter() throws Exception {
        HashTable table = new HashTable();

        table.setSize(2);
        Allocation allocation1 = new Allocation(3);
        Allocation allocation2 = new Allocation(4);

        table.put(1, allocation1);
        table.put(2, allocation2);

        Allocation item = table.get(2);
        assertThat(allocation2).usingDefaultComparator().isEqualTo(item);
        
        
    }

    @Test
    public void testPut() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);
        table.put(1, allocation);
        Entry entry = table.getEntry(1); // get the element with key 1

        assertEquals(allocation, entry.getValue());

    }

//       if Storage Array full, put() returns false
    @Test
    public void testNotEnoughStorage() throws Exception {
        HashTable table = new HashTable();
        Allocation allocation1 = new Allocation(1);
        Allocation allocation2 = new Allocation(2);
        Allocation allocation3 = new Allocation(3);

        table.put(0, allocation1);
        table.put(1, allocation2);

        assertFalse(table.put(2, allocation3));

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
