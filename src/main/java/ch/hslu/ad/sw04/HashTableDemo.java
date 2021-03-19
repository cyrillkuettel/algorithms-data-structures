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
        Allocation b = new Allocation(3);
        Allocation c = new Allocation(67);
        
        
        
        
        table.put(0, a);

        
        System.out.println(table.toString());
        
    }

}
