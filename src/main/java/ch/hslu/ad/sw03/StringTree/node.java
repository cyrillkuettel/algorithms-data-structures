package ch.hslu.ad.sw03.StringTree;

import ch.hslu.ad.sw03.SimpleTree.*;

/**
 *
 * @author cyrill
 */
public class node {

    String value;
    boolean empty = true;
    node left;
    node right;

    public node(final String value) {
        empty = false;
        this.value = value;
        left = right = null;
    }

    public node(final String value, final boolean isInFactEmpty) {
        empty = isInFactEmpty;
        this.value = value;
        left = right = null;
    }
    
    public node() {
    }

    @Override
    public String toString() {
        return "Node {" + "value=" + value + '}';
    }

    public boolean isEmpty() {
        return empty;
    }
    
    

}
