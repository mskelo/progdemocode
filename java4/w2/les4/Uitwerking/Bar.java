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
 */

class Bar extends Thread {
    @Override
    public void run() {
        try {
            loop();
        } 
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Het verdwijnen van de countervariabele in de for-loop vergt extra aanpassingen.
     * Meerdere wegen naar Rome mogelijk hier.
     */
    public void loop() throws InterruptedException {
        boolean FLAG = false;
        int count = 0;

        while (!FLAG) {
            System.out.println(count++);
            sleep(1000);
            if (count==3) {
                FLAG = !FLAG;
            }
        }
    }

}

/**
 * Een paar andere varianten:
 */

// public void loop() throws InterruptedException {
//     for(int i = 0; i<5; i++) {
//         if (i!=3) {
//             System.out.println(i);
//             sleep(1000);
//         }
//         else return;
//     }
// }

// public void loop() throws InterruptedException {
//     for(int i = 0; i<5; i++) {
//         if (i==3) break; // of `return;`
//         else {
//             System.out.println(i);
//             sleep(1000)
//         }
//     }
// }

// public void loop() throws InterruptedException {
//     int i = 0;
//     while (true) {
//         if (i==3) break;
//         System.out.println(i);
//         sleep(1000);
//         i++;
//     }
// }


