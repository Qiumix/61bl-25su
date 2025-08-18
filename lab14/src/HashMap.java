import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class HashMap<K, V> implements Map61BL<K, V> {

    /* TODO: Instance variables here */
    private ArrayList<Entry>[] buckets;
    private int defaultSize = 16;
    private double loadFactor = 0.75;
    private int size;

    /* TODO: Constructors here */
    public HashMap() {
        buildBucket(defaultSize);
        size = 0;
    }


    public HashMap(int theSize) {
        defaultSize = theSize;
        buildBucket(defaultSize);
        size = 0;
    }


    public HashMap(int theSize, double load) {
        this.loadFactor = load;
        defaultSize = theSize;
        buildBucket(defaultSize);
        size = 0;
    }

    public int capacity() {
        return buckets != null ? buckets.length : defaultSize;
    }

    /*
     * Build or resize the buckets to the given size;
     */
    private void buildBucket(int size) {
        if (buckets == null) {
            buckets = new ArrayList[size];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new ArrayList<>();
            }
            return;
        } else {
            ArrayList<Entry>[] temp = new ArrayList[size];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = new ArrayList<>();
            }
            Iterator<K> all = iterator();
            while (all.hasNext()) {
                Entry entry = getEntry(all.next());
                int pos = getPos((K) entry.key);
                temp[pos].add(entry);
            }
            buckets = temp;
            return;
        }
    }

    /* TODO: Interface methods here */

    @Override
    public void clear() {
        size = 0;
        buckets = null;
        buildBucket(defaultSize);
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private Entry getEntry(K key) {
        int pos = getPos(key);
        Iterator<Entry> iterator = buckets[pos].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        Entry entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        return (V) entry.value;
    }

    @Override
    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        } else {
            Entry entry1 = new Entry(key, value);
            int pos = getPos((K) entry1.key);
            buckets[pos].add(new Entry<>(key, value));
            size++;
        }
        if (1.0 * size / buckets.length > loadFactor) {
            buildBucket(buckets.length * 2);
        }
    }

    private int getPos(K key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    @Override
    public V remove(K key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            int pos = getPos(key);
            int index = buckets[pos].indexOf(entry);
            buckets[pos].remove(index);
            size--;
            return (V) entry.value;
        }
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        Entry entry = getEntry(key);
        if (entry != null && entry.value.equals(value)) {
            int pos = getPos(key);
            int index = buckets[pos].indexOf(entry);
            buckets[pos].remove(index);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        Stack<K> stack = new Stack<>();
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                stack.push((K) buckets[i].get(j).key);
            }
        }
        return stack.iterator();
    }

    private static class Entry<K, V> {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry) other).key)
                    && value.equals(((Entry) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}