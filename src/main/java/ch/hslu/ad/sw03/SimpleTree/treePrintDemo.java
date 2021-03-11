package ch.hslu.ad.sw03.SimpleTree;

/**
 *
 * @author cyrill
 */
public class treePrintDemo {
    // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    
    
    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(3);
        t.add(1);
        t.add(2);
        t.add(4);
        t.add(8);
        t.add(10);
        t.add(11);

        t.printTree();
    }

}
