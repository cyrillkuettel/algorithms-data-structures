package ch.hslu.ad.sw14.searchAlgos;

import java.awt.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class DFS {

    private static final Logger LOG = LogManager.getLogger(DFS.class);
    
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

   

    public static void main(String[] args) {

        Node a = new Node("a");

        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        b.addAdjNodes(c, d);
        a.addAdjNodes(b,  f, c);
        d.addAdjNodes(a, c);
        e.addAdjNodes(g);
        f.addAdjNodes(a,    c);
        g.addAdjNodes(e, d);
        
       

        dfs(a);
    }

}
