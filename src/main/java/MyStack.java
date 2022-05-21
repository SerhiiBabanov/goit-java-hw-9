public class MyStack<E> {
    private MyLinkedList<E> myLinkedList;

    public MyStack() {
        myLinkedList = new MyLinkedList();
    }
    public MyStack push(E value){
        myLinkedList.add(value);
        return this;
    }
    public MyStack remove(int index){
        myLinkedList.remove(index);
        return this;
    }

    public MyStack clear(){
        myLinkedList.clear();
        return this;
    }

    public int size(){
        return myLinkedList.size();
    }

    public E peek(){
        return myLinkedList.get(myLinkedList.size()-1);
    }

    public E pool(){
        E result = myLinkedList.get(myLinkedList.size()-1);
        this.remove(myLinkedList.size()-1);
        return result;
    }

}
