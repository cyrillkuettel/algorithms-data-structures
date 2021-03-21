package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public interface HashTableInterface {

    public Allocation search();

    public void put();

    public Allocation get();

    public void remove();

    public boolean containsValue();

    public boolean containsKey();

    public boolean isEmpty();

    public int size();

}
