public class MyQueue<E> extends MyLinkedList<E> {
    public E peek(){
        return headNode.data;
    }
    public E pool(){
        E result = headNode.data;
        this.remove(0);
        return result;
    }
}

