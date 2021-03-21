package ch.hslu.ad.sw03;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author cyrill
 */
public interface TreeGrowerInterface {

    /**
     *
     * Simply loops over each Niveau of the tree. Then adds the elements in a
     * hierarchical structure. From top to bottom.
     *
     * @return nested ArrayList, each Niveau representing an ArrayList itself.
     */
    public ArrayList<ArrayList<node>> getNodeListFromEachNiveau();

    /**
     *
     * @param currentLevel
     * @return Returns true if there are only Nodes with Zero value in the Queue.
     * 
     */
    public boolean allZeroesInQueue(Queue<node> currentLevel);

    public void prepareNextLevelForQueue(node currentNode, Queue<node> nextLevel);
    /**
     * Initialize the Tree Diagram drawing process. 
     */
    public void start();
    
    /**
     * 
     * @param niveau The current Niveau in the iteration
     * @return integer value indicating, how long the Branches shoul be
     */
    public int getBranchLengthForNiveau(final int niveau);
    
    
    public String generateWhiteSpace(final int len);

    /**
     * Slightly modifies the space between elements on one Line in the Tree. Is
     * based on the current Iteration
     *
     * @param count number of iterations in For-Loop nodeListByNiveau.
     * @param nodeListByNiveau // nesteed ArrayList, each element represents one
     * Horizonal Niveau
     * @param currentArrayList // the current Line which is being modified.
     * @return retuns -1 or -2, to have a slight deviation of whitespace
     */
    public int offsetOnlyEvery_Nth_Iteration(final int count, final ArrayList< ArrayList< node>> nodeListByNiveau, final ArrayList<node> currentArrayList);

}
