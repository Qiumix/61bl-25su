import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class BinarySearchTreeTest {

    // TODO: add some of your own tests here to test your implementation!

    @Test
    public void addTest() {
        BinarySearchTree<String> x = new BinarySearchTree<>();
        x.add("hi" + 1);
        for (int i = 1; i < 100; i++) {
            assertWithMessage("x shouldn't contain hi" + (i - 1))
                    .that(x.contains("hi" + (i - 1)))
                    .isEqualTo(false);
            assertWithMessage("x should contain hi" + i)
                    .that(x.contains("hi" + i))
                    .isEqualTo(true);
            x.add("hi" + (i + 1));
            x.delete("hi" + i);
        }
    }

    @Test
    public void containsTest() {
        BinarySearchTree<Integer> x = new BinarySearchTree();
        assertWithMessage("BST should not contain anything immediately after instantiation").that(x.contains(2)).isFalse();
        x.add(2);
        assertWithMessage("BST should contain 2 after adding 2").that(x.contains(2)).isTrue();
        x.add(3);
        assertWithMessage("BST should contain 3 after adding 3").that(x.contains(3)).isTrue();
        x.add(4);
        assertWithMessage("BST should contain 4 after adding 4").that(x.contains(4)).isTrue();
        x.add(2);
        x.delete(2);
        assertWithMessage("BST should not contain 2 after deleting 2").that(x.contains(2)).isFalse();
    }
}