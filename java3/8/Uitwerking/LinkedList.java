public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

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
            current.getNext().setPrevious(current);  
            this.tail = current.getNext();           // Of: this.tail = newNode
        }

        // BONUS: Maak de lijst circulair!
        // Dit kun je buiten de if/else laten, omdat je dit in beide gevallen hetzelfde zou doen
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
    }

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