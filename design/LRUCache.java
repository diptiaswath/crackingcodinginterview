package design;

import java.util.HashMap;
import java.util.Map;

class LinkedListNode {
    int key;
    int value;
    LinkedListNode prev, next;
    public LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// https://leetcode.com/explore/interview/card/google/65/design-4/3090/
// Also on Page 522 of Cracking the coding interview
public class LRUCache {
    private int maxCacheSize;
    private Map<Integer, LinkedListNode> cache = new HashMap<Integer, LinkedListNode>();
    private LinkedListNode head;
    private LinkedListNode tail;

    public LRUCache(int capacity) {
        this.maxCacheSize = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // Move to front of list and mark as recently used
        if (node != head) {
            removeFromList(node);
            insertAtFrontOfList(node);
        }
        return node.value;
    }

    private void removeFromList(LinkedListNode node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == head) {
            this.head = head.next;
        }
        if (node == tail) {
            this.tail = node.prev;
        }
    }

    private void insertAtFrontOfList(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = head;
            head.prev = node;
            this.head = node;
        }
    }

    // Remove key,value pair from map. delete from cache and list
    public boolean removeKey(int key) {
        LinkedListNode node = cache.get(key);
        removeFromList(node);
        cache.remove(key);
        return true;
    }

    // Put (key, value) pair from Cache. If it exists already, remove old value.
    public void put(int key, int value) {
        // Remove if key already exists
        removeKey(key);

        // If Cache is full, remove least recently used key
        if (cache.size() >= maxCacheSize && this.tail != null) {
            removeKey(this.tail.key);
        }

        // Insert new node
        LinkedListNode newNode = new LinkedListNode(key, value);
        insertAtFrontOfList(newNode);
        cache.put(key, newNode);
    }
}
