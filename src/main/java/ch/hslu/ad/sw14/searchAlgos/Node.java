package ch.hslu.ad.sw14.searchAlgos;

import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author cyrill
 */
public class Node implements Comparator<Node> {

    Color color;
    String name; // A
    int label;
    Set<Node> adj;

    /**
     *
     * @param name String
     * @param label Int
     */
    public Node(String name, int label) {
        this.adj = new HashSet<>();
        this.color = Color.white;
        this.label = label;
        this.name = name;
    }

    public Node(String name) {
        this.adj = new HashSet<>();
        this.color = Color.white;
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    Set<Node> getAllAdjaNodes() {
        return this.adj;
    }

    public void addAdjNodes(Node node) {
        this.adj.add(node);
    }

    public void addAdjNodes(Node... node) { // to put multiple in at once
        this.adj.addAll(Arrays.asList(node));
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
