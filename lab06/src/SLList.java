import java.awt.*;

/**
 * An SLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class SLList {

    /* The first item (if it exists) is at sentinel.next. */
    private IntListNode sentinel;
    private int size;
    public static final int SENTINEL_VAL = 42;

    /**
     * IntListNode is a nested class that represents a single node in the
     * SLList, storing an item and a reference to the next IntListNode.
     */
    private static class IntListNode {
        /*
         * The access modifiers inside a private nested class are irrelevant:
         * both the inner class and the outer class can access these instance
         * variables and methods.
         */
        private int item;
        private IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof IntListNode other)) {
                return false;
            }
            return item == other.item;
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntListNode(SENTINEL_VAL, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntListNode(SENTINEL_VAL, null);
        sentinel.next = new IntListNode(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SLList other)) {
            return false;
        }
        if (size != other.size) {
            return false;
        }

        IntListNode l1 = sentinel.next;
        IntListNode l2 = other.sentinel.next;

        // because we checked size earlier, l2 will also reach sentinel when l1 reaches sentinel
        while (l1 != sentinel) {
            if (!l1.equals(l2)) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1.equals(sentinel) && l2.equals(other.sentinel);
    }

    @Override
    public String toString() {
        IntListNode l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntListNode(x, sentinel.next);
        size += 1;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {
        // TODO: YOUR CODE HERE
        int count = index;
        if (index > size()) {
            count = size;
        }
        IntListNode targetPre = sentinel;
        while (count-- != 0) {
            targetPre = targetPre.next;
        }
        IntListNode targetNext = targetPre.next;
        targetPre.next = new IntListNode(x, targetNext);
        size++;
    }

    /** Destructively reverses this list. */
    public void reverse() {
        if (size() == 0) {
            return;
        }
        IntListNode pointer = sentinel.next;
        IntListNode newLL = new IntListNode(pointer.item, sentinel);
        while (pointer.next != null && pointer.next != sentinel) {
            pointer = pointer.next;
            newLL = new IntListNode(pointer.item, newLL);
        }
        sentinel.next = newLL;
        // TODO: YOUR CODE HERE
    }
}