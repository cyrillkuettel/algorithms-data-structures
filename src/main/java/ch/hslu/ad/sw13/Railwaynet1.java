package ch.hslu.ad.sw13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

    Map<Node, Set<Node>> map = new HashMap<>();

    void printit() {
        Iterator<Map.Entry<Node, Set<Node>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Node, Set<Node>> pair = it.next();

            Node key = pair.getKey();
            Set<Node> value = pair.getValue();

        }

    }
    private final String[] listNodes
        = {
            "Rotkreuz",
            "Luzern",
            "Arth-Goldau",
            "Zofingen",
            "Olten",
            "Pfäffikon"};

    void putin(String name, String ...elements) {
        
        Set<Node> set = new HashSet<>();
        Arrays.stream(elements).forEach(el -> set.add(new Node(el)));
        map.put(new Node(name), set);
        
    }
    
    void put() {
        Set<Node> set = new HashSet<>();
        set.add(new Node("Luzern"));
        set.add(new Node("Arth-Goldau"));
        set.add(new Node("Zug"));
        set.add(new Node("Wohlen"));

        map.put(new Node("Rotkreuz"), set);

        set = new HashSet<>();
        set.add(new Node("Rotkreuz"));
        set.add(new Node("Zofingen"));
        set.add(new Node("Arth-Goldau"));
        set.add(new Node("Lenzburg"));

        map.put(new Node("Luzern"), set);
        set = new HashSet<>();

        set.add(new Node("Zug"));
        set.add(new Node("Rotreuz"));
        set.add(new Node("Luzern"));
        set.add(new Node("Pfäffikon"));
        
        map.put(new Node("Arth-Goldau"), set);

        set = new HashSet<>();
        set.add(new Node("Luzern"));
        set.add(new Node("Olten"));
        set.add(new Node("Lenzburg"));

        map.put(new Node("Zofingen"), set);
        
        set = new HashSet<>();
        set.add(new Node("Zofingen"));
        set.add(new Node("Aarau"));
        set.add(new Node("Zürich"));

        map.put(new Node("Olten"), set);
        set = new HashSet<>();

        set.add(new Node("Arth Goldau"));
        set.add(new Node("Zürich"));

        map.put(new Node("Pfäffikon"), set);
        set = new HashSet<>();

        set.add(new Node("Zürich"));
        set.add(new Node("Arth-Goldau"));
        set.add(new Node("Rotkreuz"));

        map.put(new Node("Zug"), set);
        set = new HashSet<>();

        set.add(new Node("Wohlen"));
        set.add(new Node("Luzern"));
        set.add(new Node("Dietikon"));
        set.add(new Node("Brugg"));
        set.add(new Node("Aarau"));
        set.add(new Node("Zürich"));
        set.add(new Node("Zofingen"));

        map.put(new Node("Lenzburg"), set);

    }

    void init() {
        String[] connections = {"Olten:Zürich:36", "Olten:Aarau:13", "Olten:Zofingen:7", "Zofingen:Lenzburg:34",
            "Zofingen:Luzern:35", "Luzern:Lenzburg:80", "Luzern:Rotkreuz:16", "Luzern:Arth-Goldau:30",
            "Arth-Goldau:Rotkreuz:15", "Arth-Goldau:Zug:20", "Arth-Goldau:Pfäffikon:39", "Zürich:Pfäffikon:30",
            "Zürich:Dietikon:12", "Zürich:Zug:25", "Zürich:Lenzburg:19", "Zug:Rotkreuz:12", "Rotkreuz:Wohlen:23",
            "Wohlen:Lenzburg:9", "Wohlen:Dietikon:30", "Dietikon:Lenzburg:19", "Dietikon:Brugg:16",
            "Brugg:Lenzburg:16", "Brugg:Aarau:13", "Aarau:Lenzburg:8"};

        for (String connection : connections) {
            String[] details = connection.split(":");
            int indexNameLinks = Arrays.asList(listNodes).indexOf(details[0]);
            int indexNameRechts = Arrays.asList(listNodes).indexOf(details[1]);
            int distance = Integer.valueOf(details[2]);
            adjMatrix[indexNameLinks][indexNameRechts] = distance;
            // everything else is zero
        }

    }

    public Railwaynet1() {

        this.adjMatrix = new Integer[numberOfNodes][numberOfNodes];
        put();
        // init();
    }

    public static void main(String[] args) {
        new Railwaynet1();

    }

}
