package ch.hslu.ad.sw02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Fabio
 */
public class QueueTest {

    public QueueTest() {
    }

    @Test
    public void testMain() {
        Queue q = new Queue(8);
        q.add('a');
        q.add('r');
        q.add('f');
        q.add('c');

        q.add('s');
        q.add('j');
        q.add('q');
        q.add('q');

        assertTrue(q.isFull());

    }

    @Test
    public void testIsEmpty() {
        Queue q = new Queue(8);
        assertTrue(q.isEmpty());
    }

    @Test
    public void testRemove() {
    }

}
