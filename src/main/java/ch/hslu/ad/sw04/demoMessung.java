package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */
public class demoMessung {

    public static void main(String[] args) {
        stackMessung();
        System.out.println();
        dequeArrayMessung();
        System.out.println();
        dequeLinkedListMessung();
    }

    static void stackMessung() {
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

    static void dequeArrayMessung() {
        Messung messung = new Messung(); //                      100'000 Objects
        messung.deque_ArrayDeque_Messung();

        Messung messungMIllion = new Messung(1000000); //                      100'000 Objects
        messungMIllion.deque_ArrayDeque_Messung();

        Messung messung10Mio = new Messung(10000000); //                      100'000 Objects
        messung10Mio.deque_ArrayDeque_Messung();

    }

    static void dequeLinkedListMessung() {
        Messung messung = new Messung(); //                      100'000 Objects
        messung.deque_LinkedList_Messen();

        Messung messungMIllion = new Messung(1000000); //                      100'000 Objects
        messungMIllion.deque_LinkedList_Messen();

        Messung messung10Mio = new Messung(10000000); //                      100'000 Objects
        messung10Mio.deque_LinkedList_Messen();

    }

}
