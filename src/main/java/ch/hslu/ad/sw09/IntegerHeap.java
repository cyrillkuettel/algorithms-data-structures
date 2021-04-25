package ch.hslu.ad.sw09;

/**
 *
 * @author cyrill
 */
public interface IntegerHeap {

    /*
    Elemente einfügen
  - Elemente entnehmen
  - Heap reorganisieren
  - gleich grosse Elemente
  - voller Heap
  - leerer Heap
     */

    void insert(final int inp);

    void remove(final int inp);


    boolean isEmpty();

    boolean isFull();

}
