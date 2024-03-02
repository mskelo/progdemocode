/**
 * TINPRO04-3 Les 9 // Map, non-generic
 * 20240302 // m.skelo@hr.nl
 * SPO 5: Douanecontrole
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class App {
    private static final int MAX_STACK_SIZE = 5;
    public static void main(String[] args) {
        Map kade = new Map();
        for (Vrachtwagen v : InputVrachtwagens.aangemelde_vrachtwagens) {
            kade.put(v);
        }

    }
}
