package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import java.util.stream.Stream;

/**
 *
 * @author cyrill
 */
public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(100));
        
        list.add(node1);
        list.add(node2);



    }

    public LinkedList() {
        head = new Node(null);
        size = 0;
    }

    public void add(Node node) { // am Anfang anfügen

        //die Referenz des Neuen elements setzen auf head
        
        node.setNext(head);
        // die vorherige Referenz auf diese Node setzen. 
        
        size++;

    }

    @Override
    public String toString() {
        // how to iterate ??
        return "LinkedList{" + '}';
    }

    public boolean remove(int index) { // remove 
        if (index < 1 || index > getSize()) { // catch invalid index
            return false;
        }
        // TODO: implement remove
        return true;
    }

    public int getSize() {
        return size;
    }

}
