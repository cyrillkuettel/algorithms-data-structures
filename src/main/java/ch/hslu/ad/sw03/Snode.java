package ch.hslu.ad.sw03;



/**
 *
 * @author cyrill
 */
public class Snode {

    String value;
    boolean empty = true;
    Snode left;
    Snode right;

    public Snode(final String value) {
        empty = false;
        this.value = value;
        left = right = null;
    }

    public Snode(final String value, final boolean isInFactEmpty) {
        empty = isInFactEmpty;
        this.value = value;
        left = right = null;
    }
    
    public Snode() {
    }

    @Override
    public String toString() {
        return "Node {" + "value=" + value + '}';
    }

    public boolean isEmpty() {
        return empty;
    }
    
    

}
