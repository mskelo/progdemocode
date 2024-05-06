/**
 * TINPRO04-4 Les 7
 * SPO 2
 * 20240506 // m.skelo@hr.nl
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
  
public class App {
    public static void main(String[] args) {
        // ================================================================ //
        //                          BEGIN SPO DEEL 1                        //
        // ================================================================ // 

        List<String> lines = new ArrayList<>();
        List<Vrachtwagen> checkin = new ArrayList<>();
        
        // I/O
        try   { lines = Files.readAllLines(Paths.get("./input.txt")); } 
        catch ( IOException e ) { e.printStackTrace(); }
        
        // Converteer de rauwe data in het inputbestand (regel voor regel)
        // naar datatypes waar we iets mee kunnen
        for (String line : lines) {
            String[] lineValues = line.split(" / ");
            // System.out.println(Arrays.toString(lineValues)); // Testregel
            checkin.add(new Vrachtwagen(lineValues[0], new Container(Integer.parseInt(lineValues[1]), lineValues[2])));
        }

        /**
         * Knip de taak op in kleinere taken (van gelijke grootte) voor parallelle executie
         *  - Gandhi, misschien
         */

        // Leer jezelf aan om variabelen standaard immutable te maken als dat even kan
        final int MAX_VRACHTWAGENS_PER_RIJ = 5;
        final int AANTAL_VRACHTWAGENS = checkin.size();        
        final int RIJSTROKEN = AANTAL_VRACHTWAGENS / MAX_VRACHTWAGENS_PER_RIJ;

        // Kleine breinbreker tussendoor om te kijken wie Java 3 heeft gehaald >:^) 
        // --> for (Vrachtwagen v : kade), maar na elke 5 moet je een nieuwe List starten
        List<List<Vrachtwagen>> voorgesorteerde_vrachtwagens = new ArrayList<>();
        for (int i = 0; i < checkin.size(); i += MAX_VRACHTWAGENS_PER_RIJ) {
            List<Vrachtwagen> innerList = new ArrayList<>();
            for (int j = 0; j < MAX_VRACHTWAGENS_PER_RIJ; j++) {
                innerList.add(checkin.get(i + j));
            }
            voorgesorteerde_vrachtwagens.add(innerList);
        }

        // Vul de Douane Threads met voorgesorteerde Vrachtwagens
        Thread[] douanecontrole = new Douane[RIJSTROKEN];
        for (int i=0; i<RIJSTROKEN; i++) {
            douanecontrole[i] = new Douane(voorgesorteerde_vrachtwagens.get(i));
        }

        // Start de Threads. Dit stopt ook meteen de 'schone' Containers in Kade.
        for (int i=0; i<douanecontrole.length; i++) {
            douanecontrole[i].start();
        }

        // ================================================================ //
        //                          BEGIN SPO DEEL 2                        //
        // ================================================================ //

        Hijskraan[] kranen = { 
            new Hijskraan("Foo"), 
            new Hijskraan("Bar"), 
            new Hijskraan("Baz") 
        };

        for (Hijskraan kraan : kranen) {
            kraan.start();
        }

        for (Hijskraan kraan : kranen) {
            try { kraan.join(); } catch (Exception e) {}
        }

        // Check of de kade nu leeg is en het schip vol
        System.out.println("\nKade size: "+Kade.getSize() + "\nSchip size: " + Schip.getSize());
    }
}
 
