import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of ints. A simple implementation of a set using a list.
 */
public class ListSet implements SimpleSet {

    List<Integer> elems;

    public ListSet() {
        elems = new ArrayList<Integer>();
    }

    /** Adds k to the set. */
    @Override
    public void add(int k) {
        if (elems.contains((Integer) k)) {
            return;
        }
        elems.add((Integer) k);
        // TODO: Implement this method.
    }

    /** Removes k from the set. */
    @Override
    public void remove(int k) {
        Integer toRemove = k;
        if (!elems.contains((Integer) toRemove)) {
            return;
        }
        int index = elems.indexOf(toRemove);
        elems.remove(index);
        // TODO - use the above variable with an appropriate List method.
        // The reason is beyond the scope of this lab, but involves
        // method resolution.
    }

    /** Return true if k is in this set, false otherwise. */
    @Override
    public boolean contains(int k) {
        return elems.contains(k);
        // TODO: Implement this method.
    }

    /** Return true if this set is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
      return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    @Override
    public int size() {
        // TODO: Implement this method.
        return elems.size();
    }

    /** Returns an array containing all of the elements in this collection. */
    @Override
    public int[] toIntArray() {
        Object[] temp = elems.toArray();
        int[] all = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            all[i] = (int)all[i];
        }
        // TODO - use a for loop!
        return all;
    }
}