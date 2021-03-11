package ch.hslu.ad.sw03.SimpleTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
// is empty ,add search , prtin in order, delete of course
interface intreeInterface {

    boolean isEmpty();

    public void add(node node, int value);

    public void add(int value);

    void search(node node, int value);

    void search(int value);

    void printInOrder(node node);
    // preorder, postorder
}

public class Tree implements intreeInterface {

    private static final Logger LOG = LogManager.getFormatterLogger(Tree.class);
    private node root;

    public Tree(int value) {
        this.root = new node(value);

    }

    public Tree() {
        this.root = new node();

    }

    public static void main(String[] args) {
        new Tree();
    }

    @Override
    public void printInOrder(node node) {
        if (node == null) {
            return;
        }
        /* first print data of node */
        printInOrder(node.left);

        /* then print the data of node */
        System.out.print(node.value);

        /* now recur on right child */
        printInOrder(node.right);

    }

    @Override
    public void search(node node, int value) {
        // what to do if element does not exist? 

        if (value < node.value) {
            if (node.left.value == value) {
                System.out.println("found the node: " + node.left.toString());
            } else {
                search(node.left, value);
            }
        } else {
            if (node.right.value == value) {

                System.out.println("found the node: " + node.right.toString());
            } else {
                search(node.right, value);
            }
        }
        System.out.println("Did not find element!");

    }

    @Override
    public void search(int value) {
        if (isEmpty()) {
            LOG.warn("Can't search a empty tree...");
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

        if (value < node.value) {
            if (node.left == null) {
                node.left = new node(value);
            } else {
                add(node.left, value); // descend one niveau (Left side)
            }
        } else {
            if (node.right == null) {
                node.right = new node(value);
            } else { //right > right
                add(node.right, value); // descend niveau right 
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }
    //https://stackoverflow.com/questions/2241513/java-printing-a-binary-tree-using-level-order-in-a-specific-format

    public void printTree() {

        Queue<node> currentLevel = new LinkedList<node>();
        Queue<node> nextLevel = new LinkedList<node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty() && !currentLevel.stream().allMatch(i -> i.empty == true)) {
            Iterator<node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                node currentNode = iter.next();
                if (currentNode.left != null) {
                    System.out.println("leftie: " + currentNode.left);
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                    System.out.println("right: " + currentNode.left);
                }
                // add the null values as well 
                if (currentNode.right == null || currentNode.left == null) {
                    nextLevel.add(new node(0, true));
                }
                System.out.print(currentNode.value + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<node>();

        }

    }

    public ArrayList<ArrayList<Integer>> printlevelOrder() {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<Integer>();
        q1.add(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {

            while (!q1.isEmpty()) {
                node temp = q1.poll();
                list.add(temp.value);
                if (temp.left != null) {
                    q2.add(temp.left);
                }
                if (temp.right != null) {
                    q2.add(temp.right);
                }

            }
            if (list.size() > 0) {
                result.add(new ArrayList<Integer>(list));
            }
            list.clear();
            while (!q2.isEmpty()) {
                node temp = q2.poll();
                list.add(temp.value);
                if (temp.left != null) {
                    q1.add(temp.left);
                }
                if (temp.right != null) {
                    q1.add(temp.right);
                }
            }
            if (list.size() > 0) {
                result.add(new ArrayList<Integer>(list));
            }
            list.clear();
        }
        return result;
    }

}
