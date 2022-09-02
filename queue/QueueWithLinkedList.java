package queue;

class NodeNew {
    public int value;
    public NodeNew next;

    public NodeNew(int value) {
        this.value = value;
        this.next = null;
    }
}


public class QueueWithLinkedList {
    private NodeNew head;
    private NodeNew tail;

    public QueueWithLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // adds a new node after tail and then moves tail to this new node
    public void enqueue(int value) {
        NodeNew node = new NodeNew(value);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public void dequeue() {
        // If queue is empty, return NULL.
        if (this.head == null)
            return;

        // Store previous front and move front one node ahead
        NodeNew temp = this.head;
        this.head = this.head.next;

        // If head becomes NULL, then change tail also as NULL
        if (this.head == null)
            this.tail = null;
    }
}
