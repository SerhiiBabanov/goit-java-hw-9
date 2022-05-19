import java.util.Objects;

public class MyLinkedList<E> {
    private Node headNode;
    private Node lastNode;
    private int countElement;

    public MyLinkedList() {
        this.headNode =null;
    }


    public MyLinkedList add(E value) {
        Node node = new Node();
        node.data = value;
        if (Objects.isNull(headNode) ){
            headNode = node;
            lastNode = node;
        } else {
            lastNode.next = node;
            node.previous = lastNode;
            lastNode = node;
        }
        countElement++;
        return this;
    }
    public MyLinkedList remove(int index){
        Node currentNode = headNode;
        while (index!=0){
            index--;
            currentNode = currentNode.next;
        }
        if (currentNode == headNode){
            headNode = headNode.next;
            countElement--;
        } else if (currentNode == lastNode) {
            lastNode = currentNode.previous;
            countElement--;
        } else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            countElement--;
        }
        return this;
    }
    public MyLinkedList clear() {
        headNode = null;
        lastNode = null;
        countElement = 0;
        return this;
    }
    public int size() {

        return countElement;
    }
    public E get(int index) {
        Node currentNode = headNode;
        while (index!=0){
            index--;
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    class Node {
        protected Node previous;
        protected Node next;
        E data;

    }
}

