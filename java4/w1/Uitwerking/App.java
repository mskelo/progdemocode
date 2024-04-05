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

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Einde programma.");
    }
}
