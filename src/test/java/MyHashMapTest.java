import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    private MyHashMap<Integer, String> myHashMap;

    @BeforeEach
    void setUp() {
        myHashMap = new MyHashMap<Integer, String>();
        myHashMap.put(1, "one");
    }

    @Test
    void put() {
        assertEquals(myHashMap.size(), 1);
        assertEquals(myHashMap.get(1), "one");
        myHashMap.put(1, "one");
        assertEquals(myHashMap.size(), 2);
        assertEquals(myHashMap.get(1), "one");
        myHashMap.put(2, "two");
        assertEquals(myHashMap.size(), 3);
        assertEquals(myHashMap.get(2), "two");
        myHashMap.put(21, "21");
        assertEquals(myHashMap.size(), 4);
        assertEquals(myHashMap.get(21), "21");

    }

    @Test
    void remove() {
        myHashMap.put(2, "two");
        myHashMap.put(21, "one");
        assertEquals(myHashMap.size(), 3);
        myHashMap.remove(2);
        assertEquals(myHashMap.size(), 2);
        assertNull(myHashMap.get(2));
        myHashMap.remove(21);
        assertEquals(myHashMap.size(), 1);
        assertEquals(myHashMap.get(1), "one");


    }

    @Test
    void clear() {
        myHashMap.clear();
        assertEquals(myHashMap.size(), 0);
    }

    @Test
    void size() {
        assertEquals(myHashMap.size(), 1);
    }

    @Test
    void get() {
        assertEquals(myHashMap.get(1), "one");
        myHashMap.put(21, "21");
        assertEquals(myHashMap.get(21), "21");

    }
}