package ch.hslu.ad.sw03;

/**
 *
 * @author cyrill
 */
public class BinärbaumDemo {

    public static void main(String[] args) {
        Binärbaum<String> baum = new Binärbaum<>("B");
        baum.einfügen("C");
        baum.einfügen("D");
        baum.einfügen("Z");
        baum.einfügen("A");
        
        baum.printInOrder(baum.wurzel);
    }
}
