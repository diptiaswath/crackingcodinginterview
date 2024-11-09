class MyStack<V> {
    int top = -1;
    int currentSize = 0;
    V[] arr;
    int maxSize = 0;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = (V[]) new Object[maxSize];
        this.top = -1;
        this.currentSize = 0;
    }

    public void push(V element) {
        if (isFull()) {
            return;
        }
        currentSize++;
        arr[++top] = element;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        currentSize--;
        return arr[top--];
    }

    public V top() {
        if (isEmpty) {
            return null;
        }
        return arr[top];
    }


    // helpers
    private boolean isFull() {
        return top == maxSize - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }
}