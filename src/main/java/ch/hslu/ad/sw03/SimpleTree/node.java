package ch.hslu.ad.sw03.SimpleTree;

/**
 *
 * @author cyrill
 */
public class node {

    Integer value;
    boolean empty = true;
    node left;
    node right;

    public node(final int value) {
        empty = false;
        this.value = value;
        left = right = null;
    }

    public node(final int value, final boolean isInfactEmpty) {
        empty = isInfactEmpty;
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
