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
        // Lees ./input in zoals behandeld in Les 6: File I/O

        // TIP: Gebruik Files.readString() om een bestand (File)  
        //      direct in een String te stoppen
        
        // TODO

        // Split het bestand op in een array van woorden (String)
        String splitString[] = // TODO

        // Stop alle woorden in de LinkedList in de juiste volgorde
        // TODO

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
     * void push(String value): - Loopt Node voor Node door de lijst, en zet de meegegeven waarde aan het einde van de lijst neer (in een `new Node()`).
     *                          - Anders, als de lijst leeg is, wordt de head-Node gelijkgesteld aan de meegegeven parameter.
     * 
     */
    public void push(String value) {
        // TODO
    }


    /**
     * String pop(String value): - Loop Node voor Node door de lijst heen.
     *                           - Als je ziet dat de /VOLGENDE/ Node een value heeft die gelijk is aan de meegegeven parameter:
     *                               - Sla de te verwijderen Node op in een tijdelijke variabele
     *                               - Stel de /HUIDIGE/ Node z'n `next` gelijk aan de eerstvolgende Node NA de verwijderde Node
     *                                 !!! Dit is enorm belangrijk: als je dit vergeet wordt de rest van de lijst 
     *                                     na de huidige Node opgeruimd door de Garbage Collector
     *                               - Return de waarde uit de verwijderde Node
     *                           - Als er geen Node met gegeven waarde in de lijst zit, returnt de method "Not found"
     * 
     */
     public String pop(String value) {
        // TODO
    }

    /**
     * String pop(int index): - Loop Node voor Node door de lijst heen.
     *                        - Als je ziet dat de huidige index == index-1:
     *                           - Sla de /VOLGENDE/ Node op in een tijdelijke variabele
     *                           - Stel de /HUIDIGE/ Node z'n `next` gelijk aan de eerstvolgende Node NA de verwijderde Node
     *                              !!! Dit is enorm belangrijk: als je dit vergeet wordt de rest van de lijst 
     *                                  na de huidige Node opgeruimd door de Garbage Collector
     *                           - Return de waarde uit de verwijderde Node
     *                        - Als er geen Node met gegeven waarde in de lijst zit, returnt de method "Not found"
     * 
     */
    public String pop(int index) {
        // TODO
    }

    /**
     * String peek(String value): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                            - Als er een bestaat, returnt de method de betreffende Node zonder de lijst te wijzigen
     *                            - Als geen bestaande waarde wordt gevonden returnt de method "Not found"
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