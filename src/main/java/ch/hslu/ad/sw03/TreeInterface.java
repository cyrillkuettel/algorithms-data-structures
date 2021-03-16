package ch.hslu.ad.sw03;

/**
 *
 * @author cyrill
 */
public interface TreeInterface {

    boolean isEmpty();

    public void add(node node, int value);

    public void add(int value);

    void search(node node, int value);

    void search(int value);

    void printInOrder(node node);

    void remove(int value);

}
