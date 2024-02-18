public class Node {
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
}