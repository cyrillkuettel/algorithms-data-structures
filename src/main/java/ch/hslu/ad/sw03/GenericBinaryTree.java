package ch.hslu.ad.sw03;

// Eine Klasse, die einen allgemeinen Binärbaum implementiert:
class GenericBinaryTree<E extends Comparable<E>> {

    protected static class Knoten<E extends Comparable<E>> {

        private E inhalt; // if inhalt of Type int, exchange compareTo to '>'
        private Knoten<E> links, rechts;

        public Knoten(E inhalt) {
            this.inhalt = inhalt;
//            this.links = new Binärbelementaum<E>(E inhalt);

        }
        protected Knoten<E> wurzel;
        //... Zugriffsmethoden

        public void einfügen(E element) {

        }

        public E getInhalt() {
            return inhalt;
        }

        public E get(Knoten<E> inp) {
            return inp.getInhalt();
        }

        public Knoten<E> getLinks() {
            return links;
        }

        public Knoten<E> getRechts() {
            return rechts;
        }

    }

    public static void main(String[] args) {
        GenericBinaryTree<String> b = new GenericBinaryTree<String>();

    }

}
