package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLess(parent(index), elements.get(index))) {
            int parentIndex = getParentIndex(index);
            Collections.swap(this.elements, parentIndex, index);
            index = parentIndex;
        }
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.elements.get(0);
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E value = this.elements.get(0);
        Collections.swap(this.elements, 0, this.size() - 1);
        this.elements.remove(this.size() - 1);
        this.heapifyDown(0);

        return value;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < this.size() && isLess(this.elements.get(index), getLeftChild(index))) {
            int child = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            if (rightChildIndex < this.size() && isLess(this.elements.get(child), getRightChild(index))) {
                child = rightChildIndex;
            }

            Collections.swap(this.elements,  child, index);
            index = child;
        }
    }

    private E getRightChild(int index) {
        return this.elements.get(getRightChildIndex(index));
    }

    private E getLeftChild(int index) {
        return this.elements.get(getLeftChildIndex(index));
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean isLess(E parent, E child) {
        return parent.compareTo(child) < 0;
    }

    private E parent(int index) {
        return this.elements.get(getParentIndex(index));
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void ensureNonEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
    }
}
