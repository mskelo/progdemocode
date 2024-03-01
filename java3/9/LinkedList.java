class LinkedList {
    private Vrachtwagen head;
    private int size;

    public void push(Vrachtwagen value) {
        Vrachtwagen newNode = value;
        if (head == null) {    // Of: this.size == 0
            head = newNode;
        } 
        else {
            Vrachtwagen current = head;
            while (current.getNext() != null) {
                if (current.getNext().getKenteken().equals(value.getKenteken())) {
                    System.out.println("Kenteken already exists! Aborting push!");
                }
            }
            current.setNext(newNode);
        }  
    }

    public Vrachtwagen pop(String kenteken) {
        Vrachtwagen current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKenteken().equals(value.getKenteken())) {
                Vrachtwagen returnVal = current.getNext().getValue();
                current.setNext(current.getNext().getNext());
                return returnVal;
            }
            current = current.getNext();
        }
        return null; 
    }

    public void print() {
        Vrachtwagen current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}