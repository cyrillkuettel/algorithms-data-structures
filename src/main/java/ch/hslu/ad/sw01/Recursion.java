package ch.hslu.ad.sw01;

/**
 *
 * @author cyrill
 */
public class Recursion {

    public static void main(String[] args) {
        new Recursion();
    }

    public Recursion() {
        int zähler = 5;
         
        System.out.println(fiboRec1(9));
        System.out.println(fiboRec1(10));

    }

    public int fiboRec1(long n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }
}
