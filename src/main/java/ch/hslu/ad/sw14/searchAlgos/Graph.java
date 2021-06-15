package ch.hslu.ad.sw14.searchAlgos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class Graph {

    private static final Logger LOG = LogManager.getFormatterLogger(Graph.class);


    static String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
    int[][] adj = {
       //a  b  c  d  e  f  g  h     // if neccessary expand this to the task given at hand

        {0, 0, 0, 0, 0, 0, 0, 0}, // a
        {0, 0, 0, 0, 0, 0, 0, 0}, // b
        {0, 0, 0, 0, 0, 0, 0, 0}, // c
        {0, 0, 0, 0, 0, 0, 0, 0}, // d
        {0, 0, 0, 0, 0, 0, 0, 0}, // e
        {0, 0, 0, 0, 0, 0, 0, 0}, // f
        {0, 0, 0, 0, 0, 0, 0, 0},//  g
        {0, 0, 0, 0, 0, 0, 0, 0 }};//h

    Iterable<Node> getAllAdjaNodes(Node node) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
