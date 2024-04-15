 /**
 * TINPRO04-4 Les 3 // Expertvoorbeeld: Thread Race
 * 20240415 // m.skelo@hr.nl
 * Demonstreert werking van join(), interrupt(), en sleep()
 */

import java.util.Random;  

public class App {
    public static void main(String[] args) {
        Contestant t0 = new Contestant("Example");
        
        Contestant t1 = new Contestant("Alice");
        Contestant t2 = new Contestant("Bob");
        Contestant t3 = new Contestant("Charlie");
        Contestant t4 = new Contestant("Dan");
        
        // Opwarmen
        System.out.println("Eerst 1x voordoen...");
        t0.start();
        try {
            t0.join();
        } 
        catch (Exception e) { // Welke Exception kan hier precies voorkomen?
            System.out.println(e);
        }

        // Heat 1
        System.out.println("Ready, set, GO!");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        // Heat 2
        System.out.println("Ready, set, GO!");
        t3.start();
        t4.start();

        // join() hier niet nodig, 
        // want main thread eindigt samen met de verliezer van heat 2
    }    
}

class Contestant extends Thread {
    Random r = new Random();
    private String threadName;
    
    public Contestant(String threadName) {
        this.threadName = threadName;
    }
    
    public void run() {
        try {
            for(int i=0; i < 6; i++) {
                System.out.println(this.threadName + ": " + i);

                // Als je de 4500 en 500 hier omdraait, zie je goed de werking van this.interrupt()
                int rendum = r.nextInt(4500) + 500; // min. 500, max. 5000

                if (rendum < 1000) {       // Joker, gg
                    continue;
                } 
                else if (rendum > 4800) {  // Seppuku
                    this.interrupt();
                }
                else {                     // Jammer joh
                    sleep(rendum);
                }
            }
            System.out.println(this.threadName + ": WINNER WINNER CHICKEN DINNER");
        } 
        catch (InterruptedException e) {
            System.out.println("Thread " + this.threadName + " interrupted. DNF.");
        } 
    }
}
