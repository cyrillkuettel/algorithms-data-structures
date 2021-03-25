package ch.hslu.ad.sw04;

import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw02.AllocationStack;

import java.util.concurrent.ThreadLocalRandom;  // ThreadLocalRandom has a Random-
// instance per thread and safeguards against contention. 

/**
 *
 * @author cyrill
 */
public final class Messung {

    private static int CONST_OBJECTS;

    public Messung() {
        CONST_OBJECTS = 100000; // set default value 
    }

    public Messung(int n) {
        CONST_OBJECTS = n;
    }

    public void javaUtilStackMessen() {
        java.util.Stack<Allocation> stack = new java.util.Stack<>(); // java.util.Stack

        long start = System.currentTimeMillis();
        for (int i = 0; i < CONST_OBJECTS; i++) {
            stack.push(generateRandomAllocation());

        }
        long end = System.currentTimeMillis();
        System.out.println("Hat : " + ((end - start)) + " ms gebraucht, um " + CONST_OBJECTS + " Allocations auf Java.util.Stack zu pushen.");

    }

    public void myOwnStackMessen() {
        AllocationStack stack = new AllocationStack(); // java.util.Stack

        long start = System.currentTimeMillis();
        for (int i = 0; i < CONST_OBJECTS; i++) {
            stack.push(generateRandomAllocation());

        }
        long end = System.currentTimeMillis();
        System.out.println("Hat : " + ((end - start)) + " ms gebraucht, um " + CONST_OBJECTS + " Allocations auf Custom Stack zu pushen.");

    }

    public void AllocationArrayMessen() {
        long start = System.currentTimeMillis();
        Allocation[] arr = AllocationFactory(CONST_OBJECTS);;
        long end = System.currentTimeMillis();
        System.out.println("Hat : " + ((end - start)) + " ms gebraucht, um " + CONST_OBJECTS + " Array Plätze zu füllen");
    }

    public Allocation[] AllocationFactory(final int n) {
        Allocation[] arr = new Allocation[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateRandomAllocation();
        }
        return arr;
    }

    private Allocation generateRandomAllocation() {
        int randInt = ThreadLocalRandom.current().nextInt(20, CONST_OBJECTS);
        Allocation all = new Allocation(randInt);
        return all;
    }

}
