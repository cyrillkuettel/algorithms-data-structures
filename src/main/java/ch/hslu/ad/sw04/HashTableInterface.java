package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public interface HashTableInterface {

    public boolean put(int key, Allocation allocationValue) throws Exception;

    public Allocation get(int key);

    public boolean isEmpty();

    public int size();

}
