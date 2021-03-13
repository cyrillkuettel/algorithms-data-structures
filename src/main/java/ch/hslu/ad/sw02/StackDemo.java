package ch.hslu.ad.sw02;

/**
 *
 * @author cyrill
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        System.out.println(stack.toString());

    }

}
