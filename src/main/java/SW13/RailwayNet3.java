/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Fabio
 */
public class RailwayNet3 {

    private static final Logger LOG = LogManager.getFormatterLogger(RailwayNet3.class);

    class Node {

        String name;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;

        }

        @Override
        public String toString() {
            return "Node{" + "name=" + name + '}';
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Node)) {
                return false;
            }
            final Node other = (Node) object;
            return (other.name.equals(this.name));
        }

    }

    final Map<Node, Set<Node>> map;

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

        Set<Node> setZh = new HashSet<>();
        setZh.add(new Node("Pfäffikon"));
        setZh.add(new Node("Dietikon"));
        setZh.add(new Node("Zug"));
        setZh.add(new Node("Lenzburg"));
        setZh.add(new Node("Olten"));

        map.put(new Node("Zürich"), setZh);

        Set<Node> setDk = new HashSet<>();
        setDk.add(new Node("Zürich"));
        setDk.add(new Node("Wohlen"));
        setDk.add(new Node("Brugg"));
        setDk.add(new Node("Lenzburg"));

        map.put(new Node("Dietikon"), setDk);

        Set<Node> setBg = new HashSet<>();
        setBg.add(new Node("Aarau"));
        setBg.add(new Node("Dietikon"));
        setBg.add(new Node("Lenzburg"));

        map.put(new Node("Brugg"), setBg);

        Set<Node> setAa = new HashSet<>();
        setAa.add(new Node("Brugg"));
        setAa.add(new Node("Lenzburg"));
        setAa.add(new Node("Olten"));

        map.put(new Node("Aarau"), setAa);

        Set<Node> setWh = new HashSet<>();
        setWh.add(new Node("Lenzburg"));
        setWh.add(new Node("Dietikon"));
        setWh.add(new Node("Rotkreuz"));

        map.put(new Node("Wohlen"), setWh);
    }

    public void print() {
        Iterator<Map.Entry<Node, Set<Node>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Node, Set<Node>> pair = it.next();

            Node key = pair.getKey();
            Set<Node> value = pair.getValue();
            System.out.println(key);
            value.forEach(el -> System.out.print(el.toString()));
            System.out.println();
        }

    }

    public RailwayNet3() {
        map = new HashMap<>();
        put();
    }

    public void insert(String name, String... elements) {
        Set<Node> set = new HashSet<>();
        Arrays.stream(elements).forEach(el -> set.add(new Node(el)));

        // go through the set of new inserted Items.
        set.forEach(el -> {
            if (map.containsKey(el)) { // if there is already an entry for this Station
                map.get(el).add(new Node(name)); // At this entry, add the new Station to the Set aswell (to ensure bidirectional ) 
            }
        });

        map.put(new Node(name), set);
    }

    public void delete(String name) {
        boolean found = false;
        Iterator<Map.Entry<Node, Set<Node>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Node, Set<Node>> pair = it.next();
            if (pair.getKey().equals(new Node(name))) { // delete the node itself.
                it.remove();
                found = true;
            }
        }

        for (Map.Entry<Node, Set<Node>> pair : map.entrySet()) { // delete all connections to this particular node.
            Iterator<Node> ite = pair.getValue().iterator(); // iterator for each Set
            while (ite.hasNext()) {
                if (ite.next().getName().equals(name)) {
                   ite.remove(); // remove the old connection, we no longer need
                }
            }
        }

        if (!found) {
            LOG.warn("Did not find " + name);
        }
    }

    

    public int getStation() {
        return map.size();
    }

//    public int getVerbindungen(){
//         Iterator<Map.Entry<Node, Set<Node>>> it = map.entrySet().iterator();
//         Set<Node, Node> kl = new HashSet<>();
//            while (it.hasNext()) {
//            Map.Entry<Node, Set<Node>> pair = it.next();
//            LOG.info(pair.getKey().getName());
//            pair.getValue().forEach(el -> kl.add(el));
//            
//            }
//            
//        return kl.size();
//    }
    public int getVerbindungen(String name) {
        return map.get(new Node(name)).size();
    }

    public boolean dirVerbindung(String name, String ziel) {
        return map.get(new Node(name)).contains(new Node(ziel));
    }

}
