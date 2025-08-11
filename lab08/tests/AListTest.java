import jh61b.grader.GradedTest;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.google.common.truth.Truth.assertWithMessage;

public class AListTest {

//     Uncomment the below if you want to test locally.
    @Test
    public void testHasNext() {
        System.out.println("Test that hasNext works properly when the iterator is initialized.");
        System.out.println("hasNext should return true when there are elements in the AList,");
        System.out.println("and false when there are not any elements.");
        AList<Integer> a = new AList<>();
        Iterator<Integer> it1 = a.iterator();
        assertWithMessage("Iterator should be empty for an empty AList so hasNext() should return false").that(!it1.hasNext());
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        Iterator<Integer> it2 = a.iterator();
        assertWithMessage("Iterator should have elements left so hasNext() should return true").that(it2.hasNext());
    }

    @Test
    public void testNext() {
        System.out.println("Tests that next returns the correct values and that hasNext returns");
        System.out.println("false when there are no elements left.");
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        Iterator<Integer> it = a.iterator();
        assertWithMessage("Iterator should have elements left so hasNext() should return true").that(it.hasNext());
        assertWithMessage("First call to next() should return 1").that(it.next().intValue()).isEqualTo(1);
        assertWithMessage("Iterator should have elements left so hasNext() should return true").that(it.hasNext());
        assertWithMessage("First call to next() should return 2").that(it.next().intValue()).isEqualTo(2);
        assertWithMessage("Iterator should have elements left so hasNext() should return true").that(it.hasNext());
        assertWithMessage("First call to next() should return 3").that(it.next().intValue()).isEqualTo(3);
        assertWithMessage("Iterator should be empty so hasNext() should return false").that(!it.hasNext());
    }

    @Test
    public void testFor() {
        System.out.println("Test that the Java for-each loop works.");
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        int count = 0;
        for (Integer i : a) {
            count += i;
        }
        assertWithMessage("Total sum of elements should be 6").that(count).isEqualTo(6);
    }

    @Test
    public void testIteratorIndependence() {
        System.out.println("Test that two iterator instances can work without tripping over each other.");
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        Iterator<Integer> i1 = a.iterator();
        Iterator<Integer> i2 = a.iterator();
        assertWithMessage("i1 should have elements left so hasNext() should return true").that(i1.hasNext());
        assertWithMessage("i2 should have elements left so hasNext() should return true").that(i2.hasNext());

        i1.next();
        i1.next();
        i1.next();
        assertWithMessage("i1 should have no elements left so hasNext() should return false").that(!i1.hasNext());
        assertWithMessage("i2 should have elements left so hasNext() should return true").that(i2.hasNext());


        assertWithMessage("First call to i2.next() should return 1").that((long) i2.next()).isEqualTo(1);
        assertWithMessage("i2 should have elements left so hasNext() should return true").that(i2.hasNext());
        assertWithMessage("Second call to i2.next() should return 2").that((long) i2.next()).isEqualTo(2);
        assertWithMessage("i2 should have elements left so hasNext() should return true").that(i2.hasNext());
        assertWithMessage("Third call to i2.next() should return 3").that((long) i2.next()).isEqualTo(3);
        assertWithMessage("i2 should have no elements left so hasNext() should return false").that(!i2.hasNext());
        assertWithMessage("i1 should have no elements left so hasNext() should return false").that(!i1.hasNext());

    }

    @Test
    public void testNoSuchElementException() {
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        Iterator<Integer> i1 = a.iterator();
        i1.next();
        i1.next();
        i1.next();

        try {
            i1.next();
            assertWithMessage("NoSuchElementException should be thrown if next() is called when there are no more elements.").fail();
        } catch (NoSuchElementException e) {

        }
    }
}