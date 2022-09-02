package iterator;

import java.util.*;

// https://leetcode.com/problems/flatten-nested-list-iterator/solution/
// Approach2: Downside of Approach1 is that it uses a recursive approach using a new data structure
// instead of simply iterating over the give one.
public class FlattenNestedListIteratorStack implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    // Time complexity: O(N + L), Space Complexity O(N + L)
    public FlattenNestedListIteratorStack(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>(nestedList);
    }

    // Time complexity: O(L/N) or o(1)
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return stack.removeFirst().getInteger();
    }

    public boolean hasNext() {
        // Check if there are integers left by getting one onto the top of stack.
        makeStackTopAnInteger();
        return !stack.isEmpty();
    }

    //makeStackTopAnInteger() must have seen every integer at least once, costing O(N) time.
    // Additionally, it has seen every list (except the first) on the stack at least once also, so this costs O(L)time.
    // Adding these together, we get O(N+L)time.
    //
    //The amortized time of a single makeStackTopAnInteger is the total cost, O(N+L), divided by the number of times it's called.
    // This gives us an amortized time complexity of O(N+L)/N ~= O(L/N)
    private void makeStackTopAnInteger() {
        while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
            List<NestedInteger> nestedIntegerList = stack.removeFirst().getList();
            for (int i = nestedIntegerList.size() - 1; i >=0; i--) {
                stack.addFirst(nestedIntegerList.get(i));
            }
        }
    }
}
