package ch.hslu.ad.sw09;

import java.util.Arrays;

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
        heap = new int[MAX_SIZE];
        this.size = 0; // initial. 
    }

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(30);
        
        heap.insert(9);
        heap.insert(4);
        heap.insert(7);
        
//        heap.printArray();

        heap.getMax();
        heap.printArray();

    }

    @Override
    public void insert(int element) {
        heap[size] = element;
        size++;

        int currentIndex = size - 1;
        while (heap[currentIndex] > heap[parent(currentIndex)]) { // reorganzie up
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }

    }

    public void printArray() {
        System.out.println(Arrays.toString(heap));
    }

    public int[] getHeap() {
        return heap;
    }

    // after the Max element is popped out, it may be neccessary to rearrange the structure
    public void reArrangeTopDown(int index) {

        if (noChildrenBigger(index)) {
            return; 
        } else {
            int BiggerChildIndex = getBiggerChild(index);
            swap(BiggerChildIndex, index);
            reArrangeTopDown(BiggerChildIndex); 
        }

    }

    public boolean noChildrenBigger(int index) {
        int parent = heap[index];
        return heap[leftChild(index)] <= parent && heap[rightChild(index)] <= parent;

    }

    private int getBiggerChild(int parent) {

        if (leftChild(parent) >= rightChild(parent)) {
            return leftChild(parent);
        } else {
            return rightChild(parent);
        }
    }

    public int getMax() {
        int max = heap[0];
        printArray();
        swap(0, size - 1); // swap the root with last Index
        size--;
        heap[size] = 0;
        printArray();
        reArrangeTopDown(0);
        return max;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // returns index of Parent Element
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int rightChild(int index) {
        return 2 * (index + 1);
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    @Override
    public void remove(int inp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
