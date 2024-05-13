/**
 * TINPRO04-4 Les 7
 * SPO 1+2 - Multithreaded douanecontrole + inladen
 * 20240506 // m.skelo@hr.nl
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
     * We willen dus de Kade (this) locken
     */
    public synchronized Container getContainer() {
        if (kade.isEmpty()){
            System.out.println("Kade: Leeg! Even wachten.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // vvv    Dit wordt uitgevoerd NA een notify() elders.    vvv
        Container c = kade.remove(0);
        notifyAll();
        System.out.println("Kade: Container "+c.getID()+" aan de hijskraan gegeven.");
        return c;
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
        
        // vvv    Dit wordt uitgevoerd NA een notify() elders.    vvv
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
