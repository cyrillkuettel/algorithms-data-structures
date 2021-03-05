package ch.hslu.ad.sw02;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cyrill
 */
public class QueueTest {
    
    public QueueTest() {
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


    @Test
    public void testisFull() {
        Queue q = new Queue(8);
        q.add('A');
        q.add('B');
        q.add('C');
        q.add('D');
        
        q.add('E');
        q.add('F');
        q.add('G');
        q.add('H');
        
        boolean isFull = q.isFull();
        
       Assertions.assertThat(isFull).isEqualTo(true);
    }

    
}
