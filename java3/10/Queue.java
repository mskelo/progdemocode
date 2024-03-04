/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

public class Queue<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    public void push(T value) {
        Node<T> newNode = new Node(value);
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

    public T pop() {
        T returnVal = null;
        if (this.size == 0) {
            return null;
        }
        else {
            Node<T> temp = this.tail;
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
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}
