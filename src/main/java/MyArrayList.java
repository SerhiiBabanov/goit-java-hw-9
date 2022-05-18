public class MyArrayList {
    private Integer[] arrayOfObject;
    private int indexOfFirstEmptySpace;

    public MyArrayList() {
        this.arrayOfObject = new Integer[10];
        this.indexOfFirstEmptySpace = 0;
    }

    public MyArrayList(Integer[] innerArrayOfObject) {
        this.arrayOfObject = innerArrayOfObject.clone();
        this.indexOfFirstEmptySpace = innerArrayOfObject.length;
    }

    public void add(Integer value) {
        if (arrayOfObject.length - 1 == indexOfFirstEmptySpace){
            resize();
        }
        arrayOfObject[indexOfFirstEmptySpace] = value;
        indexOfFirstEmptySpace++;
    }
    public void remove(int index){
        if (index == indexOfFirstEmptySpace-1){
            arrayOfObject[index] = null;
            indexOfFirstEmptySpace--;
        }

        if (indexOfFirstEmptySpace - 2 - index >= 0)
            System.arraycopy(arrayOfObject, index + 1, arrayOfObject, index, indexOfFirstEmptySpace - 2 - index);
        if (index >= indexOfFirstEmptySpace){
            throw new IndexOutOfBoundsException();
        }

    }
    public void clear() {
        this.arrayOfObject = new Integer[10];
        this.indexOfFirstEmptySpace = 0;
    }
    public Integer size() {
        return indexOfFirstEmptySpace;
    }
    public Integer get(int index) {
        Integer result;
        try {
            result = arrayOfObject[index];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Index out of range of MyArrayList", e);
        }
        return result;
    }
    private void resize(){
        int newSizeOfArrayOfObject = (int) (indexOfFirstEmptySpace * 1.5);
        Integer[] newArrayOfObject = new Integer[newSizeOfArrayOfObject];
        if (indexOfFirstEmptySpace >= 0)
            System.arraycopy(arrayOfObject, 0, newArrayOfObject, 0, indexOfFirstEmptySpace);
        arrayOfObject = newArrayOfObject;
    }
}
