package ch.hslu.ad.sw13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cyrill
 *
 *
 *
 * - Strecke hinzufügen [löschen]. - Anzahl Stationen abfragen. - Anzahl
 * Strecken abfragen. - Abfragen, ob direkte Strecke zwischen zwei Orten. - Für
 * einen Ort abfragen, nach welchen allen anderen Orten direkte Strecken führen.
 * - Fahrzeit für eine bestimmte direkte Strecke abfragen.
 *
 */
public class Railwaynet1 {

    private Integer numberOfNodes = 13;

    private Integer[][] adjMatrix;
    private final String[] listNodes
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

    void init() {
        String[] connections = {"Olten:Zürich:36", "Olten:Aarau:13", "Olten:Zofingen:7", "Zofingen:Lenzburg:34",
            "Zofingen:Luzern:35", "Luzern:Lenzburg:80", "Luzern:Rotkreuz:16", "Luzern:Arth-Goldau:30",
            "Arth-Goldau:Rotkreuz:15", "Arth-Goldau:Zug:20", "Arth-Goldau:Pfäffikon:39", "Zürich:Pfäffikon:30",
            "Zürich:Dietikon:12", "Zürich:Zug:25", "Zürich:Lenzburg:19", "Zug:Rotkreuz:12", "Rotkreuz:Wohlen:23",
            "Wohlen:Lenzburg:9", "Wohlen:Dietikon:30", "Dietikon:Lenzburg:19", "Dietikon:Brugg:16",
            "Brugg:Lenzburg:16", "Brugg:Aarau:13", "Aarau:Lenzburg:8"};
        
        System.out.println(Arrays.toString(connections));
        
        for (String connection : connections) {
            String[] details = connection.split(":");

            int indexNameLinks = Arrays.asList(listNodes).indexOf(details[0]);
            int indexNameRechts = Arrays.asList(listNodes).indexOf(details[1]);
            int distance = Integer.valueOf(details[2]);

            try {
                adjMatrix[indexNameLinks][indexNameRechts] = distance;
            } catch (Exception e) {
                System.out.printf("failed at connection %s. INdex are: %d and %d  \n",connection, indexNameLinks, indexNameRechts );
            }

            // 
            // everything else is zero
        }

    }

    public Railwaynet1() {

        this.adjMatrix = new Integer[numberOfNodes][numberOfNodes];
        init();
    }

    public static void main(String[] args) {
        new Railwaynet1();

    }

}
