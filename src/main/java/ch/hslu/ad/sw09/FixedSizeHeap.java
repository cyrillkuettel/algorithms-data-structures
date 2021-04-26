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
        heap = new int[MAX_SIZE];
        this.size = 0; // initial. 
    }

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(30);
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(2);
        heap.insert(3);
        heap.insert(45);
        heap.insert(32);
        heap.insert(33);
        heap.insert(85);
        heap.insert(34);
        heap.insert(1);

        heap.printHeap();

    }

    @Override
    public void insert(int element) {
        heap[size] = element;
        size++;

        int currentIndex = size-1; 
        while (heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }

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

    // after the Max element is popped out, it is neccessary to rearrange the structure
    public void reArrangeTopDown() {

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
