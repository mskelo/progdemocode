/**
 * TINPRO04-3 Les 8 // Stack and Queue, non-generic
 * 20240217 // m.skelo@hr.nl
 * SPO 4: Containerterminal
 * 
 */

public class Queue {
    private Node head;
    private Node tail;
    private int size = 0;

    public void push(Container value) {
        Node newNode = new Node(value);
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } 
        else {
            this.head.setPrevious(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    public Container pop() {
        Container returnVal = null;
        if (this.size == 0) {
            return null;
        }
        else {
            Node temp = this.tail;
            returnVal = temp.getValue();
            this.size--;
            if (this.size > 0) {
                this.tail = temp.getPrevious();
                this.tail.setNext(null);
            }
            temp.setPrevious(null);
        }
        return returnVal;
    }

    public int getSize() {
        return this.size;
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
