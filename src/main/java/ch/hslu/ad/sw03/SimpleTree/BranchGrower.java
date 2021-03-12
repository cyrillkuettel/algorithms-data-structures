package ch.hslu.ad.sw03.SimpleTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author cyrill
 */
public class BranchGrower {

    int abstand; // IS abstand constant?? yes I  think it is
    String branch;

    /**
     *
     * @param growingBranch // example: branch[" / \\ / \\ "];
     * @param abstand
     */
    public BranchGrower(String growingBranch, int abstand) {
        this.abstand = abstand;
        this.branch = growingBranch; // the branch from where to grow
        growBranchNtimes(branch, abstand, 4);

    }

    public void growBranchNtimes(String inp, int abstand, int lines) {
        // loop lines times; TODO

        System.out.println(inp);

        for (int n = 0; n < lines; n++) { // how many lines to print

            String[] str = inp.split("");
            for (int i = 1; i < str.length - 1; i++) {

                if (str[i].contains("/")) {
                    str[i - 1] = str[i];
                    str[i] = " ";
                    str[i + abstand + 2] = str[i + abstand + 1];
                    str[i + abstand + 1] = " ";

                }
            }

            String returnSTring = String.join("", str);
            System.out.println(returnSTring);
            inp = returnSTring;
            abstand += 2;
        } // lines times
    }

    public static void main(String[] args) {
        String branch = "       / \\              / \\       ";
        new BranchGrower(branch, 1);

    }

}
