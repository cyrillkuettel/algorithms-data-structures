package ch.hslu.ad.sw01;

import java.util.Objects;

/**
 *
 * @author cyrill
 */
// Klasse, welche den Speicherbereich (egal ob frei oder belegt) eindeutig identifiziert.
// TO DO: keep track of free blocks with linked list for example 
public final class Allocation implements Comparable<Allocation> {

    private long address = 0; //
    private long size; //TODO:  Max value should not exceed 1GB (1024^3 byte)
    static long nextAddress = 0; // // the address of the next allocation

    public Allocation(final long size) {
        if (nextAddress == 0) { // only the first time
            this.size = size;
            nextAddress += size; 
        } else {
            this.size = size;
            this.address = nextAddress; 
            nextAddress += size; // nextAddress is defined as the added sum of all allocated Allocations.size
        }
    }

    @Override
    public int compareTo(final Allocation other) {
        if (other.address > this.address) {
            return 1;
        }
        if (other.address < this.address) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Allocation)) {
            return false;
        }
        final Allocation other = (Allocation) object;
        return (other.address == this.address);
    }

    // should look like: Allocation[Address:0; Size:16]
    @Override
    public String toString() {
        return "Allocation[Address:" + getAddress() + "; Size:" + getSize() + ']';
    }

    public long getAddress() {
        return address;
    }

    public long getSize() {
        return size;
    }

    public static long getNextAddress() {
        return nextAddress;
    }

    public static void setNextAddress(long nextAddress) {
        Allocation.nextAddress = nextAddress;
    }
    

}
