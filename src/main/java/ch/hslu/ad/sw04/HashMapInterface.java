package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public interface HashMapInterface {
    public boolean hasKey();
    public void getKey();
    
    public Allocation search();
    public void add();
    public void remove();
    
    public boolean contains();
    
    
    
}
