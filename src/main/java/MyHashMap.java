import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private final Node<K, V>[] hashtable;

    //length of hashtable array
    private final int multiplier;
    private int counter;

    /**
     * create HashTable with hashtable.length = 20
     */
    public MyHashMap() {
        this(20);
    }

    /**
     * @param multiplier length of hashtable
     */
    public MyHashMap(int multiplier) {
        this.multiplier = multiplier;
        hashtable = new Node[multiplier];
    }

    /**
     * @param key   key of a pair of elements
     * @param value value of a pair of elements
     * @return this hashTable
     */
    public MyHashMap put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        Node start = hashtable[indexFor(newNode.hashCode())];
        //if hashtable doesn't have elements with key.hash saving element in the first element hashtable[hash]
        if (start == null) {
            hashtable[indexFor(newNode.hashCode())] = newNode;
            counter++;
        } else {
            //if hashtable already have elements with key.hash looking to element with key.equal(key) and rewrite it
            while (start.next != null) {
                if (start.equals(newNode)) {
                    newNode.next = start.next;
                    start = newNode;
                    counter++;
                    return this;
                }
                start = start.next;
            }
            //if hashtable[hash] doesn't have elements with key.equal(key) saving element in the end of hashtable[hash]
            start.next = newNode;
            counter++;
        }
        return this;
    }

    /**
     * @param key key of element to remove
     * @return this hashTable
     */
    public MyHashMap remove(K key) {
        Node newNode = new Node<>(key, null);
        Node start = hashtable[indexFor(newNode.hashCode())];
        //if hashtable[key.hash] if null, return
        if (start == null) {
            return this;
        } else {
            //if hashtable[key.hash].equal(key) delete it
            if (start.equals(newNode)) {
                hashtable[indexFor(newNode.hashCode())] = start.next;
                counter--;
            }
            //loking to element.equal(key) and delete it
            else {
                while (start.next != null) {
                    if (start.next.equals(newNode)) {
                        start.next = start.next.next;
                        counter--;
                        return this;
                    }
                    start = start.next;
                }
            }
        }
        return this;

    }

    /**
     * delete all element from hashtable
     *
     * @return this hashTable
     */
    public MyHashMap clear() {
        Arrays.fill(hashtable, null);
        counter = 0;
        return this;
    }

    /**
     * @return count of element in hashTable
     */
    public int size() {
        return counter;
    }

    /**
     * @param key key of a pair of elements
     * @return value of a pair of elements. If key nor exist in table, return null
     */
    public V get(K key) {
        Node<K, V> newNode = new Node<>(key, null);
        Node<K, V> start = hashtable[indexFor(newNode.hashCode())];
        //If key nor exist in table, return null
        if (start == null) {
            return null;
        } else {
            if (start.equals(newNode)) {
                return start.value;
            } else {
                while (start.next != null) {
                    start = start.next;
                    if (start.equals(newNode)) {
                        return start.value;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param hash transform hash of object to index of hashTable array
     * @return int in diapason from 0 to multiplier
     */
    private int indexFor(int hash) {
        while (hash > multiplier - 1) {
            hash -= multiplier;
        }
        return hash;
    }

    class Node<K, V> {
        private final K key;
        private final V value;
        private Node next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}