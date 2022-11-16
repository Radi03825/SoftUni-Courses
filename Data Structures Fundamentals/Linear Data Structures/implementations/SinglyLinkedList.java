package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> node = new Node<>(element);

        node.next = this.head;
        this.head = node;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> node = new Node<>(element);

        if (isEmpty()) {
            this.head = node;
        } else {
            Node<E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();

        Node<E> head = this.head;

        this.head = this.head.next;

        this.size--;

        return head.element;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();

        Node<E> current = this.head;

        while (current.next.next != null) {
            current = current.next;
        }

        E element = current.next.element;
        current.next = null;

        this.size--;

        return element;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();
        return this.head.element;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();

        Node<E> current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        return current.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;

                current = current.next;

                return element;
            }
        };
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("SinglyLinkedList is empty");
        }
    }
}
