package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int INITIAL_CAPACITY = 7;

    private Object[] elements;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        this.head = middle;
        this.tail = middle;
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void offer(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            this.elements[this.head] = element;
        } else {
            if (this.head == 0) {
                this.elements = grow();
            }
            this.elements[--this.head] = element;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);

        if (this.size == 0) {
            this.addFirst(element);
            return;
        }

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft(realIndex - 1, element);
        } else {
            insertAndShiftRight(realIndex, element);
        }
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);
        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return (E) this.elements[this.head];
        }

        return null;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);
        return (E) this.elements[realIndex];
    }

    @Override
    public E get(Object object) {
        if (isEmpty()) {
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return (E) this.elements[i];
            }
        }

        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            shiftRight(realIndex);
            this.elements[this.head] = null;
            this.head++;
        } else {
            shiftLeft(realIndex);
            this.elements[this.tail] = null;
            this.tail--;
        }

        this.size--;

        return (E) this.elements[realIndex];
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()) {
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = (E) this.elements[i];

                for (int j = i; j < this.tail; j++) {
                    this.elements[j] = this.elements[j + 1];
                }

                this.removeLast();

                return element;
            }
        }

        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            Object element = this.elements[this.head];

            this.elements[this.head] = null;
            this.head++;
            this.size--;

            return (E) element;
        }

        return null;
    }

    @Override
    public E removeLast() {
        if(!isEmpty()) {
            Object element = this.elements[this.tail];

            this.elements[this.tail] = null;
            this.tail--;
            this.size--;

            return (E) element;
        }

        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;

        for (int i = this.head; i < this.tail; i++) {
            newElements[index++] = this.elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }

    private Object[] grow() {
        Object[] newArray = new Object[this.elements.length * 2 + 1];

        int middle = newArray.length / 2;
        int begin = middle - this.size / 2;
        int index = this.head;

        for (int i = begin; index <= this.tail; i++) {
            newArray[i] = this.elements[index++];
        }

        this.head = begin;
        this.tail = this.head + this.size - 1;

        return newArray;
    }

    private void ensureIndex(int index) {
        if (index < this.head || index > this.tail) {
            throw new IndexOutOfBoundsException("Index out of bound for index: " + (index - this.head));
        }
    }

    private void shiftRight(int realIndex) {
        for (int i = realIndex; i > this.head; i--) {
            this.elements[i] = this.elements[i - 1];
        }
    }

    private void shiftLeft(int realIndex) {
        for (int i = realIndex; i < this.tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void insertAndShiftRight(int realIndex, E element) {
        E lastElement = (E) this.elements[this.tail];

        for (int i = this.tail; i > realIndex; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[realIndex] = element;
        this.addLast(lastElement);
    }

    private void insertAndShiftLeft(int realIndex, E element) {
        E firstElement = (E) this.elements[this.head];

        for (int i = this.head; i <= realIndex; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[realIndex] = element;
        this.addFirst(firstElement);
    }
}
