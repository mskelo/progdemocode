/**
 * TINPRO04-3 Les 10 // Alle datastructuren, generic
 * 20240304 // m.skelo@hr.nl
 * 
 */

public class Entry<K,V> {
    private K key;
    private V value;
    private Entry next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Entry getNext() {
        return this.next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
