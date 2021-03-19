package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */
public class test_erste_n_natürliche_zahlen {

    public static void main(String[] args) {
        final int n = 10;
        final int m = 3000;
        
        System.out.println(aufgabeb(n, m));
    }

    static int f(int n) {
        if (n % 2 == 0) {
            n--;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    /*
    Beschreiben Sie einen rekursiven Algorithmus, der für jeweils zweibeliebige natürliche Zahlennundmden Ausdruckn! modmberechnet
     */

    static int aufgabeb(int n, int m) { // n und m berechnen: n! mod m
       return fak(n) % m;
    }

    static int fak(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fak(n - 1);
    }
}
