package ch.hslu.ad.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface binaryTreeInterface { // TODO: interface

}
// helper: https://stackoverflow.com/questions/11263244/java-how-do-i-implement-a-generic-binary-search-tree;

class Binärbaum<T extends Comparable<T>> {

    private static final Logger LOG = LogManager.getFormatterLogger(Binärbaum.class);

    //Aufgabe: 10 eindeutige geordnete Elemente erstellen
/*
     d.) Implementieren Sie auf dem Baum nun die search()-Methode.
    
     f.)        In der Aufgabe 3.f.) haben Sie bereits einen rekursiven Algorithmus
             zur Traversierung des Baumes in der «Inorder»-Semantik entworfen.
             Implementieren Sie nun den Algorithmus und testen Sie ihn aus!
    
    TODO: 
        Zuerst generisch machen, dass die print methode funktioniert. 
        schöne print methode machen
        suchen: was wenn element nicht existiert. 
        löschen
        inOrderTraverse
        
     */
    protected Knoten<T> wurzel;

    public Binärbaum(T value) {
        this.wurzel = new Knoten<T>(value);
    }

    class Knoten<T extends Comparable<T>> {

        private T inhalt;
        private Knoten<T> links, rechts;

        public Knoten(T inhalt) {

            this.inhalt = inhalt;
            this.links = this.rechts = null;

        }

        @Override
        public String toString() {
            return "Knoten{" + "inhalt=" + inhalt + '}';
        }

    }

    public void inOrderTraverse() {
        if (wurzel != null) {

        }
    }

    public void suchen(Knoten<T> knoten, T inhalt) {
        // what to do if element does not exist? 

        if (inhalt.compareTo(knoten.inhalt) < 0) {
            if (knoten.links.inhalt == inhalt) {
                System.out.println("found links");
            } else {
                suchen(knoten.links, inhalt);
            }
        } else {
            if (knoten.rechts.inhalt == inhalt) {

                System.out.println("found rechts");
            } else {
                suchen(knoten.rechts, inhalt);
            }
        }

    }

    public void suchen(T inhalt) {
        if (istLeer()) {
            LOG.warn("Can't search a empty tree...");
        } else {
            suchen(wurzel, inhalt);
        }
    }

    public void einfügen(T value) {
        if (istLeer()) {
            wurzel = new Knoten<>(value); // base case r
        } else {
            einfügen(wurzel, value);
        }
    }

    public void einfügen(Knoten<T> knoten, T inhalt) {

        if (inhalt.compareTo(knoten.inhalt) < 0) {
            if (knoten.links == null) {
                knoten.links = new Knoten<>(inhalt);
            } else {
                einfügen(knoten.links, inhalt); // go one niveau down (Left side)
            }
        } else {
            if (knoten.rechts == null) {
                knoten.rechts = new Knoten<>(inhalt);
            } else { //rechts > links
                einfügen(knoten.rechts, inhalt); // go one niveau down
            }
        }
    }

    public boolean istLeer() {
        return wurzel == null; // default initialization value 
    }

    private static ch.hslu.ad.sw03.Knoten<Integer> test1() {
        ch.hslu.ad.sw03.Knoten<Integer> root = new ch.hslu.ad.sw03.Knoten<Integer>(2);
        ch.hslu.ad.sw03.Knoten<Integer> n11 = new ch.hslu.ad.sw03.Knoten<Integer>(7);
        ch.hslu.ad.sw03.Knoten<Integer> n12 = new ch.hslu.ad.sw03.Knoten<Integer>(5);
        ch.hslu.ad.sw03.Knoten<Integer> n21 = new ch.hslu.ad.sw03.Knoten<Integer>(2);
        ch.hslu.ad.sw03.Knoten<Integer> n22 = new ch.hslu.ad.sw03.Knoten<Integer>(6);
        ch.hslu.ad.sw03.Knoten<Integer> n23 = new ch.hslu.ad.sw03.Knoten<Integer>(9);
        ch.hslu.ad.sw03.Knoten<Integer> n31 = new ch.hslu.ad.sw03.Knoten<Integer>(5);
        ch.hslu.ad.sw03.Knoten<Integer> n32 = new ch.hslu.ad.sw03.Knoten<Integer>(8);
        ch.hslu.ad.sw03.Knoten<Integer> n33 = new ch.hslu.ad.sw03.Knoten<Integer>(4);

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
        Binärbaum<String> baum = new Binärbaum<>("B");

        baum.einfügen("C");
        baum.einfügen("D");
        baum.einfügen("B");
        baum.einfügen("A");
        
        BTreePrinter<String> printer = new BTreePrinter<>();
        printer.printKnoten(baum.wurzel);

    }

    void testPrinter() {

//        System.out.println(baum.wurzel);
    }

    void testStringComparatorForNumbers() {
        String testEins = "1";
        String testZwei = "2";

        int result = testEins.compareTo(testZwei);
        System.out.println(result); // -1
    }

}

// Element mit 2 Kindern entfernen (idee) . 
// rechts das kleinste suchen (Linksrutsch)
// und im linken Teilbuam das grösste suchen. (Rechtsrutsch)
