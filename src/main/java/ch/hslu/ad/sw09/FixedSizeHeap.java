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
        heap.printHeap();
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

    private void printHeap() {
        int maxDepth = (int) (Math.log(size) / Math.log(2));  // log base 2 of n

        StringBuilder hs = new StringBuilder();  // heap string builder
        for (int d = maxDepth; d >= 0; d--) {  // number of layers, we build this backwards
            int layerLength = (int) Math.pow(2, d);  // numbers per layer

            StringBuilder line = new StringBuilder();  // line string builder
            for (int i = layerLength; i < (int) Math.pow(2, d + 1); i++) {
                // before spaces only on not-last layer
                if (d != maxDepth) {
                    line.append(" ".repeat((int) Math.pow(2, maxDepth - d)));
                }
                // extra spaces for long lines
                int loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }

                // add in the number
                if (i <= size) {
                    line.append(String.format("%-2s", heap[i]));  // add leading zeros
                } else {
                    line.append("--");
                }

                line.append(" ".repeat((int) Math.pow(2, maxDepth - d)));  // after spaces
                // extra spaces for long lines
                loops = maxDepth - d;
                if (loops >= 2) {
                    loops -= 2;
                    while (loops >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, loops)));
                        loops--;
                    }
                }
            }
            hs.insert(0, line.toString() + "\n");  // prepend line
        }
        System.out.println(hs.toString());
    }

    // after the Max element is popped out, it may be neccessary to rearrange the structure
    public void reArrangeTopDown(int index) {

        if (noChildrenBigger(index)) {
            return; // Dann ist ausgeheapt
        } else {
            System.out.println("got here");
            int BiggerChildIndex = getBiggerChild(index);
            swap(BiggerChildIndex, index);
            reArrangeTopDown(BiggerChildIndex); // or is it: get Bigger Child
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
