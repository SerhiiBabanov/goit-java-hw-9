import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> testQueue;

    @BeforeEach
    void setUp() {
        testQueue = new MyStack<>();
    }

    @Test
    void peek() {
        testQueue.push(0).push(1).push(2);
        assertEquals(testQueue.peek(), 2, "must be 2");
    }

    @Test
    void pool() {
        testQueue.push(0).push(1).push(2);
        assertEquals(testQueue.pop(), 2, "must be 2");
        assertEquals(testQueue.size(), 2);
        assertEquals(testQueue.pop(), 1, "must be 1");
        assertEquals(testQueue.size(), 1);
    }

    @Test
    void push() {
        assertEquals(testQueue.push(1).push(2).size(), 2);
    }

    @Test
    void remove() {
        assertEquals(testQueue.push(0).push(1).push(2).push(3).size(), 4);
        assertEquals(testQueue.remove(0).size(), 3);
        assertEquals(testQueue.remove(1).size(), 2);
        assertEquals(testQueue.remove(1).size(), 1);
    }

    @Test
    void clear() {
        assertEquals(testQueue.push(0).push(1).size(), 2);
        assertEquals(testQueue.clear().size(), 0);
    }

    @Test
    void size() {
        assertEquals(testQueue.push(0).push(1).size(), 2);
        assertEquals(testQueue.clear().size(), 0);

    }

}