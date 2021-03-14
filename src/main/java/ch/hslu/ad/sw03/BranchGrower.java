package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class BranchGrower {

    private static final Logger log = LogManager.getFormatterLogger(BranchGrower.class);
    int abstand; // IS abstand constant?? yes I  think it is
    String branch;

    String line;
    ArrayList<node> arrayList;

    /**
     *
     *
     * @param growingBranch // example: branch[" / \\ / \\ "];
     * @param abstand Der Abstand zwischen den auseinandergehenden Branches. Initial = 1
     */
    public BranchGrower(String growingBranch) {
        this.abstand = 1;
        this.branch = growingBranch; // the branch from where to grow
    }

    public void growBranchNtimes(String inp, int lines) {
        // loop lines times; TODO

//        System.out.println(inp);
        if (inp == null) {
            log.error("Error in growBranchNtimes(). inp is null! ");
            return;
        }

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

    public String drawSingleBranch() { 

        // aufpassen wegen node.value.length > 1 -> TODO special case. Hier mit regex abfangen, dann etwa mittig zum regex den "/" printen, und zu i die length des gemachten regex elements addieren. 
        // write the first line , pass in arrayList and line. From line then is derrrived the rest Of the branch. so pass this then into growBranchNtimes.
        // regex match word / letter /number whatever
//        char[] str = new char[line.length() - 1];
//
//        for (int k = 0; k < line.length()-1; k++) {
//            str[k] = line.charAt(k);
//        }
//        log.info(Arrays.toString(str));
        String[] str = line.split("");
//        log.info(Arrays.toString(str));

        for (int j = 1; j < str.length - 1; j++) {

            if (isNumeric(str[j])) { // for strings, this has to be generalized. A functin to detect the node.values.
//                log.info("isNumeric");
                str[j - 1] = "/";
                str[j] = " ";
                str[j + 1] = "\\";
            }
        }

        String returnString = "failed";

        try {
            returnString = String.join("", str);
        } catch (Exception e) {
            log.info("String.join failed.", e);
        }

        System.out.println(returnString);
        return returnString;

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
        new BranchGrower(branch);

    }

}
