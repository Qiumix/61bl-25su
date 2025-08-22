import org.checkerframework.checker.units.qual.min;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinHeapTest {

    @Test
    public void test1() {
        MinHeap<String> minHeap = new MinHeap<>();
        minHeap.insert("hello");
        assertThat(minHeap.findMin()).isEqualTo("hello");
        minHeap.insert("world");
        assertThat(minHeap.findMin()).isEqualTo("hello");
        minHeap.insert("welcome");
        minHeap.removeMin();
        assertThat(minHeap.findMin()).isEqualTo("welcome");
    }

    @Test
    public void testEmptyHeap() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        assertThat(minHeap.size()).isEqualTo(0);
        assertThat(minHeap.findMin()).isNull();
        assertThat(minHeap.removeMin()).isNull();
        assertThat(minHeap.contains(5)).isFalse();
    }

    @Test
    public void testSingleElement() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(42);

        assertThat(minHeap.size()).isEqualTo(1);
        assertThat(minHeap.findMin()).isEqualTo(42);
        assertThat(minHeap.contains(42)).isTrue();
        assertThat(minHeap.contains(99)).isFalse();

        Integer removed = minHeap.removeMin();
        assertThat(removed).isEqualTo(42);
        assertThat(minHeap.size()).isEqualTo(0);
        assertThat(minHeap.findMin()).isNull();
    }

    @Test
    public void testMultipleIntegers() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);
        minHeap.insert(7);

        assertThat(minHeap.size()).isEqualTo(5);
        assertThat(minHeap.findMin()).isEqualTo(3);

        // 按升序移除元素
        assertThat(minHeap.removeMin()).isEqualTo(3);
        assertThat(minHeap.removeMin()).isEqualTo(5);
        assertThat(minHeap.removeMin()).isEqualTo(7);
        assertThat(minHeap.removeMin()).isEqualTo(10);
        assertThat(minHeap.removeMin()).isEqualTo(15);

        assertThat(minHeap.size()).isEqualTo(0);
    }

    @Test
    public void testDuplicateInsertThrowsException() {
        MinHeap<String> minHeap = new MinHeap<>();
        minHeap.insert("test");

        try {
            minHeap.insert("test");
            assertThat(false).isTrue(); // 不应该到达这里
        } catch (IllegalArgumentException e) {
            // 期望的异常
        }
    }

    @Test
    public void testContainsAfterOperations() {
        MinHeap<Character> minHeap = new MinHeap<>();
        minHeap.insert('c');
        minHeap.insert('a');
        minHeap.insert('b');

        assertThat(minHeap.contains('a')).isTrue();
        assertThat(minHeap.contains('b')).isTrue();
        assertThat(minHeap.contains('c')).isTrue();
        assertThat(minHeap.contains('d')).isFalse();

        minHeap.removeMin(); // 移除 'a'
        assertThat(minHeap.contains('a')).isFalse();
        assertThat(minHeap.contains('b')).isTrue();
        assertThat(minHeap.contains('c')).isTrue();
    }

    @Test
    public void testLargeDataSet() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // 按降序插入50个数字
        for (int i = 50; i > 0; i--) {
            minHeap.insert(i);
        }

        assertThat(minHeap.size()).isEqualTo(50);
        assertThat(minHeap.findMin()).isEqualTo(1);

        // 应该按升序返回
        for (int i = 1; i <= 50; i++) {
            assertThat(minHeap.removeMin()).isEqualTo(i);
        }

        assertThat(minHeap.size()).isEqualTo(0);
    }

    @Test
    public void testMixedOperations() {
        MinHeap<Double> minHeap = new MinHeap<>();

        minHeap.insert(3.14);
        minHeap.insert(2.71);
        assertThat(minHeap.findMin()).isEqualTo(2.71);

        minHeap.insert(1.41);
        assertThat(minHeap.findMin()).isEqualTo(1.41);

        Double removed = minHeap.removeMin();
        assertThat(removed).isEqualTo(1.41);
        assertThat(minHeap.findMin()).isEqualTo(2.71);

        minHeap.insert(0.5);
        assertThat(minHeap.findMin()).isEqualTo(0.5);
        assertThat(minHeap.size()).isEqualTo(3);
    }

    @Test
    public void testStringComparison() {
        MinHeap<String> minHeap = new MinHeap<>();
        minHeap.insert("zebra");
        minHeap.insert("apple");
        minHeap.insert("banana");
        minHeap.insert("cherry");

        // 字符串按字典序排列，"apple" 应该是最小的
        assertThat(minHeap.findMin()).isEqualTo("apple");

        assertThat(minHeap.removeMin()).isEqualTo("apple");
        assertThat(minHeap.removeMin()).isEqualTo("banana");
        assertThat(minHeap.removeMin()).isEqualTo("cherry");
        assertThat(minHeap.removeMin()).isEqualTo("zebra");
    }
}
