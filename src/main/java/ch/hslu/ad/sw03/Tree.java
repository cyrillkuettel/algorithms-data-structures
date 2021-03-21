package ch.hslu.ad.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class Tree implements TreeInterface {

    private static final Logger log = LogManager.getFormatterLogger(Tree.class);
    protected node root;

    public Tree(int value) {
        this.root = new node(value);
    }

    public Tree() {
        this.root = new node();
    }

    @Override
    public void printInOrder(node node) {
        if (node == null) {
            return;
        }
        /* first print data of node */
        printInOrder(node.left);

        /* then print the data of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInOrder(node.right);
    }

    @Override
    public void remove(int value) {
        if (root != null) {
            remove(root, value);
        } else {
            log.warn("Nothing to delete. Tree is Empty");
        }
    }

    public void remove(node node, int value) {

        node removeThisNode = search(value);
        boolean valueWasNotFound = removeThisNode.empty;
        if (valueWasNotFound) { // if emptty node is retured, value was not found
            log.warn("Not finding value " + value + " in the tree. Stopping removing process. . .");
            return;
        }

        int count = node.getNumberOfSubnodes();
        
        if (count == 0) {
            
        }

    }

    @Override
    public node search(int value) {
        if (isEmpty()) {
            log.warn("Can't search a empty tree...");
        } else {
            return searchNode(root, value);
        }
        return new node(0, true);
    }

    public node searchNode(node node, int value) {

        if (value < node.value) {
            if (node.left.value == value) {
                return node.left;
            } else {
                searchNode(node.left, value);
            }
        } else {
            if (node.right.value == value) {
                return node.right;
            } else {
                searchNode(node.right, value);
            }
        }
        return new node(0, true); // when not found, return empty node. Could also consider returning Null
    }

    @Override
    public void add(int value) {
        if (isEmpty()) {
            root = new node(value); // base case r
        } else {
            add(root, value);  //  descend one niveau
        }
    }

    @Override
    public void add(node node, int value) {

        if (value < node.value) { //
            if (node.left == null) {
                node.left = new node(value);
            } else {
                add(node.left, value); // descend one niveau (Right side)
            }
        } else { // ---> value is bigger or equal to node.value
            if (node.right == null) {
                node.right = new node(value);
            } else { //right > right
                add(node.right, value); // descend one niveau (Right node)
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    public void drawTree() {
        TreeGrower treeGrower = new TreeGrower(false, root); // default: don't draw empty Nodes (Zeroes)
        treeGrower.start();
    }

    public void drawTree(boolean drawEmptyNodes) {
        TreeGrower treeDiagram = new TreeGrower(drawEmptyNodes, root);
        treeDiagram.start();
    }

}
