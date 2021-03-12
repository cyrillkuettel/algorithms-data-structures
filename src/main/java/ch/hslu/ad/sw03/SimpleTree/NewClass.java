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
public class NewClass {

    private int abstand = 1; // has to be hard coded!!

    public static void main(String[] args) {

        new NewClass();
    }

    public String growBranchOneTime(String inp) {
        String[] str = inp.split("");

        List<String> list = new LinkedList<>(Arrays.asList(str));
        System.out.println(list);

        ListIterator<String> li = list.listIterator(0);
        int count = 0;
        while (li.hasNext()) {
            String el = li.next();
            if (el == "/" && li.hasPrevious()) {
                list.remove(li.previous()); // vor dem "/" ein whitespace wegnehmen
                list.add(count, " ");

            }
            if (el == "\\" && li.hasNext()) {
                list.remove(li.next()); // vor dem "/" ein whitespace wegnehmen
                list.add(count - 1, " ");
            }
            count++;
        }

        System.out.println(list);

        return "";
    }

    public String growth(String inp, int abstand) { // should be able to call itself recursively. this requirs  1 parameter abstand whic will be incremented. And a paramter maxDepth. (= branchsize) for base case. 

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
        return returnSTring;
    }

    public NewClass() {
        String branch = "       / \\              / \\       ";
        System.out.println(branch);
        branch = growth(branch, abstand);
        System.out.println(branch);
        abstand += 2;
        branch = growth(branch, abstand);
        System.out.println(branch);
        abstand += 2;
        branch = growth(branch, abstand);
        System.out.println(branch);
        abstand += 2;

    }

    /*
       a
      / \
     /   \
    /     \
   /       \
   b       c
  / \     / \
 /   \   /   \
 d   e   f   g
/ \ / \ / \ / \
h i j k l m n  o
     */
}
