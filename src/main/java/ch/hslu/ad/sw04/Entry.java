package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public class Entry {

    private int key;
    private Allocation value;

    public Entry(int key, Allocation value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public Allocation getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry{" + "key=" + key + ", value=" + value + '}';
    }

}
