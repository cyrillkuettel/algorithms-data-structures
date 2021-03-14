package ch.hslu.ad.sw03;

/**
 *
 * @author cyrill
 */
public class treePrintDemo {
    // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram

    public treePrintDemo() throws InterruptedException {
        Tree tree = createTree();
        tree.drawTree(false);
    }

    public static void main(String[] args) throws InterruptedException {
        new treePrintDemo();
    }

    static Tree createTree() {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(5);
        tree.add(6);

        return tree;
    }

}
