import java.util.*;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;

    private LinkedList<KeyValue<K, V>>[] slots;
    private int count;
    private int capacity;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        this.slots = new LinkedList[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    public void add(K key, V value) {
        this.growIfNeeded();

        int index = Math.abs(key.hashCode()) % this.capacity;

        LinkedList<KeyValue<K, V>> slot = this.slots[index];

        if (slot == null) {
            slot = new LinkedList<>();
        }

        for (KeyValue<K, V> current : slot) {
            if (current.getKey().equals(key)) {
                throw new IllegalArgumentException("Key already exist");
            }
        }

        KeyValue<K, V> toInsert = new KeyValue<>(key, value);

        slot.add(toInsert);
        this.slots[index] = slot;

        this.count++;
    }

    private int findSlotNumber(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    private void growIfNeeded() {
        if (((double) this.count + 1) / this.capacity > LOAD_FACTOR) {
            this.grow();
        }
    }

    private void grow() {
        HashTable<K, V> newHashTable = new HashTable<>(this.capacity * 2);

        for (LinkedList<KeyValue<K, V>> slot : this.slots) {
            if (slot != null) {
                slot.forEach(s -> newHashTable.add(s.getKey(), s.getValue()));
            }
        }

        this.slots = newHashTable.slots;
        this.capacity *= 2;
    }

    public int size() {
        return this.count;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean addOrReplace(K key, V value) {
        this.growIfNeeded();

        int index = this.findSlotNumber(key);

        LinkedList<KeyValue<K, V>> slot = this.slots[index];

        if (slot == null) {
            slot = new LinkedList<>();
        }

        boolean updated = false;
        for (KeyValue<K, V> current : slot) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                updated = true;
            }
        }

        if (!updated) {
            KeyValue<K, V> toInsert = new KeyValue<>(key, value);

            slot.add(toInsert);
            this.slots[index] = slot;

            this.count++;
        }

        return !updated;
    }

    public V get(K key) {
        KeyValue<K, V> pair = this.find(key);

        if (pair == null) {
            throw new IllegalArgumentException();
        }

        return pair.getValue();
    }

    public KeyValue<K, V> find(K key) {
        int index = this.findSlotNumber(key);

        LinkedList<KeyValue<K, V>> slot = this.slots[index];

        if (slot == null) {
            return null;
        }

        for (KeyValue<K, V> pair : slot) {
            if (key.equals(pair.getKey())) {
                return pair;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        return this.find(key) != null;
    }

    public boolean remove(K key) {
        int slotNumber = this.findSlotNumber(key);

        LinkedList<KeyValue<K, V>> slot = this.slots[slotNumber];

        if (slot == null) {
            return false;
        }

        for (KeyValue<K, V> pair : slot) {
            if (pair.getKey().equals(key)) {
                slot.remove(pair);
                this.count--;
                return true;
            }
        }

        return false;
    }

    public void clear() {
        this.capacity = INITIAL_CAPACITY;
        this.slots = new LinkedList[this.capacity];
        this.count = 0;
    }

    public Iterable<K> keys() {
        ArrayList<K> keys = new ArrayList<>();
        for (KeyValue<K, V> pair : this) {
            keys.add(pair.getKey());
        }

        return keys;
    }

    public Iterable<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (KeyValue<K, V> pair : this) {
            values.add(pair.getValue());
        }

        return values;
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator<KeyValue<K, V>> {
        private Deque<KeyValue<K, V>> elements;

        private HashTableIterator() {
            this.elements = new ArrayDeque<>();
            for (LinkedList<KeyValue<K, V>> slot : slots) {
                if (slot != null) {
                    elements.addAll(slot);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !this.elements.isEmpty();
        }

        @Override
        public KeyValue<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return this.elements.removeFirst();
        }
    }
}
