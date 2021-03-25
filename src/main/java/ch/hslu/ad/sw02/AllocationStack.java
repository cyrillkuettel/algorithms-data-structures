package ch.hslu.ad.sw02;

/**
 *
 * @author cyrill
 */
import ch.hslu.ad.sw01.Allocation;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AllocationStack {

    private int size = 10;
    private Allocation[] storage;
    private int count = 0; // count always poAllocations to the next available

    public AllocationStack() {
        storage = new Allocation[size];
    }

    public void push(Allocation x) {

        if (count > storage.length - 1) {
            ensureCapacity();
        }
        storage[count] = x;
        count++;

    }

    public Allocation pop() {
        count--;
        return storage[count];
        
    }

    public Allocation top() {
        return storage[count - 1];
    }

    public void ensureCapacity() {

        size *= 2;
        
        Allocation[] temp = new Allocation[size];

        for (int i = 0; i < storage.length; i++) {
            temp[i] = storage[i];
        }
        storage = temp;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(3);
        s.push(4);
        s.push(100);

    }

    public void setSize(int size) {
        this.size = size;

    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }

}
