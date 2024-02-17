/**
 * TINPRO04-3 Les 7-HW // (Circular) Doubly Linked List, non-generic
 * 20240217 // m.skelo@hr.nl
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppCircular {
    public static void main(String[] args) {
        // Lees ./input in zoals behandeld in Les 6: File I/O
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

/**
 * Grote verschil is de toevoeging van de nieuwe field: private Node previous (en bijbehorende get/set-methods).
 * Dat vergt ingrijpende aanpassingen aan je LinkedList methods.
 * 
 */
class Node {
    // Fields:
    private Node previous;
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
    public Node getPrevious() {
        return this.previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public String getValue() {
        return this.value;
    }

    // Other methods (n/a)
}

class LinkedList {
    // Fields:  (Belangrijk: nieuwe field Node tail)
    private Node head;
    private Node tail;

    // Constructors (n/a)

    // Get/set methods (n/a)

    // Other methods:

    /**
     * void push(String value): - Loopt Node voor Node door de lijst, en zet de meegegeven waarde aan het einde van de lijst neer (in een `new Node()`).
     *                          - Anders, als de lijst leeg is, wordt de head-Node gelijkgesteld aan de meegegeven parameter.
     * 
     */
    public void push(String value) {
        Node newNode = new Node(value);
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } 
        else {
            Node current = this.head;
            while (!current.getNext().equals(this.head)) {
                current = current.getNext();
            }
            current.setNext(newNode);
            current.getNext().setPrevious(current);  // Staar hier even naar.
            this.tail = current.getNext();           // Of: this.tail = newNode
        }

        // BONUS: Maak de lijst circulair!
        // Dit kun je buiten de if/else laten, omdat je dit in beide gevallen hetzelfde zou doen
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
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
        Node current = this.head;
        while (!current.getNext().equals(this.head)) {
            if (current.getNext().getValue().equals(value)) {
                Node returnNode = current.getNext();
                
                // Verbind de huidige Node aan de eerstvolgende Node na de verwijderde Node
                // VERGEET NIET de verbinding in beide richtingen goed te leggen, anders kan de GC z'n werk niet doen
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);

                // Snij de verbindingen door in het verwijderde object om het geheugen vrij te maken
                returnNode.setPrevious(null);
                returnNode.setNext(null);

                return returnNode.getValue();
            }
            current = current.getNext();
        }
        return "Not found";
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
        int currentindex = 0;
        Node current = head;
        while (currentindex != index && !current.getNext().equals(this.head)) {
            if (currentindex == index-1) {
                Node returnNode = current.getNext();
                
                // Verbind de huidige Node aan de eerstvolgende Node na de verwijderde Node
                // VERGEET NIET de verbinding in beide richtingen goed te leggen
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);

                // Snij de verbindingen door in het verwijderde object om het geheugen vrij te maken
                returnNode.setPrevious(null);
                returnNode.setNext(null);

                return returnNode.getValue();
            }
            currentindex++;
            current = current.getNext();
        }
        return "Not found";
    }

    /**
     * String peek(String value): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                            - Als er een bestaat, returnt de method de betreffende Node zonder de lijst te wijzigen
     *                            - Als geen bestaande waarde wordt gevonden returnt de method "Not found"
     * 
     */
    public String peek(String value) {
        Node current = head;
        while (!current.getNext().equals(this.head)) {
            if (current.getNext().getValue().equals(value)) {
                return current.getNext().getValue();
            }
            current = current.getNext();
        }
        return "Not found";
    }

    /**
     * void print(): Print alle waardes in de lijst achter elkaar, met een nette newline op het eind.
     * 
     */
    public void print() {
        Node current = this.head;
        do {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        while (!current.equals(this.head));
        
        System.out.println();
    }
}