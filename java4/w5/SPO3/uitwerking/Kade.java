/**
 * TINPRO04-4 Les 10
 * SPO 3 - Trossen los!
 * 20240513 // m.skelo@hr.nl
 */

import java.util.ArrayList;
import java.util.List;

public class Kade {
    private List<Container> kade;

    public Kade() {
        this.kade = new ArrayList<>();
    }

    /**
     * `synchronized` in method signature is hetzelfde als `synchronized (this)`
     * Je moet de `lock hebben` op het Object waar je wait()/notify() op wilt aanroepen.
     *                                       /waar je gedeelde resource zit
     * 
     * We willen dus de Kade (this) locken, 
     * omdat alle Douane Threads en alle Hijskraan Threads 
     * (tegelijkertijd) naar Kade kunnen schrijven.
     * 
     * `synchronized` zorgt dat die Threads 1 voor 1 
     * (ipv tegelijk en door elkaar) bij de locked resource kunnen.
     */
    public synchronized Container getContainer() {
        if (!kade.isEmpty()) {
            try {
                Container c = kade.remove(0);
                System.out.println("Kade: Container "+c.getID()+" aan de hijskraan gegeven.");
                return c;
            } 
            catch(IndexOutOfBoundsException e1) {
                e1.printStackTrace();
            }
        } 
        else {
            System.out.println("Kade: Leeg! Even wachten.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized void addContainer(Container c) {
        if (kade.size() == 5) {
            System.out.println("Kade: Vol! Even wachten.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // vvv    Dit wordt uitgevoerd NA de notify() op Douane.java:28    vvv
        kade.add(c);
        System.out.println("Kade: Container "+c.getID()+" aan de kade toegevoegd.");
        notifyAll();
    }

    public synchronized int getSize() {
        return kade.size();
    }



    /**
     * Optioneel:
     * Toggle een flag om de threads te stoppen aan het einde van het programma.
     * Zonder dit werkt het ook, maar blijft het programma hangen als alle containers door de douane zijn.
     */

    private boolean stop_signal = false;
    
    public synchronized void toggle_stop_signal() {
        stop_signal = true;
    }

    public synchronized boolean is_stopped() {
        return stop_signal;
    }
}
