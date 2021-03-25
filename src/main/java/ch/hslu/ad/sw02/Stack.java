package ch.hslu.ad.sw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public final class Stack {

    private int size = 10;
    private int[] store = new int[size];

    private int count = 0; // count always points to the next available
    private static final Logger log = LogManager.getFormatterLogger(Stack.class);
    private List<Integer> minList = new ArrayList<>(); // keep track of occuring Minima. 

    public Stack() {

    }

    public void push(int x) {

        if (minList.size() == 0) { //size is zero indexed
            minList.add(x);
        }
        if (x < minList.get(minList.size() - 1)) { //  comparing new Element with the last known Minimum
            minList.add(x); // found new global Minimum

        }
        if (count > store.length - 1) {
            ensureCapacity();
        }
        store[count] = x;
        count++;

    }

    public void pop() {

        int lastMinimumIndex = minList.size() - 1;
        System.out.println("[popping]   lastMinimumIndex = " + lastMinimumIndex);

        if (this.top() == minList.get(lastMinimumIndex)) { // if the element we remove, is the current minElement, remove from minList aswell
            minList.remove(lastMinimumIndex);
        }
        store[count - 1] = 0; // set the last index to zero (is this even necessary??)
        count--;
    }

    public int top() {
        return store[count - 1];
    }

    public int getMin() {

        int s = minList.size();
        if (s == 0) {
            return 0;
        }
        return minList.get(s - 1);

    }

    public void ensureCapacity() {

        this.size = this.size * 2;
        int[] temp = new int[size];

        for (int i = 0; i < count; i++) {
            temp[i] = this.store[i];
        }
        this.store = temp;
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
        return Arrays.toString(store);
    }

}
