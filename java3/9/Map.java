class Map {
    private Vrachtwagen head;
    private int size;

    public int size() {
        return this.size;
    }

    public void put(Vrachtwagen value) {
        Vrachtwagen newNode = value;
        if (head == null) {    // Of: this.size == 0
            head = newNode;
        } 
        else {
            Vrachtwagen current = head;
            while (current.getNext() != null) {
                if (current.getKenteken().equals(value.getKenteken())) {
                    System.out.println("Kenteken already exists! Aborting push!");
                    return;
                }
                current = current.getNext();
            }
            current.setNext(newNode);
        }  
        this.size++;
    }

    public Vrachtwagen remove(String kenteken) {
        Vrachtwagen current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKenteken().equals(value.getKenteken())) {
                Vrachtwagen returnVal = current.getNext();
                current.setNext(current.getNext().getNext());
                returnVal.setNext(null);
                this.size--;
                return returnVal;
            }
            current = current.getNext();
        }
        return null; 
    }

    public Vrachtwagen get(String kenteken) {
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value.getKenteken())) {
                return current.getNext().getValue();
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