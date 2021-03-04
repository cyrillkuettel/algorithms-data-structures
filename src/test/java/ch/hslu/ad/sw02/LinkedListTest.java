/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author cyrill
 */
public class LinkedListTest {

    LinkedList list = new LinkedList();

    LinkedListTest() {
    }

    @Test
    void testPop() {

        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(100));
        list.add(node1);
        list.add(node2);

        Node topElement = list.pop();

        Assertions.assertThat(topElement).isEqualTo(node2);

    }

    @Test
    void testRemoveWithInvalidIndex() {
        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(101));
        Node node3 = new Node(new Allocation(103));

        list.add(node1);
        list.add(node2);
        list.add(node3);

        //choose wrong index
        assertFalse(list.removeAtIndex(44));
    }

    @Test
    void testRemoveTheOnlyElement() {
        Node node1 = new Node(new Allocation(100));

        list.add(node1);
        list.removeAtIndex(0);

        assertFalse(list.exists(node1));  // node2 should now longer be in the List
    }

    @Test
    void testEmptyStackException() {
        Node node1 = new Node(new Allocation(100));
        list.add(node1);
        list.removeAtIndex(0);
        assertThatExceptionOfType(EmptyStackException.class).isThrownBy(() -> { list.pop(); });
    }

    @Test

    void testRemove() {
        // set up the scene
        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(101));
        Node node3 = new Node(new Allocation(103));

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.removeAtIndex(1);

        assertFalse(list.exists(node2)); // node2 should now longer be in the List
    }

    @Test
    void testRemoveWithMoreElements() {
        Node[] nodes = new Node[7]; //create a couple
        Random random = new Random();

        for (int i = 6; i >= 0; i--) {
            int AllocationValue = random.nextInt(100 - 1 + 1) + 1;
            nodes[i] = new Node(new Allocation(AllocationValue));
        }
        for (int i = 6; i >= 0; i--) {
            list.add(nodes[i]);
        }
        // list looks like this:
        // make a function to print the list like this:
        //[null] -> [0] -> [1] -> [2] -> [3] -> [4] -> [5] -> [6] -> [null] 
        System.out.println(list.toString());

        list.removeAtIndex(6);
        System.out.println(list.toString());
        assertFalse(list.exists(nodes[6])); // 
    }

    @Test
    void testExist() {

        Node[] nodes = new Node[7]; //create a couple
        Random random = new Random(); // with Random values

        for (int i = 6; i >= 0; i--) {
            int AllocationValue = random.nextInt(100 - 1 + 1) + 1;
            nodes[i] = new Node(new Allocation(AllocationValue));
        }
        for (int i = 6; i >= 0; i--) {
            list.add(nodes[i]);
        }

        assertTrue(list.exists(nodes[6]));

    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    void testAdd() {

    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    void testToString() {

    }

    /**
     * Test of getSize method, of class LinkedList.
     */
    @Test
    void testGetSize() {
        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(100));

        list.add(node1);
        list.add(node2);

        Assertions.assertThat(list.getSize()).isEqualTo(2);
    }

}
