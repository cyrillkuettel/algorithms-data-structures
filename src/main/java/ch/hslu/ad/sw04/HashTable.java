package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class HashTable implements HashTableInterface {

    private int LEN = 2;
    private boolean empty;
    private Entry[] arr = new Entry[LEN];

    private static final Logger log = LogManager.getFormatterLogger(HashTable.class);

    public HashTable() {
        this.arr = new Entry[LEN];
        this.empty = true;

    }

    @Override
    public boolean put(int key, Allocation allocationValue) throws Exception {
        this.empty = false;
        Integer index = calculateHashValueByKey(key);

        index = Math.abs(index); // Negative int hash abfangen

        Entry addEntry = new Entry(key, allocationValue); // neuer (Object) Eintrag.
        index = Sondieren(arr, index, key);

        if (index == null) {
            log.warn("Collision detection logic failed. Array is full. Did not find empty slots to store this key.  ");
            return false;
        }

        arr[index] = addEntry; // element Hinzufügen
        return true; // Everything successfull
    }

    private int calculateHashValueByKey(int key) {
        int hashValue = Integer.hashCode(key);
        int index = hashValue % LEN;
        return index;
    }

    private Integer Sondieren(Entry[] arr, int index, int key) {
        if (index >= LEN) {
            log.warn("Abbruch. Ungültiger index. ");
            return null;
        }

        try {

            while (arr[index] != null && index < LEN) {
                log.info("Sondierung läuft. current Index = " + index);
                index++;
            }
            if (arr[index] == null) {
                return index;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warn("Array zu klein / index zu gross", e);

        }

        return null;
    }

    public Entry getEntry(int key) {
        int index = calculateHashValueByKey(key);
        while (index < LEN) {
            if (arr[index] != null) {
                if (arr[index].getKey() == key) {
                    return arr[index];
                }
            }
            index++;
        }
        return null;
    }

    int getStorageCapacity() {
        return LEN;
    }

    @Override
    public String toString() {
        return "Storage of Entries : " + Arrays.toString(arr);
    }

    @Override
    public Allocation get(int key) {
        return getEntry(key).getValue();

    }

    public Entry[] getarr() {
        return arr;
    }

    public void setSize(int LEN) {
        this.LEN = LEN;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    @Override
    public int size() {
        return LEN;
    }

}
