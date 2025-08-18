import org.checkerframework.checker.units.qual.min;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinHeapTest {

    @Test
    public void test1() {
        MinHeap<String> minHeap = new MinHeap<>();
        minHeap.insert("hello");
        assertThat(minHeap.findMin() == "hello");
        minHeap.insert("world");
        assertThat(minHeap.findMin() == "hello");
        minHeap.insert("welcome");
        minHeap.removeMin();
        assertThat(minHeap.findMin() == "welcome");
    }
}
