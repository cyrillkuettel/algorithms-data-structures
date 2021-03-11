package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// source:https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram

public class BTreePrinterTest {

    private static Knoten<Integer> test1() {
        Knoten<Integer> root = new Knoten<Integer>(2);
        Knoten<Integer> n11 = new Knoten<Integer>(7);
        Knoten<Integer> n12 = new Knoten<Integer>(5);
        Knoten<Integer> n21 = new Knoten<Integer>(2);
        Knoten<Integer> n22 = new Knoten<Integer>(6);
        Knoten<Integer> n23 = new Knoten<Integer>(3);
        Knoten<Integer> n24 = new Knoten<Integer>(6);
        Knoten<Integer> n31 = new Knoten<Integer>(5);
        Knoten<Integer> n32 = new Knoten<Integer>(8);
        Knoten<Integer> n33 = new Knoten<Integer>(4);
        Knoten<Integer> n34 = new Knoten<Integer>(5);
        Knoten<Integer> n35 = new Knoten<Integer>(8);
        Knoten<Integer> n36 = new Knoten<Integer>(4);
        Knoten<Integer> n37 = new Knoten<Integer>(5);
        Knoten<Integer> n38 = new Knoten<Integer>(8);

        root.links = n11;
        root.rechts = n12;

        n11.links = n21;
        n11.rechts = n22;
        n12.links = n23;
        n12.rechts = n24;

        n21.links = n31;
        n21.rechts = n32;
        n22.links = n33;
        n22.rechts = n34;
        n23.links = n35;
        n23.rechts = n36;
        n24.links = n37;
        n24.rechts = n38;

        return root;
    }

    private static Knoten<Integer> test2() {
        Knoten<Integer> root = new Knoten<Integer>(2);
        Knoten<Integer> n11 = new Knoten<Integer>(7);
        Knoten<Integer> n12 = new Knoten<Integer>(5);
        Knoten<Integer> n21 = new Knoten<Integer>(2);
        Knoten<Integer> n22 = new Knoten<Integer>(6);
        Knoten<Integer> n23 = new Knoten<Integer>(9);
        Knoten<Integer> n31 = new Knoten<Integer>(5);
        Knoten<Integer> n32 = new Knoten<Integer>(8);
        Knoten<Integer> n33 = new Knoten<Integer>(4);

        root.links = n11;
        root.rechts = n12;

        n11.links = n21;
        n11.rechts = n22;

        n12.rechts = n23;
        n22.links = n31;
        n22.rechts = n32;

        n23.links = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printKnoten(test1());
        BTreePrinter.printKnoten(test2());

    }
}

class Knoten<T extends Comparable<?>> {
    Knoten<T> links, rechts;
    T data;

    public Knoten(T data) {
        this.data = data;
    }
}

