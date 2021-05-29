/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW13;

import java.util.Arrays;

/**
 *
 * @author Fabio
 */
public class demoRailway {

    public static void main(final String[] args) {
        String[] nodeName = {"a", "b", "c", "d", "e"};
        String[] nodeName2 = {"l", "t", "p", "w", "x"};
        int[] verbindung = {0, 0, 13, 0, 0, 5, 0, 0, 0, 20, 0, 0, 0};

        RailwayNet1 g = new RailwayNet1();
        g.insertNode("Bern", verbindung);
//        System.out.println(Arrays.deepToString(g.getAdjaMx()));
        g.printTwoDimensionalArray();

        RailwayNet3 t = new RailwayNet3();
        t.insert("Willisau", "Luzern", "Arth-Goldau");
        t.print();
        t.delete("Willisau");
        System.out.println();
        System.out.println();
        t.print();

//        int s = t.getStation();
//        boolean r = t.dirVerbindung("Luzern", "Zürich");
//        System.out.println(s);
//        System.out.println(r);
    }

}
