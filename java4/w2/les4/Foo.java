/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * Pas deze class aan zodat het compileert en naar verwachting werkt; inclusief Exception handling.
 * Print iets op het scherm wanneer de Thread interrupted wordt.
 */

public class Foo extends Thread {
    @Override
    public void run() {
        loop();
    }
    public void loop() {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            sleep(1000);
        }
    }
}