package ch.hslu.ad.sw02;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author cyrill
 */
public class Queue {

    private char[] storage;
    int indexHead;
    int indexTail = 0;

    int size;
    int countItems = 0;

    public static void main(String[] args) {
        Queue q = new Queue(8);
        q.add('D');
        q.add('D');
        q.add('D');
        q.add('D');
        
        q.add('D');
        q.add('D');
        q.add('D');
        q.add('D');
        System.out.println(q.isFull());
    }

    public Queue(int size) {
        this.size = size;
        storage = new char[this.size];
        indexHead = storage.length - 1; // zero based index

    }

    public void add(char in) {
        if (storage[indexTail] == '\u0000') { // wenn platz noch nicht besetzt
            storage[indexTail] = in;
            countItems++;

        } else {
            rotate();
            storage[indexTail] = in;

        }

    }

    public void rotate() {

        for (int i = 0; i < storage.length - 1; i++) {
            storage[i + 1] = storage[i];
        }
        storage[0] = '\u0000'; // slot free

    }

    public boolean isFull() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            System.out.println("looped: " + i);
            if (storage[indexTail] != '\u0000') {
                count++;
            }
        }
        if (count == storage.length) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String returnSTring = "";
        for (char c : storage) {
            returnSTring += c + " ; ";
        }
        return returnSTring;
    }

    public void remove(char in) {

        // TODO
        countItems--;
    }

}
