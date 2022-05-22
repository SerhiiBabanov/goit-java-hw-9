import java.util.Objects;

public class MyQueue<E> {
    protected Node head;
    protected Node end;
    protected int countNodes;

    public MyQueue() {
        this.head = null;
    }

    /**
     * @param value an object to storage
     * @return this MyQueue
     */
    public MyQueue add(E value) {
        Node node = new Node();
        node.data = value;
        //if list is empty storage in head
        if (Objects.isNull(head)) {
            head = node;
            end = node;
        }
        // if list is not empty storage in the end
        else {
            end.next = node;
            node.previous = end;
            end = node;
        }
        countNodes++;
        return this;
    }

    /**
     * @param index of element to remove
     * @return this MyQueue
     */
    public MyQueue remove(int index) {
        Node currentNode = head;
        //looks for an item with an index
        while (index != 0) {
            index--;
            currentNode = currentNode.next;
        }
        // if the index = 0, delete the head
        if (currentNode == head) {
            head = head.next;
            countNodes--;
        }
        // if the index = last element, delete the end
        else if (currentNode == end) {
            end = currentNode.previous;
            countNodes--;
        }
        //if the index  is middle element
        else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            countNodes--;
        }
        return this;
    }

    /**
     * delete all elements in the MyQueue
     *
     * @return this MyQueue
     */
    public MyQueue clear() {
        head = null;
        end = null;
        countNodes = 0;
        return this;
    }

    /**
     * @return count of elements in the queue
     */
    public int size() {
        return countNodes;
    }

    /**
     * @return first element in the queue
     */
    public E peek() {
        return head.data;
    }

    /**
     * @return first element in the queue and delete it from the queue
     */
    public E pool() {
        E result = head.data;
        this.remove(0);
        return result;
    }

    class Node {
        protected Node previous;
        protected Node next;
        E data;

    }

}

