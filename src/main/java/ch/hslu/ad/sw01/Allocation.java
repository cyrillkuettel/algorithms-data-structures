package ch.hslu.ad.sw01;

import java.util.Objects;

/**
 *
 * @author cyrill
 */


public final class Allocation implements Comparable<Allocation> {

    private final int address; //
    
    private int size; //TODO:  Max value should not exceed 1GB (1024^3 byte)
    static int nextAddress = 0; // // the address of the next allocation

    public Allocation(final int size) {
            this.size = size;
            this.address = nextAddress;
            nextAddress += size; // nextAddress is defined as the added sum of all allocated Allocations.size
        
    }

    @Override
    public int compareTo(final Allocation other) {
        return (this.address - other.address);
    }

    @Override
    public final int hashCode() {
        
        return Integer.hashCode(address);
        
    }

    @Override
    public final boolean equals(final Object object) {
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

    public int getAddress() {
        return address;
    }

    public static void setNextAddress(int nextAddress) {
        Allocation.nextAddress = nextAddress;
    }

    public int getSize() {
        return size;
    }

    public static int getNextAddress() {
        return nextAddress;
    }

}
