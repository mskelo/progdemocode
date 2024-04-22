/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * Bedenk andere manieren om de Thread te beeindigen.
 * Probeer er minstens 2-3 te bedenken, hoe creatiever (en omslachtiger), hoe beter :)
 */

class Baz extends Thread {
    @Override
    public void run() {
        try {
            loop();
        } 
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loop() throws InterruptedException {
        for(int i = 0; i<5; i++) {
            if (i!=3) {
                System.out.println(i);
                sleep(1000);
            }
            else return;
        }
    }
}

/**
 * Een paar andere varianten, hetzelfde als in Bar.java:
 */

// public void loop() throws InterruptedException {
//     boolean FLAG = false;
//     int count = 0;

//     while (!FLAG) {
//         System.out.println(count++);
//         sleep(1000);
//         if (i==3) {
//             FLAG = !FLAG;
//         }
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
