package ch.hslu.ad.sw03;

import ch.hslu.ad.sw02.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
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
    public void search(node node, int value) {
        // what to do if element does not exist? 
        // check for null.
        
        if (value < node.value) {
            if (node.left.value == value) {
                System.out.println("found left Node: " + node.left.toString());
            } else {
                search(node.left, value);
            }
        } else {
            if (node.right.value == value) {
                System.out.println("found right Node: " + node.right.toString());
            } else {
                search(node.right, value);
            }
        }
    }

    @Override
    public void remove(int value) {
        // the simply cases (2):
        if (root != null) {
            remove(root, value);
        } else {
            log.warn("Nothing to delete. Tree is Empty");
        }
    }

    public void remove(node node, int value) {
        int childrenCount = node.getNumberChildren();

        if (childrenCount == 0) {

        }
        // 0 Children

        // 1 Child
        
        // 2 Child
    }

    @Override
    public void search(int value) {
        if (isEmpty()) {
            log.warn("Can't search a empty tree...");
        } else {
            search(root, value);
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

    public void drawTree()  {
        TreeGrower treeGrower = new TreeGrower(false, root); // default: don't draw empty Nodes (Zeroes)
        treeGrower.start();
    }

    
 public void drawTree(boolean drawEmptyNodes)  {
        TreeGrower treeDiagram = new TreeGrower(drawEmptyNodes, root);
        treeDiagram.start();
    }

}
