/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class App {
    public static void main(String[] args) {
        Map<String, Container> kade = new Map<>();
        for (Entry v : InputVrachtwagens.aangemelde_vrachtwagens) {
            /**
             * Om nog steeds te kunnen checken welke vrachtwagens (Entry) onderschept worden,
             * returnt put() nu true bij succes, en false bij duplicaat
             */
            if (!kade.put(v)) {
                Container c = (Container) v.getValue();
                System.out.println("HALT Douane! Container ID: "+c.getID()+". Inhoud: "+c.getInhoud());
            }
        }
    }
}
