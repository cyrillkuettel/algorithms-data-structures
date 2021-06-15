package ch.hslu.ad.sw01;

/**
 *
 * @author cyrill
 */
public class Rekursion {

    public static int calc(final int n) {
        if (n == 0) {
            return 0;
        } else {
            System.out.println("one");
            return calc(n - 1) + n + n - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("calc(5) = " + calc(5));
    }
}
