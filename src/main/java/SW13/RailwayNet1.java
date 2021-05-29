package SW13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class RailwayNet1 { 
    private int noOfNodes ;
    private String[] nodeName
        = {
            "Zürich",
            "Dietikon",
            "Brugg",
            "Aarau",
            "Wohlen",
            "Lenzburg",
            "Zug",
            "Rotkreuz",
            "Luzern",
            "Arth-Goldau",
            "Zofingen",
            "Olten",
            "Pfäffikon"};
    private int[][] adjaMx;
//    private List<String> Nodes = new ArrayList<String>();

    RailwayNet1() {
        noOfNodes = nodeName.length;
        this.adjaMx = new int[noOfNodes][noOfNodes];
        init();
    }

    // Name des Knoten
    public String getNodeName(final int k) {
        return nodeName[k];
    }
    
    public void increaseArraySize(int size) {
        String[] newArr = new String[nodeName.length+size];


        for (int i = 0; i < nodeName.length; i++) {
            newArr[i] = nodeName[i];
        }
        this.nodeName = newArr;
    }

    // Anzahl Knoten
    public int getNoOfNodes() {
        return noOfNodes;
    }
    
    // Existiert diese Kante
    public boolean isEdge(final int i, final int j) {
        return adjaMx[i][j] != 0 ;
    }
    
    final void init() {
        String[] connections = {"Olten:Zürich:36", "Olten:Aarau:13", "Olten:Zofingen:7", "Zofingen:Lenzburg:34",
            "Zofingen:Luzern:35", "Luzern:Lenzburg:80", "Luzern:Rotkreuz:16", "Luzern:Arth-Goldau:30",
            "Arth-Goldau:Rotkreuz:15", "Arth-Goldau:Zug:20", "Arth-Goldau:Pfäffikon:39", "Zürich:Pfäffikon:30",
            "Zürich:Dietikon:12", "Zürich:Zug:25", "Zürich:Lenzburg:19", "Zug:Rotkreuz:12", "Rotkreuz:Wohlen:23",
            "Wohlen:Lenzburg:9", "Wohlen:Dietikon:30", "Dietikon:Lenzburg:19", "Dietikon:Brugg:16",
            "Brugg:Lenzburg:16", "Brugg:Aarau:13", "Aarau:Lenzburg:8"};

        for (String connection : connections) {
            String[] details = connection.split(":");
            int indexNameLinks = Arrays.asList(nodeName).indexOf(details[0]);
            int indexNameRechts = Arrays.asList(nodeName).indexOf(details[1]);
            int distance = Integer.valueOf(details[2]);
            adjaMx[indexNameLinks][indexNameRechts] = distance;
            // everything else is zero
        }

    }
    
    public void printTwoDimensionalArray() {
        for (int i = 0; i < adjaMx.length; i++) {
            for (int j = 0; j < adjaMx[i].length; j++) {
                String printThis = "%d ";
                if (adjaMx[i][j] == 0) {
                    printThis = "%d  ";
                }
                System.out.printf(printThis, adjaMx[i][j]);
            }
            System.out.println();
        }
    }

    public String[] getNodeName() {
        return nodeName;
    }

    public int[][] getAdjaMx() {
        return adjaMx;
    }
   
    // Knoten Einfügen
    public void insertNode(String nodeName, int[] connections){
        increaseArraySize(1);
        this.nodeName[this.nodeName.length-1]= nodeName;
        for(int i = 0; i < connections.length; i++ ){
            adjaMx[i][adjaMx.length -1] = connections[i];
            adjaMx[adjaMx.length -1][i] = connections[i];
        }
        
//        int array1 = this.nodeName.length;
//        int array2 = nodeName.length;
//        String[] result = new String[array1 + array2];
//        System.arraycopy(this.nodeName, 0, result, 0, array1);  
//        System.arraycopy(nodeName, 0, result,array1, array2); 
//        this.nodeName = result;
        
        
        
             
    }
    
}

