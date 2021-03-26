package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */
public class demoMessung {

    public static void main(String[] args) {
        stackMessung();
        System.out.println();

//        dequeArrayMessung();
//        System.out.println();
//        System.out.println();
//        dequeLinkedListMessung();
    }

    static void stackMessung() {
        Messung messung = new Messung(); 
        messung.javaUtilStackMessen();
        messung.myOwnStackMessen();

        Messung messungMIllion = new Messung(1000000); 
        messungMIllion.javaUtilStackMessen();
        messungMIllion.myOwnStackMessen();

        Messung messung10Mio = new Messung(10000000); 
        messung10Mio.javaUtilStackMessen();
        messung10Mio.myOwnStackMessen();
    }

    static void dequeArrayMessung() {
        Messung messung = new Messung(); 
        messung.deque_ArrayDeque_Messung();

        Messung messungMIllion = new Messung(1000000); 
        messungMIllion.deque_ArrayDeque_Messung();

        Messung messung10Mio = new Messung(10000000); 
        messung10Mio.deque_ArrayDeque_Messung();

    }

    static void dequeLinkedListMessung() {
        Messung messung = new Messung();
        messung.deque_LinkedList_Messen();

        Messung messungMIllion = new Messung(1000000);
        messungMIllion.deque_LinkedList_Messen();

        Messung messung10Mio = new Messung(10000000); 
        messung10Mio.deque_LinkedList_Messen();

    }

}
