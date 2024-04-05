/**
 * TINPRO04-4 Les 1 // Thread controls
 * 20240405 // m.skelo@hr.nl
 * Uitwerking stap 1+2+3
 */


/**
 * Er zijn twee manieren om een Thread-class te schrijven:
 *      class Foo extends Thread {}
 * of:
 *      class Foo implements Runnable {}
 * 
 * Deze twee vormen zijn functioneel gelijk aan elkaar.
 * De class Thread implementeert zelf ook al de Runnable interface,
 * dus door Thread te extenden, implementeer je ook al Runnable.
 * 
 * Zie: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html
 *      https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Runnable.html
 * 
 * Runnable is een interface. Wat /moet/ je allemaal implementeren uit die interface?
 */

class Foo extends Thread {
    @Override
    public void run() {
        // De try/catch MOET hierin staan, want de overridden run() method bevat geen `throws InterruptedException`
        try {
            loop();
        } 
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Stap 1
    public void loop() throws InterruptedException {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            sleep(1000);
        }
    }
}

public class App {
    public static void main(String[] args) {
        Thread t1 = new Foo();
        Thread t2 = new Foo();

        // Stap 2
        t1.start();
        t2.start();

        System.out.println("Einde programma.");

        // Stap 3
        final int MAX_THREADS = 10000;
        Thread threads[] = new Foo[MAX_THREADS];
        for(int i=0; i < MAX_THREADS; i++) {
            threads[i] = new Foo();
        }
        for (Thread t : threads) {
            t.start();
        }

    }
}
