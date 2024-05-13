/**
 * TINPRO04-4 Les 10
 * SPO 3 - Trossen los!
 * 20240513 // m.skelo@hr.nl
 */

public class Vrachtwagen {
    private String kenteken;
    private Container container;

    public Vrachtwagen(String kenteken, Container container) {
        this.kenteken = kenteken;
        this.container = container;
    }

    public String getKenteken() {
        return this.kenteken;
    }
    public Container getContainer() {
        return this.container;
    }
}
