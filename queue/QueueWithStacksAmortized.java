package queue;

import java.util.Stack;

// See Approach2 : https://leetcode.com/problems/implement-queue-using-stacks/solution/
public class QueueWithStacksAmortized {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public QueueWithStacksAmortized() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    // O(1) is S2 is not empty. Else, push all S1 elements to S2 and pop top could be O(n)
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
}
