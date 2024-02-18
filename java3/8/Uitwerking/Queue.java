public class Queue {
    private Node head;
    private Node tail;
    private int size = 0;

    public void push(String value) {
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

    public String pop() {
        String returnVal = "";
        if (this.tail != null) {
            Node temp = this.tail;
            this.tail = temp.getPrevious();
            temp.setPrevious(null);
            returnVal = temp.getValue();
            this.size--;
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
