package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public class HashTableDemo {

    public static void main(String[] args) {

        HashTable table = new HashTable();
        Allocation a = new Allocation(2);
        table.add(a);
        for (int i = 0; i < table.getSize(); i++) {

            Allocation allocation = new Allocation(i);
            table.add(allocation);
        }
    }

}
