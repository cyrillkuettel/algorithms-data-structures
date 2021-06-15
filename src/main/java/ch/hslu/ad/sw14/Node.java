package ch.hslu.ad.sw14;

import java.awt.Color;
import java.util.Comparator;

/**
 *
 * @author cyrill
 */
// Node class  
class Node implements Comparator<Node> {

    public int node;
    public int cost;
    public Color color;

    public Node() {
    } //empty constructor 

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost) {
            return -1;
        }
        if (node1.cost > node2.cost) {
            return 1;
        }
        return 0;
    }

    public void setColor(Color c) {
        this.color = c;
    }

}
