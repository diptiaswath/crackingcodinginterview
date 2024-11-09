class LinkedListNode<K,V> {
    private K key;
    private V value;
    private LinkedListNode<K, V> prev;
    private LinkedListNode<K, V> next;
    LinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

// Uses Pg 340 of Cracking the Coding Interview
public class HashMapOwn {
    private ArrayList<LinkedListNode<K,V>> arr;
    public HashMapOwn(int capacity) {
        this.arr = new ArrayList<>();
        for(int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    // Public functions
    public V put(K key, V value) {
        LinkedListNode<K,V> curNode = getNodeForKey(key);
        // if node for key already exists, update to new value and return old value
        if (curNode != null) {
            V oldValue = curNode.value;
            curNode.value = value;
            return oldValue;
        }

        curNode = new LinkedListNode<K,V>();
        // insert the new node at the beginning of the linked list if arr.get(index) is not null
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            curNode.next = arr.get(index);
            curNode.next.prev = curNode;
        }
        // proceed to set the curNode at the current index
        arr.set(index, curNode);
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        LinkedListNode<K,V> curNode = getNodeForKey(key);
        return curNode == null ? null : curNode.value();
    }

    public V remove(K key) {
        LinkedListNode<K,V> curNode = getNodeForKey(key);
        if (curNode == null) {
            return null;
        }

        // if prev of curNode is not null
        if (curNode.prev != null) {
            curNode.prev.next = curNode.next;
        } else { // curNode is head, so remove head
            int index = getIndexForKey(key);
            arr.set(index, curNode.next);
        }

        // if next of curNode is not null
        if (curNode.next != null) {
            curNode.next.prev = curNode.prev;
        }
    }

    // Helper functions
    public LinkedListNode<K,V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K,V> curNode = arr.get(index);
        while (curNode != null) {
            if (curNode.key == key) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }
}