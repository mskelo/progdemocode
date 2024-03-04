/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

class Map<K,V>{
    private Entry<K,V> head;
    private int size;

    public int size() {
        return this.size;
    }

    /**
     * Kleine aanpassing: returntype nu boolean ipv void
     * Om in main() te kunnen checken welke Containers er onderschept zijn
     * 
     */
    public boolean put(Entry entry) {
        Entry<K,V> newNode = entry;
        if (head == null) {    // Of: this.size == 0
            head = newNode;
        } 
        else {
            Entry<K,V> current = head;
            while (current.getNext() != null) {
                if (current.getKey().equals(entry.getKey())) {
                    return false;
                }
                current = current.getNext();
            }
            current.setNext(newNode);
        }  
        this.size++;
        return true;
    }

    public Entry remove(K key) {
        Entry<K,V> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKey().equals(key)) {
                Entry<K,V> returnVal = current.getNext();
                current.setNext(current.getNext().getNext());
                returnVal.setNext(null);
                this.size--;
                return returnVal;
            }
            current = current.getNext();
        }
        return null; 
    }

    public Entry get(K key) {
        Entry<K,V> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKey().equals(key)) {
                return current.getNext();
            }
            current = current.getNext();
        }
        return null;
    }

}