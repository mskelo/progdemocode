/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * run() kan geen Exceptions throwen; loop() nog wel.
 * De exception kan meteen afgevangen worden in loop(),
 * of doorgegeven worden aan run(), waar die alsnog afgehandeld moet worden.
 * 
 * De compiler geeft al een hint, omdat sleep() ook om exception handling schreeuwt
 */

public class Foo extends Thread {
    @Override
    public void run() {
        try {
            loop();
        } catch (InterruptedException e) {
            System.out.println("Foo was interrupted.");
        }
    }
    public void loop() throws InterruptedException {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            sleep(1000);
        }
    }
}