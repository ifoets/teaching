package interview.advance;

public class MyLinkedHashMap<K,V> {

    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyLinkedHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];

        // Check if key already exists
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                current.value = value; // update
                return;
            }
            current = current.next;
        }

        // Insert new node
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        buckets[index] = newEntry;
        size++;

        // Resize if needed
        if ((1.0 * size) / buckets.length >= LOAD_FACTOR) {
            resize();
        }
    }
    public V remove(K key) {
        int index = getIndex(key);
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        buckets = new Entry[oldBuckets.length * 2];
        size = 0;

        for (Entry<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndex(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
   private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
