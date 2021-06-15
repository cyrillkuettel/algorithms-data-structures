package ch.hslu.ad.sw14.searchAlgos;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class BFS {

    private static final Logger LOG = LogManager.getLogger(DFS.class);

    public static void bfs(final Node start) {
        Queue<Node> wait = new LinkedList<>();

        start.setColor(Color.GRAY);

        wait.add(start);  // put 

        while (!wait.isEmpty()) {
            Node node = wait.remove();
            LOG.info(node.toString()); // processing Node
            node.setColor(Color.BLACK);

            for (Node n : node.getAllAdjaNodes()) {
                if (n.getColor().equals(Color.WHITE)) {
                    n.setColor(Color.GRAY);
                    wait.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Setting up the Graph
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        b.addAdjNodes(c, d);
        a.addAdjNodes(b, f, c);
        d.addAdjNodes(a, c);
        e.addAdjNodes(g);
        f.addAdjNodes(a, c);
        g.addAdjNodes(e, d);

        bfs(a);
    }
}
