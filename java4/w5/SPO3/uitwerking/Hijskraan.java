/**
 * TINPRO04-4 Les 10
 * SPO 3 - Trossen los!
 * 20240513 // m.skelo@hr.nl
 */

public class Hijskraan extends Thread {

    private String naam;
    private Kade kade;
    private Schip schip;

    public Hijskraan(String naam, Kade kade, Schip schip) {
        this.naam = naam;
        this.kade = kade;
        this.schip = schip;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Container container;
                /**
                 * Om wait() of notify() aan te roepen op een Object wat een gedeelde resource bevat,
                 * moeten we eerst de lock op dat Object hebben. In dit geval `synchronized (kade)`
                 */
                synchronized (this.kade) {
                    if (this.kade.getSize() == 0 && !this.kade.is_stopped()) {
                        System.out.println("Kraan "+naam+": Kade leeg! Even wachten.");
                        this.kade.wait();
                    } else if (this.kade.is_stopped() && this.kade.getSize() == 0) {
                        System.out.println("Kraan "+naam+": Er zijn geen containers meer!");
                        return;
                    }
                    System.out.println("Kraan "+naam+": container halen");
                    container = this.kade.getContainer();
                }
    
                System.out.println("Kraan "+naam+" wil container "+container.getID()+" plaatsen...");
                int tijd = 3000;
                sleep(tijd); //lalalalalalala
                this.schip.addContainer(container);
                System.out.println("Kraan "+naam+": Overladen container "+container.getID()+" voltooid...");
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
