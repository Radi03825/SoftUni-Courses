package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> root) {
        this.root = new Node<>(root.value, root.leftChild, root.rightChild);
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if (this.getRoot() == null) {
            this.root = newNode;
        } else {
            Node<E> current = this.root;
            Node<E> previous = current;

            while (current != null) {
                previous = current;
                if (isLess(element, current.value)) {
                    current = current.leftChild;
                } else if (isGreater(element, current.value)) {
                    current = current.rightChild;
                } else {
                    return;
                }
            }

            if (isLess(element, previous.value)) {
                previous.leftChild = newNode;
            } else if (isGreater(element, previous.value)) {
                previous.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        return this.search(element) != null;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> current = this.root;

        while (current != null) {
            if (isLess(element, current.value)) {
                current = current.leftChild;
            } else if (isGreater(element, current.value)) {
                current = current.rightChild;
            } else if(areEqual(element, current.value)) {
                return new BinarySearchTree<>(current);
            }
        }

        return null;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.root.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    private boolean areEqual(E first, E second) {
        return first.compareTo(second) == 0;
    }

    private boolean isGreater(E first, E second) {
        return first.compareTo(second) > 0;
    }

    private boolean isLess(E first, E second) {
        return first.compareTo(second) < 0;
    }

}
