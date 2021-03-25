package ch.hslu.ad.sw04;

/**
 *
 * @author cyrill
 */
public class demoMessung {
    public static void main(String[] args) {
        Messung messung = new Messung();
        
        messung.measureTimeForStack();
        
        messung.measureTimeForArrayAllocation();
        
    }
   
}
