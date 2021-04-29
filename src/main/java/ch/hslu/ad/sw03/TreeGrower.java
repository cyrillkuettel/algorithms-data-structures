package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author cyrill
 */


public class TreeGrower implements TreeGrowerInterface {

    private boolean printEmptyNodes;
    private node root;
    
    /**
     * 
     * @param printEmptyNodes Toggle printing Nodes with Zero values
     * @param root Typically, you wnat to draw the tree starting from the Root of the tree
     */
    public TreeGrower(boolean printEmptyNodes, node root)  {
        this.printEmptyNodes = printEmptyNodes;
        this.root = root;
    }


    @Override
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

    @Override
    public boolean allZeroesInQueue(Queue<node> currentLevel) {
        return currentLevel.stream().allMatch(i -> i.empty == true);
    }

    @Override
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

    @Override
    public void start()  {
        /*
         *      1      root
         *     / \
         *    2   3    Niveau-1
         *   /   / \
         *  4   5   6  Niveau-2
        
   

        TODO: 

           - kein branch, wenn nächster null ist.
           - special case: (if node.values.length() > 1 ):
        
             If the node values themselves are several characters long, the distance between values needs to be multiplied by a factor of the characters length
                            --> Das braucht wahrscheinlich Regex, um die Items als solche zu erkennen im BranchGrower.
         */

      

        ArrayList< ArrayList< node>> nodeListByNiveau = getNodeListFromEachNiveau();
        int niveau = nodeListByNiveau.size(); // with this you can modify the branch length (-1 to cut in half)
        int firstBranchLength = getBranchLengthForNiveau(niveau);
        ArrayList<node> bottomList = nodeListByNiveau.get(niveau - 1);
        ArrayList<node> zweitUndersteList = nodeListByNiveau.get(niveau - 2);

        int middle = bottomList.size() * 2; // start in the middle

        for (ArrayList<node> arrayList : nodeListByNiveau) { // starting a big giant for Loop. Niveau by Niveau. 

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
                BranchGrower bg = new BranchGrower(growingBranch);
                int branchLen = getBranchLengthForNiveau(niveau) - 1;
                bg.growBranchNtimes(growingBranch, branchLen);
            }

            niveau--; // kapt'n niveau! Wir sinken!
        }

    }

    @Override
    public int getBranchLengthForNiveau(final int niveau) {
        return (int) Math.pow(2, niveau - 1);
    }

    @Override
    public String generateWhiteSpace(final int len) {
        return " ".repeat(len);
    }


    @Override
    public int offsetOnlyEvery_Nth_Iteration(final int count, 
        final ArrayList< ArrayList< node>> nodeListByNiveau,
        final ArrayList<node> currentArrayList) {

        int currentIteration = nodeListByNiveau.indexOf(currentArrayList) + 1;
        int diff = nodeListByNiveau.size() - currentIteration;

        if (diff == 0) {
            if (count % 4 == 0 && count % 6 == 0) { //  arbitrary Values, to make it look pretty
                return -2; // artificially shorten distance.
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
