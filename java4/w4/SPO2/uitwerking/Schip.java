/**
 * TINPRO04-4 Les 7
 * SPO 1+2 - Multithreaded douanecontrole + inladen
 * 20240506 // m.skelo@hr.nl
 */

import java.util.List;
import java.util.ArrayList;

public class Schip {

    private static List<Container> schip = new ArrayList<>();;

    public static synchronized void addContainer(Container c) {
        schip.add(c);
    }

    public static synchronized Container getContainer() {
        if (!schip.isEmpty()) {
            return schip.remove(0);
        } 
        else return null;
    }

    public void print() {
        System.out.println("Schip bevat:");
        for (Container c : schip) {
            System.out.println("Container "+c.getID()+" ("+c.getInhoud()+")");
        }
    }

    public static int getSize() {
        return schip.size();
    }
}
