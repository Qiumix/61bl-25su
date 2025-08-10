/**
 * Represent a set of nonnegative ints from 0 to maxElement (inclusive) for some initially
 * specified maxElement.
 */
public class BooleanSet implements SimpleSet {

    private boolean[] contains;
    private int size;

    /** Initializes a set of ints from 0 to maxElement. */
    public BooleanSet(int maxElement) {
        contains = new boolean[maxElement + 1];
        size = 0;
    }

    private void resize(int newCap) {
        boolean[] newArray = new boolean[newCap];
        for (int i = 0; i < contains.length; i++) {
            newArray[i] = contains[i];
        }
        for (int i = contains.length; i < newCap; i++) {
            newArray[i] = false;
        }
        contains = newArray;
    }
    /** Adds k to the set. */
    @Override
    public void add(int k) {
        if (k > contains.length - 1) {
            resize(k + 1);
        }
        if (contains[k]) {
            return;
        }
        size++;
        contains[k] = true;
        // TODO: Implement this method.
    }

    /** Removes k from the set. */
    @Override
    public void remove(int k) {
        if (!contains[k]) {
            return;
        }
        contains[k] = false;
        size--;
        // TODO: Implement this method.
    }

    /** Return true if k is in this set, false otherwise. */
    @Override
    public boolean contains(int k) {
        return contains[k];
    }


    /** Return true if this set is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    @Override
    public int size() {
        return size;
        // TODO: Implement this method.
    }

    /** Returns an array containing all of the elements in this collection. */
    @Override
    public int[] toIntArray() {
        int[] all = new int[size];
        int count = 0;
        for (int i = 0; i < contains.length; i++) {
            if (contains[i]) {
                all[count++] = i;
            }
        }
        // TODO: Implement this method.
        return all;
    }
}