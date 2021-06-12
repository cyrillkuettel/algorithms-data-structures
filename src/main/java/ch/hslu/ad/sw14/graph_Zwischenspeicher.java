package ch.hslu.ad.sw14;

/**
 *
 * @author cyrill
 */
public class graph_Zwischenspeicher {
        int[][] adj = {
        //a  b  c  d  e  f  g       // if neccessary expand this to the task given at hand

        {0, 1, 2, 2, 0, 0, 0}, // a
        {1, 0, 0, 3, 0, 0, 6}, // b
        {2, 0, 0, 1, 1, 0, 0}, // c
        {2, 3, 1, 0, 0, 1, 0}, // d
        {0, 0, 1, 0, 0, 3, 0}, // e
        {0, 0, 0, 1, 3, 0, 3}, // f
        {0, 6, 0, 0, 0, 3, 0}};// g
}
