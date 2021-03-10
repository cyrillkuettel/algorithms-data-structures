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


    protected Knoten wurzel;

    class Knoten {

        private T inhalt; // 
        private Knoten links, rechts;

        public Knoten(T inhalt) {

            this.inhalt = inhalt;
            this.links = this.rechts = null;

        }

    }

    public void inOrderTraverse() {
        if (wurzel != null) {
            
        }
    }

    public void suchen(Knoten knoten, T inhalt) {
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
            wurzel = new Knoten(value); // base case r
        } else {
            einfügen(wurzel, value);
        }
    }

    public void einfügen(Knoten knoten, T inhalt) {

        if (inhalt.compareTo(knoten.inhalt) < 0) {
            if (knoten.links == null) {
                knoten.links = new Knoten(inhalt);
            } else {
                einfügen(knoten.links, inhalt); // go one niveau down
            }
        } else {
            if (knoten.rechts == null) {
                knoten.rechts = new Knoten(inhalt);
            } else { //rechts > links
                einfügen(knoten.rechts, inhalt); // go one niveau down
            }
        }
    }

    public boolean istLeer() {
        return wurzel == null; // default initialization value 
    }

    public static void main(String[] args) {
        Binärbaum<String> b = new Binärbaum<>();

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
