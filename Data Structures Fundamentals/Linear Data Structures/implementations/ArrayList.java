package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            grow();
        }

        this.elements[size] = element;
        this.size++;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        insertElement(index, element);
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        Object element = this.elements[index];

        return (E) element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        Object previousElement = this.elements[index];
        this.elements[index] = element;

        return (E) previousElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Object element = this.elements[index];

        removeElement(index);
        ensureCapacity();

        return (E) element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        Object[] newArray = new Object[this.elements.length * 2];

        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }

        this.elements = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for ArrayList with length " + this.elements.length);
        }
    }

    private void insertElement(int index, E element) {
        if (this.size == this.elements.length) {
            grow();
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = element;
        this.size++;
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            shrink();
        }
    }

    private void shrink() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    private void removeElement(int index) {
        this.size--;

        for (int i = index + 1; i <= this.size; i++) {
            this.elements[i - 1] = this.elements[i];
        }

        this.elements[this.size] = null;
    }
}
