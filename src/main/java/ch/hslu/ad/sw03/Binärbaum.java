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

    public Binärbaum() {
    }

    public  class Knoten<T extends Comparable<T>> {

        private final T inhalt;
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

    public void printInOrder(Knoten<T> knoten) {
        if (knoten == null) {
            return;
        }
        /* first print data of node */
        printInOrder(knoten.links);

        /* then print the data of node */
        System.out.print(knoten.inhalt);

        /* now recur on rechts child */
        printInOrder(knoten.rechts);

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
                einfügen(knoten.links, inhalt); // descend one niveau (Left side)
            }
        } else {
            if (knoten.rechts == null) {
                knoten.rechts = new Knoten<>(inhalt);
            } else { //rechts > links
                einfügen(knoten.rechts, inhalt); // descend niveau right 
            }
        }
    }

    public boolean istLeer() {
        return wurzel == null; // default initialization value 
    }

    private Knoten<String> test2() {
        Knoten<String> root = new Knoten<String>("E");
        Knoten<String> n11 = new Knoten<String>("A");
        Knoten<String> n12 = new Knoten<String>("B");
        Knoten<String> n21 = new Knoten<String>("C");
        Knoten<String> n22 = new Knoten<String>("F");
        Knoten<String> n23 = new Knoten<String>("H");
        Knoten<String> n31 = new Knoten<String>("G");
        Knoten<String> n32 = new Knoten<String>("I");
        Knoten<String> n33 = new Knoten<String>("Z");

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
}

// Element mit 2 Kindern entfernen (idee) . 
// rechts das kleinste suchen (Linksrutsch)
// und im linken Teilbuam das grösste suchen. (Rechtsrutsch)
