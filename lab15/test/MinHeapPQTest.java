import org.junit.Test;

import net.sf.saxon.functions.Minimax.Min;

import static com.google.common.truth.Truth.*;

public class MinHeapPQTest {

    @Test
    public void testAddOneThing() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("l", 2);
        String item = pq.poll();
        assertThat("l").isEqualTo(item);
    }

    @Test
    public void testAddThenRemove() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("h", 100);
        pq.insert("i", 0);
        String item = pq.poll();
        assertThat("i").isEqualTo(item);
        assertThat("h").isEqualTo(pq.poll());
    }

    /**
     * Tests that a MinHeapPQ can add and remove a single element.
     */
    @Test
    public void testOneThing() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        assertThat(pq.poll()).isNull();
        pq.insert("l", 2);
        assertThat(1).isEqualTo(pq.size());
        String item = pq.poll();
        assertThat("l").isEqualTo(item);
        assertThat(0).isEqualTo(pq.size());
    }

    // TODO: add some of your own tests here!

    @Test
    public void testMultipleInsertions() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("a", 5);
        pq.insert("b", 2);
        pq.insert("c", 8);
        pq.insert("d", 1);

        assertThat(pq.size()).isEqualTo(4);
        assertThat(pq.peek()).isEqualTo("d"); // 最小优先级

        // 按优先级顺序移除
        assertThat(pq.poll()).isEqualTo("d"); // priority 1
        assertThat(pq.poll()).isEqualTo("b"); // priority 2
        assertThat(pq.poll()).isEqualTo("a"); // priority 5
        assertThat(pq.poll()).isEqualTo("c"); // priority 8

        assertThat(pq.size()).isEqualTo(0);
    }

    @Test
    public void testPeekDoesNotRemove() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("test", 3.5);

        String peeked = pq.peek();
        assertThat(peeked).isEqualTo("test");
        assertThat(pq.size()).isEqualTo(1);
        assertThat(pq.peek()).isEqualTo("test"); // 再次peek应该返回相同结果
    }

    @Test
    public void testContains() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("apple", 1.0);
        pq.insert("banana", 2.0);

        assertThat(pq.contains("apple")).isTrue();
        assertThat(pq.contains("banana")).isTrue();
        assertThat(pq.contains("cherry")).isFalse();

        pq.poll(); // 移除apple
        assertThat(pq.contains("apple")).isFalse();
        assertThat(pq.contains("banana")).isTrue();
    }

    @Test
    public void testDuplicateInsertThrowsException() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("duplicate", 1.0);

        try {
            pq.insert("duplicate", 2.0);
            assertThat(false).isTrue(); // 应该不会到达这里
        } catch (IllegalArgumentException e) {
            // 期望的异常
        }
    }

    @Test
    public void testEmptyHeapOperations() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();

        assertThat(pq.size()).isEqualTo(0);
        assertThat(pq.poll()).isNull();
        assertThat(pq.contains("anything")).isFalse();
    }

    @Test
    public void testSamePriorities() {
        MinHeapPQ<String> pq = new MinHeapPQ<>();
        pq.insert("first", 5.0);
        pq.insert("second", 5.0);
        pq.insert("third", 5.0);

        assertThat(pq.size()).isEqualTo(3);
        // 相同优先级的元素顺序可能不确定，但都应该能被正确移除
        String first = pq.poll();
        String second = pq.poll();
        String third = pq.poll();

        assertThat(first).isAnyOf("first", "second", "third");
        assertThat(second).isAnyOf("first", "second", "third");
        assertThat(third).isAnyOf("first", "second", "third");
        assertThat(pq.size()).isEqualTo(0);
    }

    @Test
    public void testNegativePriorities() {
        MinHeapPQ<Integer> pq = new MinHeapPQ<>();
        pq.insert(1, -5.0);
        pq.insert(2, -10.0);
        pq.insert(3, 0.0);

        assertThat(pq.poll()).isEqualTo(2); // priority -10.0
        assertThat(pq.poll()).isEqualTo(1); // priority -5.0
        assertThat(pq.poll()).isEqualTo(3); // priority 0.0
    }

    @Test
    public void testLargeDataSet() {
        MinHeapPQ<Integer> pq = new MinHeapPQ<>();

        // 插入100个元素
        for (int i = 100; i > 0; i--) {
            pq.insert(i, i);
        }

        assertThat(pq.size()).isEqualTo(100);

        // 应该按优先级顺序返回（1到100）
        for (int i = 1; i <= 100; i++) {
            assertThat(pq.poll()).isEqualTo(i);
        }

        assertThat(pq.size()).isEqualTo(0);
    }
}