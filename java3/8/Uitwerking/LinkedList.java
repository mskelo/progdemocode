/**
 * TINPRO04-3 Les 8 // Stack and Queue, non-generic
 * 20240217 // m.skelo@hr.nl
 * SPO 4: Containerterminal
 * 
 */

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return this.size;
    }

    public void push(Container value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } 
        else {
            Node current = this.head;
            while (!current.getNext().equals(this.head)) {
                current = current.getNext();
            }
            current.setNext(newNode);
            current.getNext().setPrevious(current);  
            this.tail = current.getNext();           // Of: this.tail = newNode
        }

        this.size++;

        // BONUS: Maak de lijst circulair!
        // Dit kun je buiten de if/else laten, omdat je dit in beide gevallen hetzelfde zou doen
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
    }

    public Container pop(int index) {
        int currentindex = 0;
        Node current = head;
        while (currentindex != index && !current.getNext().equals(this.head)) {
            if (currentindex == index-1) {
                Node returnNode = current.getNext();
                
                // Verbind de huidige Node aan de eerstvolgende Node na de verwijderde Node
                // VERGEET NIET de verbinding in beide richtingen goed te leggen
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);

                this.size--;

                // Snij de verbindingen door in het verwijderde object om het geheugen vrij te maken
                returnNode.setPrevious(null);
                returnNode.setNext(null);

                return returnNode.getValue();
            }
            currentindex++;
            current = current.getNext();
        }
        return null;
    }

    public Container peek(Container value) {
        Node current = head;
        while (!current.getNext().equals(this.head)) {
            if (current.getNext().getValue().equals(value)) {
                return current.getNext().getValue();
            }
            current = current.getNext();
        }
        return null;
    }

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