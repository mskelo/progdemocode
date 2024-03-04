/**
 * TINPRO04-3 Les 9 // Map, non-generic
 * 20240302 // m.skelo@hr.nl
 * SPO 6: Douanecontrole
 * 
 */

public class Vrachtwagen {
    private String kenteken;
    private Container lading;
    private Vrachtwagen next;

    public Vrachtwagen(String kenteken, Container lading) {
        this.kenteken = kenteken;
        this.lading = lading;
    }

    public Vrachtwagen getNext() {
        return this.next;
    }

    public void setNext(Vrachtwagen next) {
        this.next = next;
    }

    public String getKenteken() {
        return this.kenteken;
    }

    public Container getContainer() {
        return this.lading;
    }

    public void setContainer(Container lading) {
        this.lading = lading;
    }
}
