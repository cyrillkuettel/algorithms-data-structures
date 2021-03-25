package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public class HashTableDemo {

    public static void main(String[] args) throws Exception {
        HashTable table = new HashTable();
        Allocation allocation = new Allocation(3);

        table.put(0, allocation);
        table.put(0, allocation);

        table.put(0, allocation);

    }

}
