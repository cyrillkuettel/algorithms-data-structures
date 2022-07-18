package ch.hslu.ad.sw03;

/**
 *
 * @author cyrill
 */
public interface TreeInterface {

    boolean isEmpty();

    void add(node node, int value);

    void add(int value);

    node searchNode(node node, int value);

    node search(int value);

    void printInOrder(node node);

    void remove(int value);

}
