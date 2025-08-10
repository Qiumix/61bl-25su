import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;

/** A suite of tests for IntList. */

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static method.
     * The main point of this is to convince you that assertEquals knows how to
     * handle IntLists just fine because we implemented IntList.equals.
     */
    @Test
    public void testOf() {
        IntList test = IntList.of(1, 2, 3, 4, 5);
        assertWithMessage("Created list is null").that(test).isNotNull();
        assertWithMessage("First item in the list was not 1").that(test.item).isEqualTo(1);
        assertWithMessage("Second item in the list was not 2").that(test.next.item).isEqualTo(2);
        assertWithMessage("Third item in the list was not 3").that(test.next.next.item).isEqualTo(3);
        assertWithMessage("Fourth item in the list was not 4").that(test.next.next.next.item).isEqualTo(4);
        assertWithMessage("Fifth item in the list was not 5").that(test.next.next.next.next.item).isEqualTo(5);
        assertWithMessage("Null expected, but instead found another node").that(test.next.next.next.next.next).isNull();

        IntList empty = IntList.of();
        assertWithMessage("Empty list should be null!").that(empty).isNull();

        IntList single = IntList.of(7);
        assertWithMessage("Single list should not be null!").that(single).isNotNull();
        assertWithMessage("Single list should start with 7").that(single.item).isEqualTo(7);
        assertWithMessage("Single list should only have a single node!").that(single.next).isNull();
    }

    @Test
    public void testGet() {
        IntList test = IntList.of(1, 2, 3, 4, 5);
        assertWithMessage("first item should be 1").that(test.get(0)).isEqualTo(1);
        assertWithMessage("second item should be 2").that(test.get(1)).isEqualTo(2);
        assertWithMessage("third item should be 3").that(test.get(2)).isEqualTo(3);
        assertWithMessage("fourth item should be 4").that(test.get(3)).isEqualTo(4);
        assertWithMessage("fifth item should be 5").that(test.get(4)).isEqualTo(5);
        try {
            test.get(5);
            assertWithMessage("Should throw IllegalArgumentException").fail();
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            assertWithMessage("Should throw IllegalArgumentException").fail();
        }

        try {
            test.get(-1);
            assertWithMessage("Should throw IllegalArgumentException for negative indices").fail();
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            assertWithMessage("Should throw IllegalArgumentException for negative indices").fail();
        }

        IntList single = IntList.of(0);
        assertWithMessage("first item should be 5").that(test.get(4)).isEqualTo(5);
        try {
            single.get(1);
            assertWithMessage("Should throw IllegalArgumentException").fail();
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            assertWithMessage("Should throw IllegalArgumentException").fail();
        }
    }

    @Test
    public void testToString() {
        assertWithMessage("toString does not work on singleton").that(IntList.of(1).toString()).isEqualTo("1");
        assertWithMessage("toString does not work on smaller list").that(IntList.of(2, 3, 4).toString()).isEqualTo("2 3 4");
        IntList test = IntList.of(1, 2, 3, 4, 5);
        assertWithMessage("toString does not work on test").that(test.toString()).isEqualTo("1 2 3 4 5");
    }

    @Test
    public void testEquals() {
        IntList a = IntList.of(1, 2, 3, 4, 5);
        IntList b = IntList.of(1, 2, 3, 4, 5);
        assertWithMessage("List should equal itself").that(a.equals(a)).isTrue();
        assertWithMessage("List should equal itself").that(b.equals(b)).isTrue();
        assertWithMessage("A should equal B").that(a.equals(b)).isTrue();
        assertWithMessage("B should equal A").that(b.equals(a)).isTrue();

        assertWithMessage("A should not equal a generic Object").that(a.equals(new Object())).isFalse();
        assertWithMessage("B should not equal a primitive").that(b.equals(242)).isFalse();

        assertWithMessage("A should not equal this smaller list").that(a.equals(IntList.of(1, 2, 3, 4))).isFalse();
        assertWithMessage("A should not equal this equal-length but different list").that(a.equals(IntList.of(1, 2, 3, 4, 6))).isFalse();
    }

    @Test
    public void testAdd() {
        IntList a = IntList.of(1, 2, 3);
        assertWithMessage("a does not equal (1, 2, 3)").that(a.equals(IntList.of(1, 2, 3))).isTrue();
        a.add(4);
        assertWithMessage("a does not equal (1, 2, 3, 4)").that(a.equals(IntList.of(1, 2, 3, 4))).isTrue();
        a.add(5);
        assertWithMessage("a does not equal (1, 2, 3, 4, 5)").that(a.equals(IntList.of(1, 2, 3, 4, 5))).isTrue();

        IntList single = IntList.of(1);
        assertWithMessage("single does not equal (1)").that(single.equals(IntList.of(1))).isTrue();
        single.add(2);
        assertWithMessage("single does not equal (1, 2)").that(single.equals(IntList.of(1, 2))).isTrue();
    }

    @Test
    public void testSmallest() {
        assertWithMessage("Smallest of list is 6").that(IntList.of(63, 6, 6, 74, 7, 8, 52, 33, 43, 6, 6, 32).smallest()).isEqualTo(6);
        assertWithMessage("Smallest of singleton is element").that(9).isEqualTo(IntList.of(9).smallest());
        assertWithMessage("Smallest of same element list is element").that(9).isEqualTo(IntList.of(9, 9, 9, 9, 9, 9, 9, 9, 9, 9).smallest());
        assertWithMessage("Smallest of 10 to 1 is 1").that(1).isEqualTo(IntList.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).smallest());
    }

    @Test
    public void testSquaredSum() {
        assertWithMessage("Squared sum of (1, 2, 3) should be 14").that(IntList.of(1, 2, 3).squaredSum()).isEqualTo(14);

        assertWithMessage("Squared sum of (1) should be 1").that(IntList.of(1).squaredSum()).isEqualTo(1);

        assertWithMessage("Squared sum of (1, 2) should be 5").that(IntList.of(1, 2).squaredSum()).isEqualTo(5);

        assertWithMessage("Squared sum of (1, 1) should be 2").that(IntList.of(1, 1).squaredSum()).isEqualTo(2);

        assertWithMessage("Squared sum of (3, 3) should be 18").that(IntList.of(3, 3).squaredSum()).isEqualTo(18);
    }

    @Test
    public void testDSquareList() {
        IntList L = IntList.of(1, 2, 3);
        assertWithMessage("Initial list should stay the same").that(L).isEqualTo(IntList.of(1, 2, 3));

        IntList.dSquareList(L);

        assertWithMessage("After dSquareList, list should be (1, 4, 9)").that(L).isEqualTo(IntList.of(1, 4, 9));
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     *
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty of, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     *
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testCatenate() {
        // TODO: Add tests
        IntList A = IntList.of(1, 2 ,3, 4);
        IntList B = IntList.of(5, 6 ,7, 8);
        IntList AB = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertWithMessage("IntList should be equal!")
                .that(AB.equals(IntList.catenate(A, B)))
                .isEqualTo(true);
        assertWithMessage("IntList should be equal!")
                .that(IntList.of(1, 2 ,3, 4).equals(A))
                .isEqualTo(true);
        assertWithMessage("IntList should be equal!")
                .that(IntList.of(5, 6 ,7, 8).equals(B))
                .isEqualTo(true);
        assertWithMessage("IntList should be equal!")
                .that(IntList.of(5, 6 ,7, 8).equals(IntList.catenate(IntList.of(), B)))
                .isEqualTo(true);
        assertWithMessage("IntList should be equal!")
                .that(IntList.of(1, 2 ,3, 4).equals(IntList.catenate(IntList.of(), A)))
                .isEqualTo(true);
    }

    @Test
    public void testDCatenate() {
        // TODO: Add test
        IntList A = IntList.of(1, 2 ,3, 4);
        IntList B = IntList.of(5, 6 ,7, 8);
        IntList AB = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertWithMessage("IntList should be equal!")
                .that(AB.equals(IntList.dcatenate(A, B)))
                .isEqualTo(true);
        assertWithMessage("IntList should be equal!")
                .that(AB.equals(A))
                .isEqualTo(true);
    }
}