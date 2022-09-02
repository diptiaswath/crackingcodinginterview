package arrays;

import java.util.Iterator;

// Cracking the coding interview Pg 330
public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        this.items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException("");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        this.items[convert(i)] = item;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }


    private class CircularArrayIterator implements Iterator<T> {
        private int current = -1;


        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public T next() {
            current++;
            return (T) items[convert(current)];

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}




