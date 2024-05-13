/**
 * TINPRO04-4 Les 10
 * SPO 3 - Trossen los!
 * 20240513 // m.skelo@hr.nl
 */

import java.util.List;
import java.util.ArrayList;

public class Schip {
    // Moet `static` zijn als de methods `static` zijn.
    // Daarom ook nergens `this.schip` maar gewoon `schip`
    private static List<Container> schip = new ArrayList<>();

    public synchronized void addContainer(Container c) {
        schip.add(c);
    }

    public synchronized Container getContainer() {
        if (!schip.isEmpty()) {
            return schip.remove(0);
        } 
        else return null;
    }

    public static void print() {
        System.out.println("Schip bevat:");
        for (Container c : schip) {
            System.out.println("Container "+c.getID()+" ("+c.getInhoud()+")");
        }
    }

    public static int getSize() {
        return schip.size();
    }
}
