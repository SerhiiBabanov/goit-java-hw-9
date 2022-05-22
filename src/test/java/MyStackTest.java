import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> testStack;

    @BeforeEach
    void setUp() {
        testStack = new MyStack<Integer>();
    }

    @Test
    void peek() {
        testStack.push(0).push(1).push(2);
        assertEquals(testStack.peek(), 2, "must be 2");
    }

    @Test
    void pool() {
        testStack.push(0).push(1).push(2);
        assertEquals(testStack.pop(), 2, "must be 2");
        assertEquals(testStack.size(), 2);
        assertEquals(testStack.pop(), 1, "must be 1");
        assertEquals(testStack.size(), 1);
    }

    @Test
    void push() {
        assertEquals(testStack.push(1).push(2).size(), 2);
    }

    @Test
    void remove() {
        assertEquals(testStack.push(0).push(1).push(2).push(3).size(), 4);
        assertEquals(testStack.remove(0).size(), 3);
        assertEquals(testStack.remove(1).size(), 2);
        assertEquals(testStack.remove(1).size(), 1);
    }

    @Test
    void clear() {
        assertEquals(testStack.push(0).push(1).size(), 2);
        assertEquals(testStack.clear().size(), 0);
    }

    @Test
    void size() {
        assertEquals(testStack.push(0).push(1).size(), 2);
        assertEquals(testStack.clear().size(), 0);

    }

}