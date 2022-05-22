import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList myArrayList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myArrayList = new MyArrayList(new Integer[]{0, 1, 2});
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(4, myArrayList.add(3).size());
        assertEquals(3, myArrayList.get(3));
    }

    @org.junit.jupiter.api.Test
    void removeFirstElement() {
        assertEquals(1, myArrayList.remove(0).get(0));
        assertEquals(2, myArrayList.size());
        assertEquals(2, myArrayList.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeLastElement() {
        assertEquals(0, myArrayList.remove(2).get(0));
        assertEquals(2, myArrayList.size());
        assertEquals(1, myArrayList.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeMiddleElement() {
        assertEquals(0, myArrayList.remove(1).get(0));
        assertEquals(2, myArrayList.size());
        assertEquals(2, myArrayList.get(1));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        assertEquals(0, myArrayList.clear().size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(3, myArrayList.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(0, myArrayList.get(0));
        assertEquals(1, myArrayList.get(1));
        assertEquals(2, myArrayList.get(2));
    }
}