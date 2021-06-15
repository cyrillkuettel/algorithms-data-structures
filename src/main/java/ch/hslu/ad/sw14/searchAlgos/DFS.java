package ch.hslu.ad.sw14.searchAlgos;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class bfs {

    private static final Logger LOG = LogManager.getLogger(bfs.class);

    public static void bfs(final Node start) {
        PriorityQueue<Node> wait = new PriorityQueue<>();

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

    public static void dfs(final Node start) {
        start.setColor(Color.GRAY);
        for (Node n : start.getAllAdjaNodes()) {
            if (n.getColor().equals(Color.WHITE)) {
                dfs(n);
            }
        }
        LOG.info(start);
        start.setColor(Color.BLACK);
    }

    /*
    
        The printing seems to not work in the right order
    */
    public static void dfs2_alphabetically(final Node start) {
        Stack<Node> processingOrder = new Stack<>();
        LinkedList<Node> wait = new LinkedList<>();

        boolean found;

        start.setColor(Color.GRAY);
        wait.add(0, start);

        while (!wait.isEmpty()) {
            Node node;
            if (wait.size() > 1) {
                // it does prever the Alphabeticallly "higher" Elements
                node = Collections.min(wait);
//                System.out.println("Queue is : " + wait.toString() + "collections min was " + node );
//                System.out.println();
            } else {
                node = wait.getFirst();

            }

            found = false;

            for (Node n : node.getAllAdjaNodes()) {
                
                if (n.getColor().equals(Color.WHITE)) {
                    n.setColor(Color.GRAY);
                    wait.add(0, n);
                    found = true;
                    break;
                } else {
                     System.out.println(n.getColor());
                }
            }

            if (!found) {
                LOG.info("Processing " + node);
                node.setColor(Color.BLACK);
                wait.remove(node);
            }
        }
    }

    public static void main(String[] args) {

        Node a = new Node("a");

        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        b.addAdjNodes(c, d);
        a.addAdjNodes(b, d, f, c);
        d.addAdjNodes(a, c);
        e.addAdjNodes(g);
        f.addAdjNodes(a,    c);
        g.addAdjNodes(e, d);
        
       

        dfs(a);
    }

}
