package ch.hslu.ad.sw03;

import  java.util.function .*;

/**
 *
 * @author cyrill
 */
public class treePrintDemo {

    public treePrintDemo() {

        Tree tree = createTree();
        tree.drawTree();

    }

    public static void main(String[] args) {
        new treePrintDemo();
    }

    static Tree createTreeForTestingRemove() {
        Tree tree = new Tree();
        /*
        https://www.algolist.net/Data_structures/Binary_search_tree/Removal
         */
        tree.add(5);
        tree.add(2);
        tree.add(12);
        tree.add(4);
        tree.add(3);
        tree.add(9); 
        tree.add(21);
        tree.add(19);
        tree.add(25);

        return tree;
    }

    static Tree createTree() {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(6);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(4);
 

        return tree;
    }

}
