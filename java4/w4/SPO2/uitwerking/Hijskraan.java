/**
 * TINPRO04-4 Les 7
 * SPO 1+2 - Multithreaded douanecontrole + inladen
 * 20240506 // m.skelo@hr.nl
 */

import java.util.Random;

public class Hijskraan extends Thread {

    private String naam;

    public Hijskraan(String naam) {
        this.naam = naam;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Container container;
                System.out.println(naam+": container halen");
                container = Kade.getContainer();
    
                if(container == null) {
                    System.out.println(naam+": De kade lijkt leeg...");
                    break;
                }
    
                Random r = new Random();
                int tijd = r.nextInt(5000);
                tijd += 1000;
    
                System.out.println(naam+": Container "+container.getID()+" opgehaald...overladen ");
                sleep(tijd); //lalalalalalala
    
                System.out.println(naam+" wil container "+container.getID()+" plaatsen...");
                Schip.addContainer(container);
                System.out.println(naam+": Overladen "+container.getID()+" voltooid...");
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
