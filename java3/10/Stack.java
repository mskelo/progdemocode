/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

public class Stack<T> {
    private Node<T> top;
    private int size = 0;

    public void push(T value) {
        if (this.top == null) {
            this.top = new Node(value);
        } 
        else {
            Node<T> newNode = new Node(value);
            newNode.setNext(this.top);
            this.top = newNode;
        }  
        this.size++;
    }

    public T pop() {
        T returnVal = null;
        if (this.top != null) {
            Node<T> temp = this.top;
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
        Node<T> current = this.top;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}