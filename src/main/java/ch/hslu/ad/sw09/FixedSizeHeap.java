package ch.hslu.ad.sw09;

import java.util.ArrayList;

/**
 *
 * @author cyrill
 */
public class FixedSizeHeap implements IntegerHeap {

    public int MAX_SIZE;
    public int[] heap;

    public int size;

    public FixedSizeHeap(final int size) {
        MAX_SIZE = size;
        heap = new int[size];
        this.size = 0; // initial. 
    }
    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(15);
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.print();
        
    }

    @Override
    public void insert(int element) {
        heap[size] = element;
        size++;

        int currentIndex = size;
        while (heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }

    }
    public  void print() {
        // loop 
        // every iteration, there are 2*preivous items. 
        ArrayList<ArrayList<Integer>> nestedList = new ArrayList<>();
        int n = 0;
        while (n < heap.length) {
            ArrayList<Integer> list = new ArrayList<>();
            
            for (int i = n; i < (n+1)*2; i++) {
                list.add(heap[i]);
            }
            nestedList.add(list);
            // increment n
            n = (n+1)*2-1;
        }
        System.out.println(nestedList.toString());
    }

    public void reArrangeTopDown() {
        // the max element is removed. 

    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) { 
            return true;
        }
        return false;
    }

    // returns index of Parent Element
    private int parent(int index) {
        return (int) Math.ceil((index / 2) -1);
    }

    @Override
    public void remove(int inp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
