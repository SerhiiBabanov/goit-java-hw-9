import java.util.Queue;

public class MyQueue<E> {
    private MyLinkedList<E> myLinkedList;

    public MyQueue() {
        myLinkedList = new MyLinkedList();
    }
    public MyQueue add(E value){
        myLinkedList.add(value);
        return this;
    }
    public MyQueue remove(int index){
        myLinkedList.remove(index);
        return this;
    }
    public MyQueue clear(){
        myLinkedList.clear();
        return this;
    }
    public int size(){
        return myLinkedList.size();
    }

    public E peek(){
        return myLinkedList.get(0);
    }
    public E pool(){
        E result = myLinkedList.get(0);
        this.remove(0);
        return result;
    }

}

