package ch.hslu.ad.sw03;

/**
 *
 * @author cyrill
 */
public class node {

    Integer value;
    boolean empty = true;
    node left;
    node right;

    public node(final int value) {
        empty = false;
        this.value = value;
        left = right = null;
    }

    public node(final int value, final boolean isInFactEmpty) {
        empty = isInFactEmpty;
        this.value = value;
        left = right = null;
        
    }

    public node() {
    }

    @Override
    public String toString() {
        return "Node {" + "value=" + value + '}';
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean allChildrenAreLeaves() {
        boolean hasChildren = this.left != null || this.right != null;

        if (hasChildren == false) {
            return false;
        }

        boolean leftSide = this.left.right == null && this.left.left == null;
        boolean rightSide = this.right.right == null && this.right.left == null;
        
        return (leftSide && rightSide);
    }

    public int getNumberOfSubnodes() { // get Number of Children != null
         int count = 0;
        if (this.left != null) {
            count++;
        }
        if (this.right != null) {
            count++;
        }
        return count;
    }

}
