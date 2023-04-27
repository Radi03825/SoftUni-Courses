package implementations;

import java.util.Iterator;

public class ReversedList<E> implements Iterable<E> {
    private final int INITIAL_CAPACITY = 2;

    private Object[] elements;
    private int size;

    public ReversedList() {
        this.elements = new Object[INITIAL_CAPACITY];
    }

    public void add(E element) {
        if (this.size == elements.length) {
            this.elements = grow();
        }

        this.elements[size++] = element;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    public E get(int index) {
        if (isEmpty()) {
            return null;
        }

        int realIndex = this.size - 1 - index;

        return (E) this.elements[realIndex];
    }

    public E removeAt(int index) {
        if (isEmpty()) {
            return null;
        }

        int realIndex = this.size - 1 - index;

        this.ensureIndex(realIndex);

        E element = (E) this.elements[realIndex];

        for (int i = realIndex; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.size - 1] = null;

        this.size--;

        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return (E) elements[index--];
            }
        };
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2;
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.elements[i];
        }

        return newArray;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureIndex(int index) {
        if (index > this.size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + (this.size - 1 - index) + " out of bounds for ReversedList with length " + this.size);
        }
    }
}
