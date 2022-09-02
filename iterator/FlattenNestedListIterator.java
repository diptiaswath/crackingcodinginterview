package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

//https://leetcode.com/problems/flatten-nested-list-iterator/solution/
// Approach1: Uses recursion in constructor.

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// N = Total no of integers within the nested list
// L = Total no of lists within the nested list
// D = Max nesting depth, ie., max no of lists within each other
public class FlattenNestedListIterator implements Iterator<Integer> {
    private List<Integer> flattenedList;
    private int index;

    // Time complexity is O(N + L)
    // FlattenList is called for L lists. Loop within flatten list will
    // then iterate n times, where n = # of integers in that list.
    // Time complexity = # of lists plus # of integers
    // Space complexity is O(N + D). Max number of stack frames on the runtime stack is the max nesting depth.
    // The flattenList could be called for N integers. Both happen one after another. So O(N+D)
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.flattenedList = new ArrayList<>();
        this.index = 0;
        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (NestedInteger nestInt : nestedList) {
            if (nestInt.isInteger()) {
                this.flattenedList.add(nestInt.getInteger());
            } else {
                flattenList(nestInt.getList());
            }
        }
    }

    // Time complexity: O(1)
    @Override
    public boolean hasNext() {
        return index < flattenedList.size();
    }

    // Time complexity: O(1)
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return flattenedList.get(index++);
    }
}
