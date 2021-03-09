package ch.hslu.ad.sw03;

interface binaryTreeInterface { // TODO: interface

}

class Binärbaum<T extends Comparable<T>> {
    //Aufgabe: 10 eindeutige geordnete Elemente erstellen

    protected Knoten wurzel;

    class Knoten {

        private T inhalt; // 
        private Knoten links, rechts;

        public Knoten(T inhalt) {
            this.inhalt = inhalt;
            this.links = this.rechts = null;
        }

        public void einfügen(T value) {
            if (istLeer()) {
                wurzel = new Knoten(value); // base case
            } else {
                einfügen(wurzel, value);
            }
        }

        public void einfügen(Knoten knoten, T inhalt) { 
            
            // child leer, dort einfügen.
            
           if (inhalt.compareTo(knoten.inhalt) == -1) {
               
           } 
           // else:
           einfügen(inhalt);
            
        }

        public boolean istLeer() {
            return wurzel == null; // default initialization value 
        }

    }

    public static void main(String[] args) {
        Binärbaum<String> b = new Binärbaum<>();

    }

}


// Element mit 2 Kindern entfernen. 
// rechts das kleinste suchen (Linksrutsch)
// und im linken Teilbuam das grösste suchen. (Rechtsrutsch)