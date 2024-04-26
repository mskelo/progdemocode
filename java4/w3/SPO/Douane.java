/**
 * TINPRO04-4 Les 5
 * SPO 1 - Hyperdouanecontrole
 * 20240422 // m.skelo@hr.nl
 */

import java.util.List;

public class Douane {
    private List<Vrachtwagen> wachtrij;

    public Douane(List<Vrachtwagen> wachtrij) {
        this.wachtrij = wachtrij;
    }
    

    /**
     * Maak van deze class een Thread.
     * 
     * Zorg dat elke Vrachtwagen in de wachtrij door de controle gaat
     * (checkContainer()).
     * Print de inhoud van de Container als de douane de container afwijst.
     */


    public boolean checkContainer(Container c) {
        String inhoud = c.getInhoud();
        int som = 0;
        for (char ch : inhoud.toCharArray()) {
            som += (int) ch;
        }
        return (som % 17 < 2); // All hail the magic numbers
    }
}
