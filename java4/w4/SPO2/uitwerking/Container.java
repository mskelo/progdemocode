/**
 * TINPRO04-4 Les 7
 * SPO 1+2 - Multithreaded douanecontrole + inladen
 * 20240506 // m.skelo@hr.nl
 */

public class Container {
    private int id;
    private String inhoud;
    public Container(int id, String inhoud) {
        this.id = id;
        this.inhoud = inhoud;
    }
    public int getID() {
        return this.id;
    }
    public String getInhoud() {
        return this.inhoud;
    }
}

