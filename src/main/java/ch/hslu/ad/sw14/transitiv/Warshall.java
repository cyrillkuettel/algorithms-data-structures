package ch.hslu.ad.sw14.transitiv;

import ch.hslu.ad.sw13.PrettyPrinter;
import java.util.Arrays;

/**
 *
 * @author cyrill
 */
public class Warshall {

    int[][] adj = {
        //a  b  c  d  e  f  g  h     // if neccessary expand this to the task given at hand

        {0, 0, 1, 1, 0, 0}, // a
        {0, 0, 0, 0, 0, 0}, // b
        {1, 0, 0, 0, 0, 0}, // c
        {1, 0, 0, 0, 1, 1}, // d
        {0, 0, 0, 1, 0, 0}, // e
        {0, 0, 0, 1, 0, 0}}; // f};// g}; //h

    public final int noOfNodes = adj[0].length;

    public Warshall() {
        prettyPrint(transitiveClosure());

    }

    public int[][] transitiveClosure() {
        int[][] transClosure = new int[noOfNodes][noOfNodes];

        for (int n = 0; n < noOfNodes; n++) {
            transClosure[n] = Arrays.copyOf(adj[n], noOfNodes);
        }
        for (int y = 0; y < noOfNodes; y++) {
            for (int i = 0; i < noOfNodes; i++) {
                if (transClosure[i][y] > 0) {
                    for (int j = 0; j < noOfNodes; j++) {
                        if (transClosure[y][j] > 0) {
                            transClosure[i][j] = 1;
                        }
                    }
                }
            }
        }
        return transClosure;
    }

    public void prettyPrint(int[][] nums) {
        final PrettyPrinter printer = new PrettyPrinter(System.out);
        printer.print(IntegerToStringArray(nums));
    }

    public String[][] IntegerToStringArray(int[][] nums) {

        String[][] answer = new String[noOfNodes][noOfNodes];

        int count = 0;
        for (int[] e : nums) {
            int count2 = 0;
            for (int el : e) {
                answer[count][count2] = Integer.toString(el) + " ";
                count2++;
            }
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        new Warshall();
    }
}
