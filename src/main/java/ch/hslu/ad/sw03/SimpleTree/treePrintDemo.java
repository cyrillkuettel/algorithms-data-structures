package ch.hslu.ad.sw03.SimpleTree;

/**
 *
 * @author cyrill
 */
public class treePrintDemo {
    // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(10);
        tree.add(11);
        
        tree.printInOrder(tree.root);
        System.out.println();
        System.out.println();
        
        tree.drawTree();
    }

}
