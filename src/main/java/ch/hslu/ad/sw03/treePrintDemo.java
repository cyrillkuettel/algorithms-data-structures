package ch.hslu.ad.sw03;

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

    static Tree createTree() {
        Tree tree = new Tree();

            tree.add(3);
            tree.add(6);
            tree.add(1);
            tree.add(5);
            tree.add(6);
            tree.add(1);
            tree.add(4);
            tree.add(2);
            tree.add(5);
            tree.add(1);
            tree.add(5);
            tree.add(6);

        

        return tree;
    }

}
