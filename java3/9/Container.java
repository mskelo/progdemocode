/**
 * TINPRO04-3 Les 9 // Map, non-generic
 * 20240302 // m.skelo@hr.nl
 * SPO 5: Douanecontrole
 * 
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

