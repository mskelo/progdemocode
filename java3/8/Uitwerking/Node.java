/**
 * TINPRO04-3 Les 8 // Stack and Queue, non-generic
 * 20240217 // m.skelo@hr.nl
 * SPO 5: Containerterminal
 * 
 */

public class Node {
    // Fields:
    private Node previous;
    private Node next;
    private Container value;
     
    // Constructor(s):
    public Node(Container value) {
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
    public Container getValue() {
        return this.value;
    }
}