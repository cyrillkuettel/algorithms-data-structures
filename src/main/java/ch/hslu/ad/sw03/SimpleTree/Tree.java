package ch.hslu.ad.sw03.SimpleTree;

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
// is empty ,add search , prtin in order, delete of course
interface TreeInterface {

    boolean isEmpty();

    public void add(node node, int value);

    public void add(int value);

    void search(node node, int value);

    void search(int value);

    void printInOrder(node node);

}

public class Tree implements TreeInterface {

    private static final Logger LOG = LogManager.getFormatterLogger(Tree.class);
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

    public ArrayList<ArrayList<node>> getNodeListFromEachNiveau() {

// Inspiration from https://stackoverflow.com/questions/2241513/java-printing-a-binary-tree-using-level-order-in-a-specific-format
        ArrayList<ArrayList<node>> result = new ArrayList<ArrayList<node>>();

        Queue<node> currentLevel = new LinkedList<node>();
        Queue<node> nextLevel = new LinkedList<node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty() && !allZeroesInQueue(currentLevel)) {
            Iterator<node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                node currentNode = iter.next();
                prepareNextLevel(currentNode, nextLevel);
            }
            ArrayList<node> zwischenspeicher = new ArrayList<>(currentLevel);
            result.add(zwischenspeicher);

            currentLevel = nextLevel;
            nextLevel = new LinkedList<node>();
        }
        return result;
    }

    public boolean allZeroesInQueue(Queue<node> currentLevel) {
        return currentLevel.stream().allMatch(i -> i.empty == true);
    }

    public void prepareNextLevel(node currentNode, Queue<node> nextLevel) {
        if (currentNode.left != null) {
            nextLevel.add(currentNode.left);
        } else {
            nextLevel.add(new node(0, true)); // the boolean flag signals the node, that this Zero is in fact empty
        }

        if (currentNode.right != null) {
            nextLevel.add(currentNode.right);
        } else {
            nextLevel.add(new node(0, true));
        }
    }

    public void drawTree() {
        drawTree(true);
    }

    public void drawTree(boolean printEmptyNodes) {
        /*
         *      1      root
         *     / \
         *    2   3    Niveau-1
         *   /   / \
         *  4   5   6  Niveau-2
        
        https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
            
        
        
        TODO: 
            manchmal nicht ganz bündig, vor allem bei grösseren Bäumen. (offset könnte helfen?)
            feature: kein branch, wenn nächster null ist.
            special case: node.values.length() > 1  ( Wenn die Elemente länger sind muss man mit der breite multiplizieren)
         */

        ArrayList< ArrayList< node>> nodeListByNiveau = getNodeListFromEachNiveau();
        int niveau = nodeListByNiveau.size() - 1;
        int firstBranchLength = getBranchLengthForNiveau(niveau);
        ArrayList<node> bottomList = nodeListByNiveau.get(niveau - 1);
        ArrayList<node> zweitUndersteList = nodeListByNiveau.get(niveau - 2);

        int middle = bottomList.size() * 2; // start in the middle

        for (ArrayList<node> arrayList : nodeListByNiveau) {

            String line = "";

            int count = 0;
            for (node node : arrayList) { // per Niveau, do this on this Niveau

                int divisor = arrayList.size();
                int offset = offsetOnlyEverySecondIteration(count);

                String whiteSpaceprevious = generateWhiteSpace((middle + 1) / divisor);
                String whiteSpaceafter = generateWhiteSpace((middle / divisor));

                // in the end WHEN It works, change into value;
                String s;
                if (printEmptyNodes) {
                    s = whiteSpaceprevious + node.value + whiteSpaceafter;
                } else {
                    String value;
                    if (node.isEmpty()) {
                        value = " ";
                    } else {
                        value = node.value.toString();
                    }
                    s = whiteSpaceprevious + value + whiteSpaceafter;
                }

                System.out.print(s);
                line += s; // important variable
                count++;
            }
            System.out.println(); // dont remove!!

            BranchGrower bg1 = new BranchGrower(arrayList, line);
            line = bg1.drawSingleBranch();

            int branchLen = getBranchLengthForNiveau(niveau) - 1;

            String growingBranch = line;
            BranchGrower bg = new BranchGrower(growingBranch, 1);
            bg.growBranchNtimes(growingBranch, branchLen);
            niveau--; // kapt'n niveau! Wir sinken!
        }

    }

    public int getBranchLengthForNiveau(final int niveau) {
        return (int) Math.pow(2, niveau - 1);
    }

    public String generateWhiteSpace(final int len) {
        return " ".repeat(len);
    }

    private int offsetOnlyEverySecondIteration(int count) {
        if (count % 2 != 0) {
            return 1;
        }
        return 0;
    }

}
