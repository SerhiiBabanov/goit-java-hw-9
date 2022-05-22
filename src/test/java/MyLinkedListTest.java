import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyLinkedList<Integer> testList;

    @BeforeEach
    void setUp() {
        testList = new MyLinkedList();
    }

    @Test
    void add() {
        assertEquals(testList.add(0).get(0), 0, "must be 0 when added in the head");
        assertEquals(testList.add(1).get(1), 1, " must be 1 when added in the end");
    }

    @Test
    void remove() {
        testList.add(0).add(1).add(2).add(3);
        assertEquals(testList.remove(1).get(1), 2, "after deleted middle element 1 element 2 must be number 2");
        assertEquals(testList.remove(0).get(0), 2, "after deleted first element 0 element 2 must be the first");
        assertEquals(testList.remove(1).get(0), 2, "after deleted last element 3 element 2 must be the last");
        assertEquals(testList.size(), 1, "after deleted 3 element size must be 1");
    }

    @Test
    void clear() {
        testList.add(0).add(1);
        testList.clear();
        assertEquals(testList.size(), 0, "after clear() size must be 0");
    }

    @Test
    void size() {
        assertEquals(testList.size(), 0, "size of empty list must be 0");
        assertEquals(testList.add(0).size(), 1, "after added 1 element size must be 1");
        assertEquals(testList.add(1).size(), 2, "after added second element size must be 2");
    }

    @Test
    void get() {
        testList.add(0).add(1).add(2);
        assertEquals(testList.get(0), 0, "get(0) must return element index 0");
        assertEquals(testList.get(1), 1, "get(1) must return element index 1");
        assertEquals(testList.get(2), 2, "get(2) must return element index 2");
    }
}