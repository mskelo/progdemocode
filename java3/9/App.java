/**
 * TINPRO04-3 Les 9 // Map (implemented using LinkedList), non-generic
 * 20240217 // m.skelo@hr.nl
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class App {
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        Map kade = new Map();
        

        // Push 5 nieuwe Containers op de kade
        // Geef iedere Container een oplopend ID, dus: 1, 2, 3, 4....
        for (int i = 0; i < MAX_SIZE; i++) {
            kade.push(new Container(i));
        }

        // Pop de Containers van de kade en push ze op het schip
        // Doe dit net zo lang totdat een van de gepopte Containers `null` is
        while (true) {
            Container temp = kade.pop();
            if (temp == null) break;
            schip.push(temp);
        }

        // Print de ID's van de Containers op het schip.
        // Idee is hier dat de Stack.print() nu niet te gebruiken is, want Container ipv String value.
        while (true) {
            Container temp = schip.pop();
            if (temp == null) break;
            System.out.println(temp.getID());
        }
    }
}
