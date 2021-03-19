package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import java.util.Objects;

/**
 *
 * @author cyrill
 */
public class HashTable {

    private static final int LEN = 10;


    private Allocation[] arr = new Allocation[LEN];

    public HashTable() {
        this.arr = new Allocation[LEN];
    }
    
    private class entry {

        private int key;
        private String value;

        public entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    

    public void add(Allocation input) {
        int hashValue = Objects.hashCode(input);

        System.out.println("hashValue ist " + hashValue);

        int index = hashValue % LEN;
        System.out.println("hashValue % LEN = " + index);

    }

    int getSize() {
        return LEN;
    }

}
