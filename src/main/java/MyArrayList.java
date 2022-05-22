import java.lang.reflect.Array;

public class MyArrayList<E> {
    private E[] array;
    private final Class<E> clazz;
    private int pointer;

    /**
     * Create new object of MyArrayList.
     * @param clazz  Class of storage objects.
     */
    public MyArrayList(Class<E> clazz) {
        this.array = (E[]) Array.newInstance(clazz, 10);
        this.pointer = 0;
        this.clazz = clazz;
    }

    /**
     * Create new object of MyArrayList.
     * @param array Array of storage objects.
     */
    public MyArrayList(E[] array) {
        this.array = array.clone();
        this.pointer = array.length;
        this.clazz = (Class<E>) array[0].getClass();
    }

    /**
     * add a new object to MyArrayList.
     * @param value object for add.
     * @return this MyArrayList
     */
    public MyArrayList add(E value) {
        if (array.length == pointer){
            resize();
        }
        array[pointer] = value;
        pointer++;
        return this;
    }

    /**
     * remove an object from MyArrayList.
     * @param index  index of object in the storage.
     * @return this MyArrayList
     */
    public MyArrayList remove(int index){
        //if index is bigger than count of element in array or index < 0
        if (index >= pointer || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        //if index is the last element in array of objects
        if (index == pointer -1){
            array[index] = null;
            pointer--;
            return this;
        }
        //if index from 0 to array.length - 2 (it is not the last element)
        if (pointer - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, pointer - 1 - index);
            pointer--;
            return this;
        }

        return this;
    }

    /**
     * delete all objects in the MyArrayList.
     * @return this MyArrayList
     */
    public MyArrayList clear() {
        this.array = (E[]) Array.newInstance(clazz, 10);
        this.pointer = 0;
        return this;
    }

    /**
     * @return return count of objects in the MyArrayList.
     */
    public int size() {
        return pointer;
    }

    /**
     * @param index  index of object in the storage.
     * @return element from the MyArrayList with index
     */
    public E get(int index) {
        E result;
        try {
            result = array[index];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Index out of range of MyArrayList", e);
        }
        return result;
    }

    /**
     * Increase length of array for objects
     */
    private void resize(){
        int newSize = (int) (pointer * 1.5);
        E[] newArray = (E[]) Array.newInstance(clazz, newSize);
        if (pointer >= 0)
            System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
