package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */
public class demoMessung {

    public static void main(String[] args) {
        Messung messung = new Messung(); //                      100'000 Objects
        messung.javaUtilStackMessen();
        messung.myOwnStackMessen();

        Messung messungMIllion = new Messung(1000000); //        1 Million Objects
        messungMIllion.javaUtilStackMessen();
        messungMIllion.myOwnStackMessen();

        Messung messung10Mio = new Messung(10000000); //         10 Million Objects
        messung10Mio.javaUtilStackMessen();
        messung10Mio.myOwnStackMessen();
    }

}
