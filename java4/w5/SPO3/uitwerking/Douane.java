/**
 * TINPRO04-4 Les 10
 * SPO 3 - Trossen los!
 * 20240513 // m.skelo@hr.nl
 */

import java.util.List;
import java.util.Random;

public class Douane extends Thread {
    private List<Vrachtwagen> wachtrij;
    private Kade kade;

    public Douane(List<Vrachtwagen> wachtrij, Kade kade) {
        this.wachtrij = wachtrij;
        this.kade = kade;
    }
    
    @Override
    public void run() {
        for (Vrachtwagen v : this.wachtrij) {
            if (check(v.getContainer())) {
                System.out.println("/!\\ Geweigerd door de douane: container " + v.getContainer().getID() + ", "+v.getContainer().getInhoud());
            } 
            else {
                synchronized (this.kade) {
                    this.kade.addContainer(v.getContainer());
                    this.kade.notify();
                }
            }
        }

        
        /**
         * Optioneel:
         * Toggle een flag om de threads te stoppen aan het einde van het programma.
         * Zonder dit werkt het ook, maar blijft het programma hangen als alle containers door de douane zijn.
         */
        synchronized (this.kade) {
            // System.out.println("STOP TRIGGERED!");
            this.kade.toggle_stop_signal();
            this.kade.notifyAll();
        }
    }

    public boolean check(Container c) {
        String inhoud = c.getInhoud();
        int som = 0;
        for (char ch : inhoud.toCharArray()) {
            som += (int) ch;
        }
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(5000)+1000);
        } catch (InterruptedException e) { }
        return (som % 17 < 2); // All hail the magic number
    }
}
