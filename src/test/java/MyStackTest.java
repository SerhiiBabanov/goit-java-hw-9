import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> testQueqe;
    @BeforeEach
    void setUp() {
        testQueqe = new MyStack<>();
    }

    @Test
    void peek() {
        testQueqe.push(0).push(1).push(2);
        assertEquals(testQueqe.peek(), 2, "must be 2");
    }

    @Test
    void pool() {
        testQueqe.push(0).push(1).push(2);
        assertEquals(testQueqe.pool(), 2, "must be 2");
        assertEquals(testQueqe.size(), 2);
        assertEquals(testQueqe.pool(), 1, "must be 1");
        assertEquals(testQueqe.size(), 1);
    }

    @Test
    void push() {
        assertEquals(testQueqe.push(1).push(2).size(), 2);
    }

    @Test
    void remove() {
        assertEquals(testQueqe.push(0).push(1).push(2).push(3).size(), 4);
        assertEquals(testQueqe.remove(0).size(),3);
        assertEquals(testQueqe.remove(1).size(),2);
        assertEquals(testQueqe.remove(1).size(),1);
    }

    @Test
    void clear() {
        assertEquals(testQueqe.push(0).push(1).size(), 2);
        assertEquals(testQueqe.clear().size(), 0);
    }

    @Test
    void size() {
        assertEquals(testQueqe.push(0).push(1).size(), 2);
        assertEquals(testQueqe.clear().size(), 0);

    }

}