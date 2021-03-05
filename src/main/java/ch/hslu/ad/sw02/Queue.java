package ch.hslu.ad.sw02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
public class Queue {

    private static final Logger LOG = LogManager.getFormatterLogger(Queue.class);
    private char[] storage;
    int indexHead;
    int indexTail = 0;

    int size;
    int countItems = 0;

    public static void main(String[] args) {
        Queue q = new Queue(8);

        q.add('D');
        q.add('A');
        
    }

    public Queue(int size) {
        this.size = size;
        storage = new char[this.size];
        indexHead = storage.length - 1; // zero based index

    }

    public void add(char in) {
        if (isFull()) {
            LOG.warn("Queue is full. item will be overriten");
        }
        if (storage[indexTail] == '\u0000') { // wenn platz noch nicht besetzt
            storage[indexTail] = in;
        } else {
            rotate();
            storage[indexTail] = in;
        }
        countItems++;
    }

    public void rotate() {
        for (int i = 0; i < storage.length - 1; i++) {
            storage[i + 1] = storage[i];
        }
        storage[0] = '\u0000'; // slot free

    }

    public char getOldie() {    // [A] [B] [C] [ ] [ ] [ ] [ ]    <---- 
        // [0] [1] [2] [ ] [ ] 
        //add: [ ] [A] [B] [C] [ ] [ ] [ ] 
        char zwischenspeicher = storage[countItems - 1];
        rotate();
        countItems--;
        return zwischenspeicher;
    }

    public boolean isFull() {
        return (countItems == size);
    }

    public boolean isEmpty() {
        return (countItems == 0);
    }

    @Override
    public String toString() {
        String returnString = "";

        for (char c : storage) {
            returnString += c + " ; ";
        }
        return returnString;
    }

    public void testStream() {
        
        Stream<Character> cStream = IntStream.range(0, storage.length).mapToObj(i -> storage[i]);
        
        cStream.forEach( el -> System.out.println(el));
            
    }

    public void remove(char in) {

        // TODO
        countItems--;
    }

}
