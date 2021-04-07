
package ch.hslu.ad.sw06.Pferderennen;

/**
 * Schnittstelle für die Zutrittsverwaltung geschützter Bereiche.
 */
public interface Synch {

    public void acquire() throws InterruptedException;

    public void release();
}
