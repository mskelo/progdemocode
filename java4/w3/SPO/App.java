/**
 * TINPRO04-4 Les 5 // 
 * SPO 1
 * 20240422 // m.skelo@hr.nl
 * 
 *   === IDEE ===
 * 
 * - Knip de lijst van InputVrachtwagens in even grote stukken (na het parsen)
 *   zodat je meerdere kleine lijsten krijgt die te parallelliseren zijn.
 * 
 * - Laat weer alle vrachtwagens 1 voor 1 door de douane checken. Laat 1 seconde per vrachtwagen ertussen.
 *   Het standaardprogramma doet dit al. Idee is door het in meerdere stukken te knippen, 
 *   kan je elke "rij" parallel behandelen, wat een merkbaar tijdsverschil zal opleveren.
 *  
 * - Dit zal ook evenveel 'resultaatlijsten' opleveren, omdat ze nog niet meerdere Threads
 *   naar 1 (synchronized) List kunnen schrijven. Leuke oefening tegen die tijd om nog eens te herhalen.
 * 
 * - Nadat alle lijsten zijn verwerkt tot losse "resultaatlijsten", worden ze samengevoegd tot 1 lijst. 
 *   Nogmaals: omdat ze nog niet begrijpen wat synchronized is.
 * 
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
            
            // Goed.
            kade.putIfAbsent(lineValues[0], new Container(Integer.parseInt(lineValues[1]), lineValues[2]));

        }
        System.out.println(kade.get("A-744-RT").getInhoud()); // Testregel
        System.out.println(kade.get("J-708-WW").getInhoud()); // Testregel
    }
}
 