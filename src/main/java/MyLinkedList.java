import java.util.Objects;

public class MyLinkedList<E> {
    protected Node head;
    protected Node end;
    protected int countNodes;

    /**
     * Create new object of MyLinkedList.
     */
    public MyLinkedList() {
        this.head = null;
    }

    /**
     * add a new object to MyLinkedList.
     * @param value  object for add.
     * @return this MyLinkedList.
     */
    public MyLinkedList add(E value) {
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
     * remove an object from MyLinkedList.
     * @param index  index of object in the storage.
     * @return this MyLinkedList
     */
    public MyLinkedList remove(int index) {
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
     * delete all objects in the MyLinkedList.
     * @return this MyLinkedList
     */
    public MyLinkedList clear() {
        head = null;
        end = null;
        countNodes = 0;
        return this;
    }
    /**
     * @return return count of objects in the MyLinkedList.
     */
    public int size() {

        return countNodes;
    }
    /**
     * @param index  index of object in the storage.
     * @return element from the MyLinkedList with index
     */
    public E get(int index) {
        Node currentNode;
        // if index more close to the end, looking from the end
        if (((countNodes - index) / (countNodes * 1.0)) < 0.5) {
            currentNode = end;
            while (index != countNodes - 1) {
                index++;
                currentNode = currentNode.previous;
            }
        }
        // if index more close to the head, looking from the head
        else {
            currentNode = head;
            while (index != 0) {
                index--;
                currentNode = currentNode.next;
            }
        }

        return currentNode.data;
    }

    class Node {
        protected Node previous;
        protected Node next;
        E data;

    }
}

