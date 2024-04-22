/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * Deze Thread moet gestopt worden met een `flag`.
 * Dat is een boolean variabele die als "lichtknop" fungeert, die "ingedrukt" 
 * kan worden als aan een bepaalde conditie voldaan is.
 * 
 * Deze Thread moet stoppen bij i==3. 
 * Nu wordt de counter bijgehouden in een for-loop; dit mag je veranderen.
 * Voeg ook alle Exception handling toe.
 */

class Bar extends Thread {
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