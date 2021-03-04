package ch.hslu.ad.sw02;

/**
 *
 * @author cyrill
 */
public class StackFromScratch implements StackInterface {
    
    private String[] storage;
    private int size;
    
    // isFull() ?
    // is Empty ?
    // prevent pop() if Stack is Empty (maybe throw exception)
    // 
        
    public StackFromScratch(String[] storage) {
        this.size = 0;
        this.storage = new String[100];
    }

    public void push(String in) {
        storage[size] = in;
        size++;
    }

    public String pop() {
        size--;
        return storage[size+1]; // return top element
    }

    public int size() {
        return size;
    }
    
    
    

}
