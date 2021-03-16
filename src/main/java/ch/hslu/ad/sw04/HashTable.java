package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public class HashTable {
    // bei Immutable Objekten kann man der HashWert gecached werden.
    //er muss nur bei der Erzeugung berechnet werden. 
    
    
    // Eigenschaften unverändernt
    /*
    alle attribute final
    klasse selber final.
    keine Setter methoden.
    */
    private static final int LEN = 10;
    // LIst of allocation objecs.

    private Allocation[] arr = new Allocation[LEN];

    public void add(Allocation input) {
        int hashValue = input.hashCode();
        System.out.println("hashValue ist " + hashValue);

        int index = hashValue % LEN;
        System.out.println("hashValue % LEN = " + index);

    }
    

    int getSize() {
        return LEN;
    }

}
