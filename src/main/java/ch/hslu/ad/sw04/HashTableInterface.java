package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */


import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
 interface HashTableInterface {

    public boolean put(int key, Allocation allocationValue) throws Exception;

    public Allocation get(int key);

    public boolean isEmpty();

    public int size();

}

