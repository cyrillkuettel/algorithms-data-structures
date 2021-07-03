package ch.hslu.ad.sw04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Tips_Java_Generell {

    public Tips_Java_Generell() {
        List<String> list = new ArrayList<>();

        List<String> unmodifiableList = Collections.unmodifiableList(list);

    }

    void anstattNullKannManAuchEineLeereDatenstruktur() {
        // generally try to avoid check for null before accesssing data structure.

        // not :  if (object != null) 
        // -> better to just return a empty Object or empty Generic Collection.
        // ... = Collections.emptyList();
        // ... = Collections.emptySet();
        // ... = Collections.empty();
    }

    static <T> List<T> suchen(List<T> liste, Predicate<T> eigenschaft) { // Useful when implementing stream().filter()
        return liste.stream().filter(eigenschaft).collect(Collectors.toList());
    }

    void PredicateDemo() {
        List<Integer> liste = Arrays.asList(3, 5, 3, 0, -3, 1);
        List<Integer> negativeElemente = suchen(liste, t -> t < 0);

    }

}

// Charakterisierung:Immutable Class kann viele Vorteile haben.
/*
    alle attribute final
    alle methoden.
    klasse selber final.
    keine Setter methoden.
 */
