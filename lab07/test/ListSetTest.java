import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.IterableResult;

import java.util.Iterator;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.Truth.assertThat;


public class ListSetTest {

    @Test
    public void testBasics() {
        ListSet aSet = new ListSet();
        assertWithMessage("Size is not zero upon instantiation").that(aSet.size()).isEqualTo(0);
        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
            assertWithMessage("aSet should contain " + i).that(aSet.contains(i));
        }

        assertWithMessage("Size is not 50 after 50 calls to add").that(aSet.size()).isEqualTo(50);
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
            assertWithMessage("aSet should not contain " + i).that(!aSet.contains(i));
        }

        assertWithMessage("aSet is not empty after removing all elements").that(aSet.isEmpty());
        assertWithMessage("Size is not zero after removing all elements").that(aSet.size()).isEqualTo(0);
    }

    @Test
    public void testArray() {
        ListSet aSet = new ListSet();
        for (int i = 0; i < 100; i++) {
            aSet.add(i);
        }
        int[] arr2 = new int[100];
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Iterator iterator = aSet.elems.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            arr2[count++] = (int)iterator.next();
        }
        for (int i = 0; i < 100; i++) {
            assertWithMessage("should be equal")
                    .that(arr[i])
                    .isEqualTo(arr2[i]);
        }
    }
}