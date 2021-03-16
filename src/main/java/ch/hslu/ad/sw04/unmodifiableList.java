package ch.hslu.ad.sw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cyrill
 */
public class unmodifiableList {

    public unmodifiableList() {
        List<String> list = new ArrayList<>();

        List<String> unmodifiableList = Collections.unmodifiableList(list);

    }

    void anstattNullKannManAuchEineLeereDatenstruktur() {
        
        // not :  if (object != null) 
            
        // ... = Collections.emptyList();
        // ... = Collections.emptySet();
        // ... = Collections.empty();
        
    }
    
    
// wenn List<String> dieListe

// public void add(List list, Object object)    ----> Fehler

// public void add(List<String> list, String s
    
    

}
