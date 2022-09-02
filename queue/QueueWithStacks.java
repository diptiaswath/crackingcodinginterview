package queue;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/solution/
// Great explanation
class QueueWithStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    public QueueWithStacks() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }

    // O(n) operation
    // A queue is FIFO (first-in-first-out) but a stack is LIFO (last-in-first-out).
    // This means the newest element must be pushed to the bottom of the stack.
    // To do so we first transfer all s1 elements to auxiliary stack s2.
    // Then the newly arrived element is pushed on top of s2 and all its elements are popped and pushed to s1.
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        int x = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return x;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

