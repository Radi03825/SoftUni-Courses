package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.setKey(key);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder builder = new StringBuilder();
        builder.append(createPadding(indent)).append(this.getKey());

        if (this.getLeft() != null) {
            builder.append(System.lineSeparator()).append(this.getLeft().asIndentedPreOrder(indent + 2));
        }

        if (this.getRight() != null) {
            builder.append(System.lineSeparator()).append(this.getRight().asIndentedPreOrder(indent + 2));
        }

        return builder.toString();
    }

    private String createPadding(int indent) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        ArrayList<AbstractBinaryTree<E>> trees = new ArrayList<>();
        trees.add(this);

        if (this.getLeft() != null) {
            trees.addAll(this.getLeft().preOrder());
        }

        if (this.getRight() != null) {
            trees.addAll(this.getRight().preOrder());
        }

        return trees;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        ArrayList<AbstractBinaryTree<E>> trees = new ArrayList<>();

        if (this.getLeft() != null) {
            trees.addAll(this.getLeft().inOrder());
        }

        trees.add(this);

        if (this.getRight() != null) {
            trees.addAll(this.getRight().inOrder());
        }

        return trees;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        ArrayList<AbstractBinaryTree<E>> trees = new ArrayList<>();

        if (this.getLeft() != null) {
            trees.addAll(this.getLeft().postOrder());
        }

        if (this.getRight() != null) {
            trees.addAll(this.getRight().postOrder());
        }

        trees.add(this);

        return trees;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (this.getLeft() != null) {
            this.getLeft().forEachInOrder(consumer);
        }

        consumer.accept(this.getKey());

        if (this.getRight() != null) {
            this.getRight().forEachInOrder(consumer);
        }
    }
}
