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

    /*
    TODO: special case: remove the root of tree. 
     */
    public void remove(node node, int value) {

        node nodeToBeRemoved = search(value);
        boolean valueWasNotFound = nodeToBeRemoved.empty;
        if (valueWasNotFound) { // if emptty node is retured, value was not found
            log.warn("Not finding value " + value + " in the tree. Stopping removing process. . .");
            return;
        }

        int count = nodeToBeRemoved.getNumberOfSubnodes();

        if (count == 0) {
            node parent = nodeToBeRemoved.parent;

            if (parent.left == nodeToBeRemoved) {
                parent.left = null;
            }
            if (parent.right == nodeToBeRemoved) {
                parent.right = null;
            }

        }
        if (count == 1) { // node has 1 child    
            /*
            It this case, node is cut from the tree and algorithm links single child 
            (with it's subtree) directly to the parent of the removed node.
             */
            node onlyChild = nodeToBeRemoved.getOnlyChild();
            node parent = nodeToBeRemoved.parent;

            if (parent.left == nodeToBeRemoved) {
                parent.left = onlyChild;
            }
            if (parent.right == nodeToBeRemoved) {
                parent.right = onlyChild;
            }
        }

        if (count == 2) {
            /*
                procedure for this case. 
            1.) Find minimum element in the right subtree of the node to be removed. 
            2.) Replace value of element to be removed with the minimum element from 1.)
            3.) now there are have two nodes with the same value.
            4.) delete minimum element in the right subtree (original position)
             */

            node min = findMinOfRightSubtree(nodeToBeRemoved.right); 
            int minimum = min.value; 
            remove(minimum);
            nodeToBeRemoved.value = minimum;
            
        }

    }

    public node findMinOfRightSubtree(node node) {
        node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;

    }

    @Override
    public node search(int value) {
        if (isEmpty()) {
            log.warn("Can't search an empty tree...");
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
                return searchNode(node.left, value);
            }
        } else {
            if (node.right.value == value) {
                return node.right;
            } else {
                return searchNode(node.right, value);
            }
        }
    }
    
    public boolean existsInTree(node root, node node) { // If this works, this is a piece of art. 
        if ( root == null) {
            return false;
        }  else {
            boolean inLeft = existsInTree(node.left, node);
            boolean inRight = existsInTree(node.right, node);
            return (root.value == node.value || inLeft || inRight);
        }
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
                node.left.parent = node;
            } else {
                add(node.left, value); // descend one niveau (Right side)
            }
        } else { // ---> value is bigger or equal to node.value
            if (node.right == null) {
                node.right = new node(value);
                node.right.parent = node;
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
