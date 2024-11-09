// Educative.io Problem
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-min-stack

class MinStack {
    MyStack<Integer> minStack;
    MyStack<Integer> regStack; =

    public MinStack() {
        this.minStack = new MyStack<Integer>(100);
        this.regStack = new MyStack<Integer>(100);
    }

    // If the min stack is empty and the value being pushed is less than the top value of the min stack,
    // the new value is pushed to the min stack.

    // Otherwise, the current minimum value, present at the top of the min stack is pushed again
    // in the min stack.
    public void push(int val) {
        regStack.push(val);
        if (!minStack.isEmpty() && minStack.top() < val) {
            minStack.push(minStack.top());
        } else {
            minStack.push(val);
        }
    }

    public Integer pop() {
        regStack.pop();
        return minStack.pop();
    }

    public int minNumber() {
        return minStack.top();
    }
}