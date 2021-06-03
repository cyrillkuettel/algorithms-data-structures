package ch.hslu.ad.sw13;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author cyrill
 */
public class Node implements Comparator<Node> {

    String name; // A
    int label;

    /**
     *
     * @param name String
     * @param label Int
     */
    public Node(String name, int label) {
        this.label = label;
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.label < node2.label) {
            return -1;
        }
        if (node1.label > node2.label) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        final Node other = (Node) obj;
        return (other.label == this.label);

    }

    @Override
    public String toString() {
        if (label == Integer.MAX_VALUE) {
            return "Node{" + name + ", " + "∞" + '}';
        }
        return "Node{" + name + ", " + label + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

}
