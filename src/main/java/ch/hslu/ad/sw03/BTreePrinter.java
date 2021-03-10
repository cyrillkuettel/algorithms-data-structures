package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cyrill
 */
class BTreePrinter<T extends Comparable<?>> {

    public static <T extends Comparable<?>> void printKnoten(Knoten<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printKnotenInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printKnotenInternal(List<Knoten<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Knoten<T>> newKnotens = new ArrayList<Knoten<T>>();
        for (Knoten<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newKnotens.add(node.links);
                newKnotens.add(node.rechts);
            } else {
                newKnotens.add(null);
                newKnotens.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).links != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rechts != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printKnotenInternal(newKnotens, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Knoten<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.links), BTreePrinter.maxLevel(node.rechts)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}