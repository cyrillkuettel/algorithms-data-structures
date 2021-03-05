package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import java.util.EmptyStackException;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class LinkedList implements Iterable<Node> {

    private Node head;
    private int size;

    private static final Logger LOG = LogManager.getFormatterLogger(LinkedList.class);

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(100));
    }

    public LinkedList() {
        head = new Node(null, null);
        size = 0;
    }

    public void add(Node node) { // add new at top
        if (head.getNext() == null) { // only when empty
            head.setNext(node);
            node.setNext(null); // the last element is null
        } else {
            node.setNext(head.getNext());
            head.setNext(node);
        }
        size++;
    }

    public boolean exists(Node n) {
        Node next = head.getNext();
        while (next != null) {
            if (next.getValue().equals(n.getValue())) {
                return true;
            }
            next = next.getNext();
        }
        return false;
    }

    public Node pop() throws EmptyStackException {
        if (getSize() == 0) {
            throw new EmptyStackException();
        }
        Node topElement = new Node();
        topElement = head.getNext();
        head.setNext(topElement.getNext()); // set new reference. (eliminate Top Element)
        size--;
        return topElement;
    }

    @Override
    public String toString() {
        // this method simply shows the chain. 
        String allString = "null -> ";

        Node next = new Node();
        next = head.getNext();
        int count = 0;

        do {
            allString += "[" + count + "]" + " -> ";
            count++;
            next = next.getNext();
        } while (next != null);

        return allString += "null";
    }

    public boolean removeAtIndex(int index) {
        if (index < 0 || index > getSize()) { // catch potential invalid index
            LOG.warn("Invalid Index: " + index);
            return false;
        }
        if (index == 0) { // if only one element
//            Node newHead = new Node(null, null);
            head.setNext(null);
            size--;
            return true;
        }

        Node oneElementprevious = new Node();
        oneElementprevious = head.getNext(); //first Element
        // if index = 1, this means we should remove the second lowest element

        for (int i = 0; i < index - 1; i++) { // index is zero-based. 
            // loop until JUST preceding the element to delete
            oneElementprevious = oneElementprevious.getNext();
        }

        Node theElementAfter = new Node();
        theElementAfter = oneElementprevious.getNext().getNext(); // skip the element we want to delete
        oneElementprevious.setNext(theElementAfter); // change reference. 
        size--;
        return true;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Node> iterator() {

        Iterator<Node> it = new Iterator<Node>() {
            Node nextItem = head;
            private int size = getSize();

            @Override
            public boolean hasNext() {
                return nextItem.getNext() != null;
            }

            @Override
            public Node next() {
                return nextItem = nextItem.getNext();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
