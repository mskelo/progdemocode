/**
 * TINPRO04-3 Les 11 // JCF
 * 20240308 // m.skelo@hr.nl
 * Tip: [ https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html ]
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
 
public class App {
    public static void main(String[] args) {
        /**
         * Lees het bestand in als List, 1 hele regel per index
         */
        List<String> lines = new ArrayList<>();
        Map<String, Container> kade = new HashMap<>();
        
        /**
         * I/O
         */
        try   { lines = Files.readAllLines(Paths.get("./input.txt")); } 
        catch ( IOException e ) { e.printStackTrace(); }
        
        for (String line : lines) {
            /**
             * Parse de 3 verschillende waardes op dezelfde regel 
             * met behulp van String.split():
             * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#split(java.lang.String)
             */
            String[] lineValues = line.split(" / ");
            // System.out.println(Arrays.toString(lineValues)); // Testregel
            
            /**
             * Vul nu de kade met de gesplitste waardes, regel voor regel.
             * Onthoud: elke vrachtwagen op de kade moet uniek zijn.
             */

            // Niet goed.
            // kade.put(lineValues[0], new Container(Integer.parseInt(lineValues[1]), lineValues[2]));
            
            // Goed.
            kade.putIfAbsent(lineValues[0], new Container(Integer.parseInt(lineValues[1]), lineValues[2]));

        }
        System.out.println(kade.get("A-744-RT").getInhoud()); // Testregel
        System.out.println(kade.get("J-708-WW").getInhoud()); // Testregel
    }
}
