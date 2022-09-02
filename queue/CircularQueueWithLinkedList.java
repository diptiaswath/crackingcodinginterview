package queue;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class CircularQueueWithLinkedList {
    private int count = 0;
    private int capacity = 0;
    private Node head;
    private Node tail;


    public CircularQueueWithLinkedList(int k) {
        this.capacity = k;
    }

    // insert at tail (or rear)
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }
        Node newNode = new Node(value);
        if (count == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count+=1;
        return true;
    }

    // remove from front of queue
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        head = head.next;
        count-=1;
        return true;
    }

    // get front/head of queue
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return head.value;
    }

    // get rear/tail of queue
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == capacity);
    }
}
