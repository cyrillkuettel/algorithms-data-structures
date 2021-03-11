package ch.hslu.ad.sw03.SimpleTree;

/**
 *
 * @author cyrill
 */
public class treePrintDemo {
    // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram

    public static void main(String[] args) {
        Tree tree = createTree2();
        tree.drawTree();

    }

    static Tree createTree() {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(8);
        tree.add(10);
        tree.add(11);
        return tree;
    }

    static Tree createTree2() {
        Tree tree = new Tree();

        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(6);

        return tree;
    }
}
