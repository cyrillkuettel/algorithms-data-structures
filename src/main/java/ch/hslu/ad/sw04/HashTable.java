package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class HashTable {

    private static final int LEN = 10;
    private static final Logger log = LogManager.getFormatterLogger(HashTable.class);

    private Entry[] arr = new Entry[LEN];

    public HashTable() {
        this.arr = new Entry[LEN];

    }

    public void put(int key, Allocation value) {

        int hashValue = Integer.hashCode(key);
        int index = hashValue % LEN;
        System.out.println(index);
        if (index < 0) {
            log.info(" Negative Hash Index...");
            index = Math.abs(index);
        }

        Entry addEntry = new Entry(key, value);

            // wenn arr[index] == null, ist der slot frei, muss man nicht Sondieren. 
            // Duplikate im key werden mit (arr[index].getKey() == key) gesucht.
            
        while (arr[index] != null && index < LEN && arr[index].getKey() == key) {
            System.out.println("loop");
            index++;
        }

        if (index == LEN) {
            log.warn("Sondierung hat nicht genug Plätze.");
        } else {
            arr[index] = addEntry; // element Hinzufügen
        }

    }

    public Entry get(int key) {

        int hashValue = Integer.hashCode(key);
        int index = hashValue % LEN;

        while (index < LEN) {
            log.info("Hash was negative! ");
            if (arr[index].getKey() == key) {
                return arr[index];
            }
            index++;
        }

        return null;

    }

    int getSize() {
        return LEN;
    }

    @Override
    public String toString() {

        return Arrays.toString(arr);
    }

}
