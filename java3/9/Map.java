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
                    // Onderschepte Container:
                    System.out.println("HALT! Douane!\nContainer ID: "+ value.getContainer().getID() +", Inhoud: "+ value.getContainer().getInhoud());
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
            if (current.getNext().getKenteken().equals(kenteken)) {
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
        Vrachtwagen current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKenteken().equals(kenteken)) {
                return current.getNext();
            }
            current = current.getNext();
        }
        return null;
    }

}