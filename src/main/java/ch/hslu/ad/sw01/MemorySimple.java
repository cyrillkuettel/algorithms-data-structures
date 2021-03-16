package ch.hslu.ad.sw01;

/**
 *
 * @author cyrill
 */
public class MemorySimple extends Memory {

    public MemorySimple(final int initialValue) {
        super(initialValue);
    }

    @Override
    public String toString() {
        return "MemorySimple[Belegt: " + getBelegt() + "; Frei: " + getFrei() + ']';
    }

}
