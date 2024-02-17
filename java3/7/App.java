/**
 * TINPRO04-3 Les 7 // Singly Linked List, non-generic
 * 20240217 // m.skelo@hr.nl
 * 
 * @Matej 20240217: Misschien in groepjes van 3, waarbij ieder een van: {push(), pop(), peek()} schrijft. 
 *                  Anders is het niet te doen in 1 les.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        // I/O
        // TIP: Gebruik Files.readString() om een bestand (File)  
        //      direct in een String te stoppen
        String input = "";
        try   { input = Files.readString(Paths.get("./input")); } 
        catch ( IOException e ) { e.printStackTrace(); }

        // Split het bestand op in een array van woorden (String)
        String splitString[] = input.split(" ");

        // Stop alle woorden in de LinkedList, achter elkaar.
        LinkedList list = new LinkedList();
        for (String str : splitString) {
            list.push(str);
        }

        // Tests
        list.print();
        list.pop("actually");
        list.print();
        list.pop(2);
        list.print();
    }
}

class Node {
    // Fields:
    private Node next;
    private String value;
    
    // Constructor(s):
    public Node(String value) {
        this.value = value;
    }

    // Get/set methods:
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public String getValue() {
        return this.value;
    }

    // Other methods (n/a)
}

class LinkedList {
    // Fields:
    private Node head;

    // Constructors (n/a)

    // Get/set methods (n/a)

    // Other methods:

    /**
     * void push(String value): - Pusht een gegeven String naar het einde van de lijst.
     *                          - Anders, als de lijst leeg is, wordt de head-Node gelijkgesteld aan de meegegeven parameter.
     * 
     */
    public void push(String value) {
        // TODO
    }


    /**
     * String pop(String value): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                           - Als het bestaat wordt de Node uit de lijst gehaald en wordt de huidige 
     *                             Node met de daaropvolgende Node verbonden om een doorlopende lijst te behouden.
     *                           - Als geen bestaande waarde wordt gevonden returnt het "Not found"
     * 
     */
    public String pop(String value) {
        // TODO
    }

    /**
     * String pop(int index): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                        - Als het bestaat wordt de Node uit de lijst gehaald en wordt de huidige 
     *                          Node met de daaropvolgende Node verbonden om een doorlopende lijst te behouden.
     *                        - Als geen bestaande waarde wordt gevonden returnt het "Not found"
     * 
     */
    public String pop(int index) {
        // TODO
    }

    /**
     * String peek(String value): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                            - Als het bestaat, returnt het de betreffende Node zonder de lijst te wijzigen
     *                            - Als geen bestaande waarde wordt gevonden returnt het "Not found"
     * 
     */
    public String peek(String value) {
        // TODO
    }

    /**
     * void print(): Print alle waardes in de lijst achter elkaar, met een nette newline op het eind.
     * 
     */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}