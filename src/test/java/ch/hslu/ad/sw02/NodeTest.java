package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyrill
 */
public class NodeTest {
    
    public NodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNext method, of class Node.
     */
    @Test
    public void testConstructor() {
        Allocation a = new Allocation(100);
        Node n0 = new Node(null);
        Node n2 = new Node(a);
        n0.setNext(n2);
        
        
    }

    /**
     * Test of getNext method, of class Node.
     */
    @Test
    public void testGetNext() {

    }
    
}
