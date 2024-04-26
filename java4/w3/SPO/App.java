/**
 * TINPRO04-4 Les 5
 * SPO 1 - Hyperdouanecontrole
 * 20240426 // m.skelo@hr.nl
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
  
public class App {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        List<Vrachtwagen> kade = new ArrayList<>();
        
        // Lees het inputbestand uit. Dit heb je vorige periode al eens geschreven.
        // TODO
        
        // Elke regel is een Vrachtwagen. Vul de kade met Vrachtwagens.
        // TODO

        /**
         * Knip de grote taak op in kleinere taken (van ~gelijke grootte) voor parallelle executie
         *  - Gandhi, probably
         */

        final int MAX_VRACHTWAGENS_PER_RIJ = 5;
        final int AANTAL_VRACHTWAGENS = kade.size();        
        final int RIJSTROKEN = AANTAL_VRACHTWAGENS / MAX_VRACHTWAGENS_PER_RIJ;

        // Kleine breinbreker: 
        // We willen ieter 'stukje' van de List in een aparte Thread afhandelen
        // Knip hier de `List kade` op in kleinere, even grote Lists.
        // Gebruik hier bovenstaande variabelen voor.
        
        // TODO

        // Maak en vul Douane Threads met voorgesorteerde Vrachtwagens
        Thread[] douanecontrole = new Douane[RIJSTROKEN];
        // TODO

        // Start de Threads
        // TODO
    }
}
 
