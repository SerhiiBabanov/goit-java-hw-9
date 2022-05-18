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

    public MyArrayList add(Integer value) {
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
        this.arrayOfObject = new Integer[10];
        this.indexOfFirstEmptySpace = 0;
        return this;
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
