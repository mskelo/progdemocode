/**
 * TINPRO04-3 Les 8 // Stack and Queue, non-generic
 * 20240217 // m.skelo@hr.nl
 * SPO 4: Containerterminal
 * 
 */

public class Stack {
    private Node top;
    private int size = 0;

    public void push(Container value) {
        if (this.top == null) {
            this.top = new Node(value);
        } 
        else {
            Node newNode = new Node(value);
            newNode.setNext(this.top);
            this.top = newNode;
        }  
        this.size++;
    }

    public Container pop() {
        Container returnVal = null;
        if (this.top != null) {
            Node temp = this.top;
            this.top = temp.getNext();
            temp.setNext(null);
            returnVal = temp.getValue();
            this.size--;
        }
        return returnVal;
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        Node current = this.top;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}