/**
 * TINPRO04-4 Les 5
 * SPO 1
 * 20240422 // m.skelo@hr.nl
 * 
 *   === UITLEG ===
 * 
 * - Knip de lijst van InputVrachtwagens in even grote stukken (na het parsen)
 *   zodat je meerdere kleine lijsten krijgt die te parallelliseren zijn.
 *   Gelijk mooie herhaling van Java OP3 door creatief (al zeg ik het zelf) gebruik van datastructuren.
 * 
 * - Laat weer alle vrachtwagens 1 voor 1 door de douane checken. Laat 1 seconde per vrachtwagen ertussen.
 *   Idee is door het in meerdere stukken te knippen, kan je elke "rij" parallel behandelen, wat een merkbaar tijdsverschil zal opleveren.
 *   (Misschien iets beter merkbaar als de input iets groter is dan 30)
 * 
 * - In plaats van returnen van Lists uit Threads en anderssoortige zwarte magie, 
 *   printen we alleen maar de Vrachtwagens op het scherm die door de douanecontrole komen
 * 
 * --> Cheat code level 9000+: 
 *     In de terminal kan je alsnog de output naar een bestand schrijven: 
 *       $ javac *java
 *       $ java App > output.txt
 *  
 * - Dit is nog een leuke om te herhalen wanneer `synchronized` om de hoek komt kijken.
 *   Dan kan je de output van elke Thread naar een gedeelde output laten schrijven.
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
        
        // I/O
        try   { lines = Files.readAllLines(Paths.get("./input.txt")); } 
        catch ( IOException e ) { e.printStackTrace(); }
        
        // Converteer de rauwe data in het inputbestand (regel voor regel)
        // naar datatypes waar we iets mee kunnen
        for (String line : lines) {
            String[] lineValues = line.split(" / ");
            // System.out.println(Arrays.toString(lineValues)); // Testregel
            kade.add(new Vrachtwagen(lineValues[0], new Container(Integer.parseInt(lineValues[1]), lineValues[2])));
        }

        /**
         * Knip de taak op in kleinere taken (van gelijke grootte) voor parallelle executie
         *  - Gandhi, misschien
         */

        // Leer jezelf aan om variabelen standaard immutable te maken als dat even kan
        final int MAX_VRACHTWAGENS_PER_RIJ = 5;
        final int AANTAL_VRACHTWAGENS = kade.size();        
        final int RIJSTROKEN = AANTAL_VRACHTWAGENS / MAX_VRACHTWAGENS_PER_RIJ;

        // Kleine breinbreker tussendoor om te kijken wie Java 3 heeft gehaald >:^) 
        // --> for (Vrachtwagen v : kade), maar na elke 5 moet je een nieuwe List starten
        List<List<Vrachtwagen>> voorgesorteerde_vrachtwagens = new ArrayList<>();
        for (int i = 0; i < kade.size(); i += MAX_VRACHTWAGENS_PER_RIJ) {
            List<Vrachtwagen> innerList = new ArrayList<>();
            for (int j = 0; j < MAX_VRACHTWAGENS_PER_RIJ; j++) {
                innerList.add(kade.get(i + j));
            }
            voorgesorteerde_vrachtwagens.add(innerList);
        }

        // Vul de Douane Threads met voorgesorteerde Vrachtwagens
        Thread[] douanecontrole = new Douane[RIJSTROKEN];
        for (int i=0; i<RIJSTROKEN; i++) {
            douanecontrole[i] = new Douane(voorgesorteerde_vrachtwagens.get(i));
        }

        // Start de Threads
        for (int i=0; i<douanecontrole.length; i++) {
            douanecontrole[i].start();
        }
    }
}
 
