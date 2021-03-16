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
interface TreeInterface {

    boolean isEmpty();

    public void add(node node, int value);

    public void add(int value);

    void search(node node, int value);

    void search(int value);

    void printInOrder(node node);

    void remove(int value);

}

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
    //                      tree Printing starting here 
    // -------------------------------------------------------------------------
    /**
     *
     * Simply loops over each Niveau of the tree. Then adds the elements in a hierarchical structure. 
     *
     * @return nested ArrayList, each Niveau representing an ArrayList itself.
     */
    public ArrayList<ArrayList<node>> getNodeListFromEachNiveau() {

        ArrayList<ArrayList<node>> result = new ArrayList<ArrayList<node>>();

        Queue<node> currentLevel = new LinkedList<node>();
        Queue<node> nextLevel = new LinkedList<node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty() && !allZeroesInQueue(currentLevel)) {
            Iterator<node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                node currentNode = iter.next();
                prepareNextLevelForQueue(currentNode, nextLevel);
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

    public void prepareNextLevelForQueue(node currentNode, Queue<node> nextLevel) {
        if (currentNode.left != null) {
            nextLevel.add(currentNode.left);
        } else {
            // the boolean flag signals the node, that this Zero is in fact empty
            nextLevel.add(new node(0, true));
        }

        if (currentNode.right != null) {
            nextLevel.add(currentNode.right);
        } else {
            nextLevel.add(new node(0, true));
        }
    }

    public void drawTree() throws InterruptedException {
        drawTree(true);
    }

    public void drawTree(boolean printEmptyNodes) throws InterruptedException {
        /*
         *      1      root
         *     / \
         *    2   3    Niveau-1
         *   /   / \
         *  4   5   6  Niveau-2
        
        https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram

        TODO: 

           - kein branch, wenn nächster null ist.
           - special case: (if node.values.length() > 1 ) --> Wenn die Node Values länger sind, muss man mit der Breite multiplizieren)
                                                         --> Das brauch wahrscheinlich Regex, um die Items zu erkennen im BranchGrower.
                                                         
            - Split this part into another class.
                TreeDiagramm Class would need nodeListByNiveau, plus every function which drawTree uses.
         */

        final int sleepTime = 0; // If you want a delay Thread.sleep(...)

        ArrayList< ArrayList< node>> nodeListByNiveau = getNodeListFromEachNiveau();
        int niveau = nodeListByNiveau.size(); // with this you can modify the branch length (-1 to cut in half)
        int firstBranchLength = getBranchLengthForNiveau(niveau);
        ArrayList<node> bottomList = nodeListByNiveau.get(niveau - 1);
        ArrayList<node> zweitUndersteList = nodeListByNiveau.get(niveau - 2);

        int middle = bottomList.size() * 2; // start in the middle

        for (ArrayList<node> arrayList : nodeListByNiveau) { // starting a big giant for Loop. Niveau by Nivea. 

            String line = ""; // represents one Line (of Text) 

            int count = 0;
            for (node node : arrayList) { // per Niveau, do this on this Niveau
                int divisor = arrayList.size();
                int offset = offsetOnlyEvery_Nth_Iteration(count, nodeListByNiveau, arrayList);
                int calculateWhiteSpaceAfter = (middle / divisor) + offset; // whitespace Generation: how far are the elements apart
//                 int calculateWhiteSpaceAfter = (middle / divisor);
                int calculateWhiteSpaceprevious = (middle + 1) / divisor;
                if (calculateWhiteSpaceAfter < 0) { // the whitespace should at no point be negative
                    calculateWhiteSpaceAfter = 0;
                }
                String whiteSpaceprevious = generateWhiteSpace(calculateWhiteSpaceprevious);
                String whiteSpaceafter = generateWhiteSpace(calculateWhiteSpaceAfter);
                int diff = whiteSpaceprevious.length() - whiteSpaceafter.length();
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

            if (arrayList != bottomList) {
                BranchGrower bg1 = new BranchGrower(arrayList, line);
                String growingBranch = bg1.drawSingleBranch();
                Thread.sleep(sleepTime);
                BranchGrower bg = new BranchGrower(growingBranch);
                int branchLen = getBranchLengthForNiveau(niveau) - 1;
                bg.growBranchNtimes(growingBranch, branchLen);
            }

            niveau--; // kapt'n niveau! Wir sinken!
            Thread.sleep(sleepTime);
        }

    }

    public int getBranchLengthForNiveau(final int niveau) {
        return (int) Math.pow(2, niveau - 1);
    }

    public String generateWhiteSpace(final int len) {
        return " ".repeat(len);
    }
/**
 * Slightly modifies the space between elements on one Line in the Tree. 
 * Is based on the current Iteration
 * @param count number of iterations in For-Loop nodeListByNiveau.
 * @param nodeListByNiveau // nesteed ArrayList, each element represents one Horizonal Niveau
 * @param currentArrayList // the current Line which is being modified. 
 * @return 
 */
    private int offsetOnlyEvery_Nth_Iteration(final int count,
        final ArrayList< ArrayList< node>> nodeListByNiveau,
        final ArrayList<node> currentArrayList) {

        int currentIteration = nodeListByNiveau.indexOf(currentArrayList) + 1;
        int diff = nodeListByNiveau.size() - currentIteration;

        if (diff == 0) {
            if (count % 4 == 0 && count % 6 == 0) { //  arbitrary Values. This tries to be a frequency. 
                return -2; // künstlich verkürzen
            }

        }
        if (diff == 1) {
            // zweitletzte Line

        }
        if (count % 2 != 0) { // die ungeraden
            return -1;
        }

        return 0;
    }

}
