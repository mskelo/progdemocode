/**
 * TINPRO04-3 Les 7-huiswerk // Doubly Linked List, non-generic
 * BONUS: Circular Doubly Linked List, non-generic
 * 20240216 // m.skelo@hr.nl
 */

public class App {
    public static void main(String[] args) {
        Node nodes[] = {
            new Node(1),
            new Node(67),
            new Node(28),
            new Node(9),
            new Node(81)
        };

        
}

class Node {
    private Node next;
    private String value;

    public Node(int value) {
        this.value = value;
    }
}

public class LinkedList {

    private Node head;

    public void push(int index, int value) {
        if (this.head == null) {
            head = new Node(data);
        } 
        else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }
}