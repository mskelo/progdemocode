/**
 * TINPRO04-4 Les 7
 * SPO 1+2 - Multithreaded douanecontrole + inladen
 * 20240506 // m.skelo@hr.nl
 */

import java.util.ArrayList;
import java.util.List;

public class Kade {
    private static List<Container> kade = new ArrayList<>();

    public static synchronized void addContainer(Container c) {
        kade.add(c);
    }

    /**
     * Schrijf deze functie zo dat de eerste Container steeds returned wordt,
     * of anders: return null als de kade leeg is.
     */
    public static synchronized Container getContainer() {
        if (!kade.isEmpty()) {
            return kade.remove(0);
        } 
        else return null;
    }

    public static int getSize() {
        return kade.size();
    }
}
