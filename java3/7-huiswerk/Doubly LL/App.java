/**
 * TINPRO04-3 Les 7-HW // Doubly Linked List, non-generic
 * 20240217 // m.skelo@hr.nl
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
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
    // Fields:
    private Node head;

    // Constructors (n/a)

    // Get/set methods (n/a)

    // Other methods:

    public void push(String value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        } 
        else {
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            current.getNext().setPrevious(current);  // Staar hier even naar.
        }

    }

    public String pop(String value) {
        Node current = this.head;
        while (current.getNext() != null) {
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

    public String pop(int index) {
        int currentindex = 0;
        Node current = head;
        while (currentindex != index && current.getNext() != null) {
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

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}