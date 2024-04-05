/**
 * TINPRO04-4 Les 1 // Thread controls
 * 20240405 // m.skelo@hr.nl
 * Lesoefening 1
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

class Foo {
    public void loop() {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
        }
    }
}

public class App {
    public static void main(String[] args) {
        Foo t1 = new Foo();
        t1.loop();

        System.out.println("Einde programma.");
    }
}
