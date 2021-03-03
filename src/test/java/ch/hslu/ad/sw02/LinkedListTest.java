/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cyrill
 */
public class LinkedListTest {

    public LinkedListTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class LinkedList.
     */
    @Test
    public void testMain() {

    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd() {

    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove() {
 
    }

    /**
     * Test of getSize method, of class LinkedList.
     */
    @Test
    public void testGetSize() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(new Allocation(100));
        Node node2 = new Node(new Allocation(100));
        
        list.add(node1);
        list.add(node2);
        
        Assertions.assertThat(list.getSize()).isEqualTo(2);
    }

}
