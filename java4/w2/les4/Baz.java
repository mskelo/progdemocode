/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * Bedenk andere manieren om de Thread te beeindigen.
 * Probeer er minstens 2-3 te bedenken, hoe creatiever (en omslachtiger), hoe beter :)
 * Vergeet de Exception handling weer niet.
 */

class Baz extends Thread {
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