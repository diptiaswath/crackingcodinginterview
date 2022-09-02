package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// https://leetcode.com/problems/peeking-iterator/solution/
// PeekingIterator implementation with next value stored
// Intuition
////
//Instead of only storing the next value after we've peeked at it,
// we can store it immediately in the constructor and then again in the next(...) method.
// This greatly simplifies the code, because we no longer need conditionals to check whether
// or not we are currently storing a peeked at value.
public class PeekingIteratorWithNext implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next = null;

    public PeekingIteratorWithNext(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        this.next = this.iterator.next();
    }

    public Integer peek() {
        return this.next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        Integer toReturn = this.next;
        this.next = null;
        if (this.iterator.hasNext()) {
            this.next = this.iterator.next();
        }
        return toReturn;
    }
}
