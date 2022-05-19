import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue<Integer> testQueqe;
    @BeforeEach
    void setUp() {
        testQueqe = new MyQueue();
    }

    @Test
    void peek() {
        testQueqe.add(0).add(1).add(2);
        assertEquals(testQueqe.peek(), 0, "must be 0");
    }

    @Test
    void pool() {
        testQueqe.add(0).add(1).add(2);
        assertEquals(testQueqe.peek(), 0, "must be 0");
        assertEquals(testQueqe.peek(), 0, "must be 1");
    }
}