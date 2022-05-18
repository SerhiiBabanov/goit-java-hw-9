import java.lang.reflect.Array;

public class MyArrayList<E> {
    private E[] arrayOfObject;
    private E[] newArrayOfObject;
    private final Class<E> clazz;
    private int indexOfFirstEmptySpace;

    public MyArrayList(Class<E> clazz) {
        this.arrayOfObject = (E[]) Array.newInstance(clazz, 10);
        this.indexOfFirstEmptySpace = 0;
        this.clazz = clazz;
    }

    public MyArrayList(E[] innerArrayOfObject) {
        this.arrayOfObject = innerArrayOfObject.clone();
        this.indexOfFirstEmptySpace = innerArrayOfObject.length;
        this.clazz = (Class<E>) innerArrayOfObject[0].getClass();
    }

    public MyArrayList add(E value) {
        if (arrayOfObject.length == indexOfFirstEmptySpace){
            resize();
        }
        arrayOfObject[indexOfFirstEmptySpace] = value;
        indexOfFirstEmptySpace++;
        return this;
    }
    public MyArrayList remove(int index){
        if (index == indexOfFirstEmptySpace-1){
            arrayOfObject[index] = null;
            indexOfFirstEmptySpace--;
            return this;
        }

        if (indexOfFirstEmptySpace - 1 - index >= 0) {
            System.arraycopy(arrayOfObject, index + 1, arrayOfObject, index, indexOfFirstEmptySpace - 1 - index);
            indexOfFirstEmptySpace--;
            return this;
        }
        if (index >= indexOfFirstEmptySpace){
            throw new IndexOutOfBoundsException();
        }
        return this;
    }
    public MyArrayList clear() {
        this.arrayOfObject = (E[]) Array.newInstance(clazz, 10);
        this.indexOfFirstEmptySpace = 0;
        return this;
    }
    public int size() {
        return indexOfFirstEmptySpace;
    }
    public E get(int index) {
        E result;
        try {
            result = arrayOfObject[index];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Index out of range of MyArrayList", e);
        }
        return result;
    }
    private void resize(){
        int newSizeOfArrayOfObject = (int) (indexOfFirstEmptySpace * 1.5);
        E[] newArrayOfObject = (E[]) Array.newInstance(clazz, newSizeOfArrayOfObject);
        if (indexOfFirstEmptySpace >= 0)
            System.arraycopy(arrayOfObject, 0, newArrayOfObject, 0, indexOfFirstEmptySpace);
        arrayOfObject = newArrayOfObject;
    }
}
