package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
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

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean isLess(E parent, E child) {
        return parent.compareTo(child) < 0;
    }

    private E parent(int index) {
        return this.elements.get(getParentIndex(index));
    }

    @Override
    public E peek() {
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return this.elements.get(0);
    }
}
