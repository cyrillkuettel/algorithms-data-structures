package ch.hslu.ad.sw03.StringTree;

import ch.hslu.ad.sw03.SimpleTree.Tree;

/**
 *
 * @author cyrill
 */
public class demoTree_With_Strings {

    public static void main(String[] args) {
        StringTree tree = createTree2();
        tree.drawTree();
    }

    static StringTree createTree2() {
        StringTree tree = new StringTree();
        tree.add("C");
        tree.add("D");
        tree.add("A");
        tree.add("B");

        return tree;
    }

}
