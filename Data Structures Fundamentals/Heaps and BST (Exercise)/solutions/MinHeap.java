package solutions;

import interfaces.Decrease;
import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {
    List<E> elements;

    public MinHeap() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.elements.size() - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = this.getParentIndex(index);

        while (index > 0 && isLess(index, parentIndex)) {
            Collections.swap(this.elements, index, parentIndex);
            index = parentIndex;
            parentIndex = this.getParentIndex(index);
        }
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.elements.get(0);
    }

    @Override
    public E poll() {
        E toRemove = this.elements.get(0);

        Collections.swap(this.elements, 0, this.size() - 1);
        this.elements.remove(this.size() - 1);

        this.heapifyDown(0);

        return toRemove;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);

        while (leftChildIndex < this.size()) {
            int swapIndex = leftChildIndex;
            int rightChildIndex = this.getRightChildIndex(index);

            if (rightChildIndex < this.size()) {
                swapIndex = isLess(leftChildIndex, rightChildIndex) ? leftChildIndex : rightChildIndex;
            }

            if (isLess(index, swapIndex)) {
                break;
            }

            Collections.swap(this.elements, index, swapIndex);
            index = swapIndex;
            leftChildIndex = getLeftChildIndex(index);
        }
    }

    @Override
    public void decrease(E element) {
        int elementIndex = this.elements.indexOf(element);
        E heapElement = this.elements.get(elementIndex);
        heapElement.decrease();

        this.heapifyUp(elementIndex);
    }

    private boolean isLess(int firstIndex, int secondIndex) {
        return this.elements.get(firstIndex).compareTo(this.elements.get(secondIndex)) < 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void ensureNonEmpty() {
        if (this.elements.size() == 0) {
            throw new IllegalStateException();
        }
    }
}
