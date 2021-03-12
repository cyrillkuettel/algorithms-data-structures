package ch.hslu.ad.sw03.SimpleTree;

import java.util.ArrayList;
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

    String line;
    ArrayList<node> arrayList;

    /**
     *
     *
     * @param growingBranch // example: branch[" / \\ / \\ "];
     * @param abstand
     */
    public BranchGrower(String growingBranch, int abstand) {
        this.abstand = abstand;
        this.branch = growingBranch; // the branch from where to grow
    }

    public void growBranchNtimes(String inp, int lines) {
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

    public BranchGrower(ArrayList<node> arrayList, String line) { // the line is the printed sequence
        this.line = line;
        this.arrayList = arrayList;
    }

    public String drawSingleBranch() { // TODO make not void but String return value
        int i = 0;
        String[] str = line.split("");
        // aufpassen wegen node.value.length > 1 -> TODO special case. Hier mit regex abfangen, dann etwa mittig zum regex den "/" printen, und zu i die length des gemachten regex elements addieren. 
        // write the first line , pass in arrayList and line. From line then is derrrived the rest Of the branch. so pass this then into growBranchNtimes.
        // regex match word / letter /number whatever

        for (int j = 1; j < str.length-1; j++) {
            if (isNumeric(str[i])) {
                str[i - 1] = "/";
                str[i] = " ";
                str[i + 1] = "\\";
            }
        }
       String returnString = String.join("", str);
        System.out.println(returnString);
        return returnString;
        // return string in the end, which is then a arugment for the next one. 
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String branch = "       / \\              / \\       ";
        new BranchGrower(branch, 1);

    }

}
