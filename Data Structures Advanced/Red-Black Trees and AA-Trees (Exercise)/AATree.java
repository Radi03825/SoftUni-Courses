import java.util.function.Consumer;

class AATree<T extends Comparable<T>> {
    private Node<T> root;

    public static class Node<T> {
        T element;
        Node<T> left, right;
        int level;

        Node(T element) {
            this.element = element;
            this.level = 1;
        }
    }

    public AATree() {
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
    }

    public void insert(T element) {
        this.root = this.insert(this.root, element);
    }

    private Node<T> insert(Node<T> node, T element) {
        if (node == null) {
            return new Node<>(element);
        }

        int cmp = element.compareTo(node.element);

        if (cmp > 0) {
            node.right = insert(node.right, element);
        } else if (cmp < 0) {
            node.left = insert(node.left, element);
        } else {
            return node;
        }

        node = skew(node);
        node = split(node);

        return node;
    }

    private Node<T> skew(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else if (node.left.level == node.level) {
            return rotateRight(node);
        }

        return node;
    }

    private Node<T> split(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null || node.right.right == null) {
            return node;
        } else if (node.level == node.right.right.level) {
            node = rotateLeft(node);
            node.level += 1;

            return node;
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;

        return temp;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> temp = node.right;
        node.right = temp.left;
        temp.left = node;

        return temp;
    }

    public int countNodes() {
        return this.countNodes(this.root);
    }

    private int countNodes(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return countNodes(node.left) + countNodes(node.right) + 1;
        }
    }

    public boolean search(T element) {
        return this.search(this.root, element);
    }

    private boolean search(Node<T> node, T element) {
        if (node != null) {
            int cmp = element.compareTo(node.element);

            if (cmp > 0) {
                return search(node.right, element);
            } else if (cmp < 0) {
                return search(node.left, element);
            } else {
                return true;
            }
        }

        return false;
    }

    public void inOrder(Consumer<T> consumer) {
        this.inOrder(this.root, consumer);
    }

    private void inOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            inOrder(node.left, consumer);
            consumer.accept(node.element);
            inOrder(node.right, consumer);
        }
    }

    public void preOrder(Consumer<T> consumer) {
        this.preOrder(this.root, consumer);
    }

    private void preOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            consumer.accept(node.element);
            preOrder(node.left, consumer);
            preOrder(node.right, consumer);
        }
    }

    public void postOrder(Consumer<T> consumer) {
        this.postOrder(this.root, consumer);
    }

    private void postOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            postOrder(node.left, consumer);
            postOrder(node.right, consumer);
            consumer.accept(node.element);
        }
    }
}