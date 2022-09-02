package iterator;

import java.util.*;

// This approach can be implemented with two stacks a) one stack for NestedInteger(s)
// b) other stack for indexes.
// https://leetcode.com/problems/flatten-nested-list-iterator/solution/
//
//
//    Time complexity:
//
//        Constructor: O(1).
//
//        Pushing a list onto a stack is by reference in all the programming languages we're using here. This means that instead of creating a new list, some information about how to get to the existing list is put onto the stack. The list is not traversed, as it doesn't need reversing this time, and we're not pushing the items on one-by-one. This is, therefore, an O(1) operation.
//
//        makeStackTopAnInteger() / next() / hasNext(): O(L/N) or O(1)
//
//        Same as Approach 2.
//
//    Space complexity : O(D)
//
//    At any given time, the stack contains only one nestedList reference for each level. This is unlike the previous approach, wherein the worst case we need to put almost all elements onto the stack.
//
//    Because there's one reference on the stack at each level, the worst case is when we're looking at the deepest leveled list, giving a space complexity is O(D)O(D)O(D).
public class FlattenNestedListIteratorTwoStacks implements Iterator<Integer> {
    private Deque<List<NestedInteger>> listStack = new ArrayDeque<>();
    private Deque<Integer> indexStack = new ArrayDeque<>();

    public FlattenNestedListIteratorTwoStacks(List<NestedInteger> nestedList) {
        listStack.addFirst(nestedList);
        indexStack.addFirst(0);
    }

    public boolean hasNext() {
        makeStackTopAnInteger();
        return !indexStack.isEmpty();
    }

    private void makeStackTopAnInteger() {
        while (!indexStack.isEmpty()) {

            // If the top list is used up, pop it and its index.
            if (indexStack.peekFirst() >= listStack.peekFirst().size()) {
                indexStack.removeFirst();
                listStack.removeFirst();
                continue;
            }

            // Otherwise, if it's already an integer, we don't need to do anything.
            if (listStack.peekFirst().get(indexStack.peekFirst()).isInteger()) {
                break;
            }

            // Otherwise, it must be a list. We need to update the previous index
            // and then add the new list with an index of 0.
            listStack.addFirst(listStack.peekFirst().get(indexStack.peekFirst()).getList());
            indexStack.addFirst(indexStack.removeFirst() + 1);
            indexStack.addFirst(0);
        }
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int currentPos = indexStack.removeFirst();
        indexStack.addFirst(currentPos + 1);
        return listStack.peekFirst().get(currentPos).getInteger();
    }
}
