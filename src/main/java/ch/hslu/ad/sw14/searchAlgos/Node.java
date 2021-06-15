package ch.hslu.ad.sw14.searchAlgos;

import java.awt.Color;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author cyrill
 */
public class Node implements Comparable<Node> {

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
        this.color = Color.WHITE;
        this.label = label;
        this.name = name;
    }

    public Node(String name) {
        this.adj = new HashSet<>();
        this.color = Color.WHITE;
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public Set<Node> getAllAdjaNodes() {
        return this.adj;
    }

    public void addAdjNodes(Node node) {
        this.adj.add(node);
    }

    public void addAdjNodes(Node... node) { // to put multiple in at once
        
      for (Node element : node) {
          adj.add(element);
      }
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
        return (other.name == this.name);

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
        return Objects.hash(name);
    }

    /**
     * compares Two nodes based on their names 
    */
    @Override 
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);

    }
    

}
