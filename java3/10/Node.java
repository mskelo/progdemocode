/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

 public class Node<T> {
    // Fields:
    private Node<T> previous;
    private Node<T> next;
    private T value;
     
    // Constructor(s):
    public Node(T value) {
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
    public T getValue() {
        return this.value;
    }
}