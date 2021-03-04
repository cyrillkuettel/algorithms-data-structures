package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;

/**
 *
 * @author cyrill
 */
public class Node {

    private Node next;
    private Node last;
    
    Allocation value;

    public Node() {
    }
    

    public Node(final Allocation newValue) {
        value = newValue;
    }

    public Node(final Allocation newValue, final Node next) {
        value = newValue;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Allocation getValue() {
        return value;
    }
    
    

    @Override
    public String toString() {
        return "Node{ Value = " + getValue() + ", next = " + next + '}';
    }



    
 
    
}
