/**
 * TINPRO04-3 Les 7 // Singly Linked List, non-generic
 * 20240216 // m.skelo@hr.nl
 * WARNING: LAX INPUT VALIDATION
 *
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
     * void push(String value): - Loopt Node voor Node door de lijst, en zet de meegegeven waarde aan het einde van de lijst neer (in een `new Node()`).
     *                          - Anders, als de lijst leeg is, wordt de head-Node gelijkgesteld aan de meegegeven parameter.
     * 
     */
    public void push(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } 
        else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
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
     * EXTRA: Deze method bevat een bug. Kan je hem vinden?
     * 
     */
    public String pop(String value) {
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                String returnVal = current.getNext().getValue();
                current.setNext(current.getNext().getNext());
                return returnVal;
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
        while (currentindex != index && current.getNext() != null) {
            if (currentindex == index-1) {
                String returnVal = current.getNext().getValue();
                current.setNext(current.getNext().getNext());
                return returnVal;
            }
            currentindex++;
            current = current.getNext();
        }
        return "n/a";
    }

    /**
     * String peek(String value): - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *                            - Als er een bestaat, returnt de method de betreffende Node zonder de lijst te wijzigen
     *                            - Als geen bestaande waarde wordt gevonden returnt de method "Not found"
     * 
     */
    public String peek(String value) {
        Node current = head;
        while (current.getNext() != null) {
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
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}