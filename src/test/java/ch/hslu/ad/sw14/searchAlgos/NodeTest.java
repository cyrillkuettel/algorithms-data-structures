package ch.hslu.ad.sw14.searchAlgos;

import java.util.Collections;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author cyrill
 */
public class NodeTest {

    public NodeTest() {
    }

    @Test
    public void testSomeMethod() {
        Node n1 = new Node("A");
        Node n2 = new Node("C");
        LinkedList<Node> qu = new LinkedList<>();

        qu.add(n1);
        qu.add(n2);
        assertThat(Collections.min(qu)).isEqualTo(n1);
    }

}
