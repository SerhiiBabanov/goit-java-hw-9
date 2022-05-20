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

    @Test
    void add() {
        assertEquals(testQueqe.add(1).add(2).size(), 2);
    }

    @Test
    void remove() {
        assertEquals(testQueqe.add(0).add(1).add(2).add(3).size(), 4);
        assertEquals(testQueqe.remove(0).size(),3);
        assertEquals(testQueqe.remove(1).size(),2);
        assertEquals(testQueqe.remove(1).size(),1);
    }

    @Test
    void clear() {
        assertEquals(testQueqe.add(0).add(1).size(), 2);
        assertEquals(testQueqe.clear().size(), 0);
    }

    @Test
    void size() {
        assertEquals(testQueqe.add(0).add(1).size(), 2);
        assertEquals(testQueqe.clear().size(), 0);

    }

}