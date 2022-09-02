package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// https://leetcode.com/problems/peeking-iterator/solution/
// PeekingIterator with current value stored in <i> peekedValue </i>
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peekedValue;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peekedValue() {
        if (this.peekedValue == null) {
            if (!this.iterator.hasNext()) {
                throw new NoSuchElementException();
            }
            this.peekedValue = this.iterator.next();
        }
        return this.peekedValue;
    }

    @Override
    public boolean hasNext() {
        return this.peekedValue != null || this.iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (this.peekedValue != null) {
            Integer toReturn = this.peekedValue;
            this.peekedValue = null;
            return toReturn;
        }

        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.iterator.next();
    }
}
