package SW13;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Fabio
 */
public class RailwayNet2 {
    
    private ArrayList vertexList; // Die verknüpfte Liste der Speicherpunkte
    private int [] [] edges; // Die Adjazenzmatrix, die zum Speichern von Kanten verwendet wird
    private int numOfEdges; // Anzahl der Kanten
 
    public RailwayNet2(int n) {
        // Initialisierungsmatrix, eindimensionales Array und Anzahl der Kanten
        edges=new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
    }
 
         // Anzahl der Knoten ermitteln
    public int getNumOfVertex() {
        return vertexList.size();
    }
 
         // Anzahl der Kanten ermitteln
    public int getNumOfEdges() {
        return numOfEdges;
    }
 
         // Rückgabe der Daten von Knoten i
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }
 
         // Gib das Gewicht von v1 und v2 zurück
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }
 
         // Knoten einfügen
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }
 
         // Kante einfügen
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }
 
         //Knoten löschen
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }
 
         // Den Index des ersten benachbarten Knotens abrufen
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }
 
         // Entsprechend dem Index des vorherigen benachbarten Knotens, um den nächsten benachbarten Knoten zu erhalten
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

}
